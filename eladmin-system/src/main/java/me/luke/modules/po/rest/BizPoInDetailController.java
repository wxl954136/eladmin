package me.luke.modules.po.rest;

import me.luke.aop.log.Log;
import me.luke.modules.po.domain.BizPoInDetail;
import me.luke.modules.po.service.BizPoInDetailService;
import me.luke.modules.po.service.dto.BizPoInDetailQueryCriteria;
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
* @date 2020-04-18
*/
@Api(tags = "采购入库单明细管理")
@RestController
@RequestMapping("/api/bizPoInDetail")
public class BizPoInDetailController {

    private final BizPoInDetailService bizPoInDetailService;

    public BizPoInDetailController(BizPoInDetailService bizPoInDetailService) {
        this.bizPoInDetailService = bizPoInDetailService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('bizPoIn:list')")
    public void download(HttpServletResponse response, BizPoInDetailQueryCriteria criteria) throws IOException {
        bizPoInDetailService.download(bizPoInDetailService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询/api/bizPoInDetail")
    @ApiOperation("查询/api/bizPoInDetail")
    @PreAuthorize("@el.check('bizPoIn:list')")
    public ResponseEntity<Object> getBizPoInDetails(BizPoInDetailQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(bizPoInDetailService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增/api/bizPoInDetail")
    @ApiOperation("新增/api/bizPoInDetail")
    @PreAuthorize("@el.check('bizPoIn:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody BizPoInDetail resources){
        return new ResponseEntity<>(bizPoInDetailService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改/api/bizPoInDetail")
    @ApiOperation("修改/api/bizPoInDetail")
    @PreAuthorize("@el.check('bizPoIn:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody BizPoInDetail resources){
        bizPoInDetailService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除/api/bizPoInDetail")
    @ApiOperation("删除/api/bizPoInDetail")
    @PreAuthorize("@el.check('bizPoIn:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        bizPoInDetailService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}