package me.luke.modules.system.rest;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.luke.aop.log.Log;
import me.luke.config.DataScope;
import me.luke.exception.BadRequestException;
import me.luke.modules.security.config.SecurityProperties;
import me.luke.modules.security.security.vo.JwtUser;
import me.luke.modules.system.domain.Dept;
import me.luke.modules.system.service.DeptService;
import me.luke.modules.system.service.UserService;
import me.luke.modules.system.service.dto.DeptDto;
import me.luke.modules.system.service.dto.DeptQueryCriteria;
import me.luke.modules.system.service.mapper.DeptMapper;
import me.luke.utils.RedisUtils;
import me.luke.utils.ThrowableUtil;
import me.luke.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Slf4j
@RestController
@Api(tags = "系统：部门管理")
@RequestMapping("/api/dept")
public class DeptController {

    private final DeptService deptService;

    private final DataScope dataScope;

    private static final String ENTITY_NAME = "dept";
    @Autowired
    private  RedisUtils redisUtils;
    //因为下面有定义，所以不需要全局定义
    //全局注解，相当于 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @Autowired
    private  DeptMapper deptMapper;


    public DeptController(DeptService deptService, DataScope dataScope) {
        this.deptService = deptService;
        this.dataScope = dataScope;
    }

    @Log("导出部门数据")
    @ApiOperation("导出部门数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('dept:list')")
    public void download(HttpServletResponse response, DeptQueryCriteria criteria) throws IOException {
        deptService.download(deptService.queryAll(criteria), response);
    }

    @Log("查询部门")
    @ApiOperation("查询部门")
    @GetMapping
    @PreAuthorize("@el.check('user:list','dept:list')")
    public ResponseEntity<Object> getDepts(DeptQueryCriteria criteria){
        // 数据权限
        //获取缓存方法示例

        JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        criteria.setIds(dataScope.getDeptIds());
        criteria.setTopCompanyCode(jwtUser.getTopCompanyCode());
        criteria.setIsDelete(false);  //如何设置公共条件呢
        List<DeptDto> deptDtos = deptService.queryAll(criteria);

        return new ResponseEntity<>(deptService.buildTree(deptDtos),HttpStatus.OK);
    }

    @Log("新增部门")
    @ApiOperation("新增部门")
    @PostMapping
    @PreAuthorize("@el.check('dept:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Dept resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        JwtUser jwtUser = (JwtUser)UserUtil.getLoginUser(redisUtils,request);
        resources.setTopCompanyCode(jwtUser.getTopCompanyCode());
        resources.setKeywords(IdUtil.simpleUUID());
        return new ResponseEntity<>(deptService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改部门")
    @ApiOperation("修改部门")
    @PutMapping
    @PreAuthorize("@el.check('dept:edit')")
    public ResponseEntity<Object> update(@Validated(Dept.Update.class) @RequestBody Dept resources){
        //JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        //修改时不允许删除
        resources.setIsDelete(false);
        deptService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /*
    @Log("删除部门")
    @ApiOperation("删除部门")
    @DeleteMapping
    @PreAuthorize("@el.check('dept:del')")
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids){
        log.info("1------");
        Set<DeptDto> deptDtos = new HashSet<>();
        for (Long id : ids) {
            List<Dept> deptList = deptService.findByPid(id);
            //deptDtos.add(deptService.findById(id));  删除的全部逻辑删除标记
            DeptDto deptDto = deptService.findById(id);
            deptDto.setIsDelete(true);
            deptDtos.add(deptDto);
            if(CollectionUtil.isNotEmpty(deptList)){
                deptDtos = deptService.getDeleteDdeptService.update(resources);epts(deptList, deptDtos);
            }
        }
        try {
            //删除的全部逻辑删除标记
            //deptService.delete(deptDtos);
            for(DeptDto deptDto:deptDtos)
            {
                deptService.update(deptMapper.toEntity(deptDto));
            }
        }catch (Throwable e){
            ThrowableUtil.throwForeignKeyException(e, "所选部门中存在岗位或者角色关联，请取消关联后再试");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    */

    //删除记录，更改逻辑删除

    @Log("删除部门")
    @ApiOperation("删除部门")
    @DeleteMapping
    @PreAuthorize("@el.check('dept:del')")
    //@Validated @RequestBody
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids){
        Set<DeptDto> deptDtos = new HashSet<>();
        for (Long id : ids) {
            List<Dept> deptList = deptService.findByPid(id);
            deptDtos.add(deptService.findById(id));
            if(CollectionUtil.isNotEmpty(deptList)){
                deptDtos = deptService.getDeleteDepts(deptList, deptDtos);
            }
        }
        boolean isFoundRelFromUser = false;
        JwtUser jwtUser = (JwtUser) UserUtil.getLoginUser(redisUtils,request);
        for(DeptDto deptDto:deptDtos){
            if (userService.findByDeptUseCount(deptDto.getId(),jwtUser.getTopCompanyCode()) > 0 )
            {
                isFoundRelFromUser = true;
                break;
            }
        }
        if (isFoundRelFromUser) {throw new BadRequestException("所选部门中存在岗位或者角色关联，请取消关联后再试！");}
        try {
            deptService.delete(deptDtos);
        }catch (Throwable e){
            ThrowableUtil.throwForeignKeyException(e, "所选部门中存在岗位或者角色关联，请取消关联后再试");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
/*
    @Log("删除部门")
    @ApiOperation("删除部门")
    @DeleteMapping
    @PreAuthorize("@el.check('dept:del')")
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids){
        Set<DeptDto> deptDtos = new HashSet<>();
        for (Long id : ids) {
            List<Dept> deptList = deptService.findByPid(id);
            deptDtos.add(deptService.findById(id));
            if(CollectionUtil.isNotEmpty(deptList)){
                deptDtos = deptService.getDeleteDepts(deptList, deptDtos);
            }
        }
        try {
            deptService.delete(deptDtos);
        }catch (Throwable e){
            ThrowableUtil.throwForeignKeyException(e, "所选部门中存在岗位或者角色关联，请取消关联后再试");
}
        return new ResponseEntity<>(HttpStatus.OK);
        }
        */

}