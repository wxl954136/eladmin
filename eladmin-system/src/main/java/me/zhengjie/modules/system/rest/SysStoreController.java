package me.zhengjie.modules.system.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.system.domain.SysStore;
import me.zhengjie.modules.system.service.SysStoreService;
import me.zhengjie.modules.system.service.dto.SysStoreQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
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
        return new ResponseEntity<>(sysStoreService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增仓库")
    @ApiOperation("新增仓库")
    @PreAuthorize("@el.check('sysStore:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody SysStore resources){
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
        sysStoreService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}