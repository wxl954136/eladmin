package me.luke.modules.system.rest;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.luke.aop.log.Log;
import me.luke.config.DataScope;
import me.luke.exception.BadRequestException;
import me.luke.modules.security.security.vo.JwtUser;
import me.luke.modules.system.domain.SysSkuClassify;
import me.luke.modules.system.service.SysSkuClassifyService;
import me.luke.modules.system.service.dto.SysSkuClassifyDto;
import me.luke.modules.system.service.dto.SysSkuClassifyQueryCriteria;
import me.luke.modules.system.service.mapper.SysSkuClassifyMapper;
import me.luke.utils.RedisUtils;
import me.luke.utils.ThrowableUtil;
import me.luke.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @author lukeWang
* @date 2020-03-25
*/
@Slf4j
@RestController
@Api(tags = "系统：商品分类管理")
@RequestMapping("/api/sysSkuClassify")
public class SysSkuClassifyController {

    private final SysSkuClassifyService sysSkuClassifyService;

    private final DataScope dataScope;

    private static final String ENTITY_NAME = "sysSkuClassify";
    @Autowired
    private  RedisUtils redisUtils;
    //因为下面有定义，所以不需要全局定义
    //全局注解，相当于 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    @Autowired
    private HttpServletRequest request;




    public SysSkuClassifyController(SysSkuClassifyService sysSkuClassifyService, DataScope dataScope) {
        this.sysSkuClassifyService = sysSkuClassifyService;
        this.dataScope = dataScope;
    }

    @Log("导出商品分类数据")
    @ApiOperation("导出商品分类数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('classify:list')")
    public void download(HttpServletResponse response, SysSkuClassifyQueryCriteria criteria) throws IOException {
        sysSkuClassifyService.download(sysSkuClassifyService.queryAll(criteria), response);
    }

    @Log("查询部门")
    @ApiOperation("查询部门")
    @GetMapping
    @PreAuthorize("@el.check('classify:list')")
    public ResponseEntity<Object> getSysSkuClassifys(SysSkuClassifyQueryCriteria criteria){
        // 数据权限
        //获取缓存方法示例
        JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
       // criteria.setIds(dataScope.getSysSkuClassifyIds());
        criteria.setTopCompanyCode(jwtUser.getTopCompanyCode());
        criteria.setIsDelete(false);  //如何设置公共条件呢
        List<SysSkuClassifyDto> sysSkuClassifyDtos = sysSkuClassifyService.queryAll(criteria);

        return new ResponseEntity<>(sysSkuClassifyService.buildTree(sysSkuClassifyDtos),HttpStatus.OK);
    }

    @Log("新增商品分类")
    @ApiOperation("新增商品分类")
    @PostMapping
    @PreAuthorize("@el.check('classify:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody SysSkuClassify resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        JwtUser jwtUser = (JwtUser)UserUtil.getLoginUser(redisUtils,request);
        resources.setTopCompanyCode(jwtUser.getTopCompanyCode());
        resources.setKeywords(IdUtil.simpleUUID());

        return new ResponseEntity<>(sysSkuClassifyService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改商品分类")
    @ApiOperation("修改商品分类")
    @PutMapping
    @PreAuthorize("@el.check('classify:edit')")
    public ResponseEntity<Object> update(@Validated(SysSkuClassify.Update.class) @RequestBody SysSkuClassify resources){
        //JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        //修改时不允许删除
        resources.setIsDelete(false);
        sysSkuClassifyService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //删除记录，更改逻辑删除

    @Log("删除部门")
    @ApiOperation("删除部门")
    @DeleteMapping
    @PreAuthorize("@el.check('classify:del')")
    //@Validated @RequestBody
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids){
        Set<SysSkuClassifyDto> sysSkuClassifyDtos = new HashSet<>();
        for (Long id : ids) {
            List<SysSkuClassify> sysSkuClassifyList = sysSkuClassifyService.findByPid(id);
            sysSkuClassifyDtos.add(sysSkuClassifyService.findById(id));
            if(CollectionUtil.isNotEmpty(sysSkuClassifyList)){
                sysSkuClassifyDtos = sysSkuClassifyService.getDeleteSysSkuClassifys(sysSkuClassifyList, sysSkuClassifyDtos);
            }
        }

        try {
            sysSkuClassifyService.delete(sysSkuClassifyDtos);
        }catch (Throwable e){
            ThrowableUtil.throwForeignKeyException(e, "所选的商品分类和商品存在关联，请取消关联后再试");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}