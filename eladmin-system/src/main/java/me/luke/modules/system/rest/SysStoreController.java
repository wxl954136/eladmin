package me.luke.modules.system.rest;

import cn.hutool.core.util.IdUtil;
import me.luke.aop.log.Log;
import me.luke.modules.security.security.vo.JwtUser;
import me.luke.modules.system.domain.SysStore;
import me.luke.modules.system.service.SysStoreService;
import me.luke.modules.system.service.dto.SysStoreDto;
import me.luke.modules.system.service.dto.SysStoreQueryCriteria;
import me.luke.utils.RedisUtils;
import me.luke.utils.StringUtils;
import me.luke.utils.UserUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Api(tags = "仓库管理")
@RestController
@RequestMapping("/api/sysStore")
public class SysStoreController {

    private final SysStoreService sysStoreService;
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private HttpServletRequest request;

    public SysStoreController(SysStoreService sysStoreService) {
        this.sysStoreService = sysStoreService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('sysStore:list')")
    public void download(HttpServletResponse response, SysStoreQueryCriteria criteria) throws IOException {
        sysStoreService.download(sysStoreService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询仓库")
    @ApiOperation("查询仓库")
    @PreAuthorize("@el.check('sysStore:list')")
    public ResponseEntity<Object> getSysStores(SysStoreQueryCriteria criteria, Pageable pageable){
        JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        criteria.setTopCompanyCode(jwtUser.getTopCompanyCode());
        return new ResponseEntity<>(sysStoreService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增仓库")
    @ApiOperation("新增仓库")
    @PreAuthorize("@el.check('sysStore:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody SysStore resources){
        JwtUser jwtUser = (JwtUser) UserUtil.getLoginUser(redisUtils,request);
        resources.setTopCompanyCode(jwtUser.getTopCompanyCode());
        resources.setKeywords(StringUtils.getUUID(resources.getKeywords()));
        return new ResponseEntity<>(sysStoreService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改仓库")
    @ApiOperation("修改仓库")
    @PreAuthorize("@el.check('sysStore:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody SysStore resources){
        sysStoreService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除仓库")
    @ApiOperation("删除仓库中")
    @PreAuthorize("@el.check('sysStore:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        Set<SysStoreDto> storeDtos = new HashSet<>();
        for(Long id:ids){
            storeDtos.add(sysStoreService.findById(id));
        }
        sysStoreService.deleteAll(storeDtos);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
  Set<DeptDto> deptDtos = new HashSet<>();
        for (Long id : ids) {
            List<Dept> deptList = deptService.findByPid(id);
            deptDtos.add(deptService.findById(id));
            if(CollectionUtil.isNotEmpty(deptList)){
                deptDtos = deptService.getDeleteDepts(deptList, deptDtos);
            }
        }


     */


/*
    @Log("删除仓库")
    @ApiOperation("删除仓库中")
    @PreAuthorize("@el.check('sysStore:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        sysStoreService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

 */
}