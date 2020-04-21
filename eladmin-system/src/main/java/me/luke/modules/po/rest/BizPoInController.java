package me.luke.modules.po.rest;

import me.luke.aop.log.Log;
import me.luke.modules.po.domain.BizPoIn;
import me.luke.modules.po.service.BizPoInService;
import me.luke.modules.po.service.dto.BizPoInDto;
import me.luke.modules.po.service.dto.BizPoInQueryCriteria;
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
* @date 2020-04-17
*/
@Api(tags = "采购入库单管理")
@RestController
@RequestMapping("/api/bizPoIn")
public class BizPoInController {

    private final BizPoInService bizPoInService;

    public BizPoInController(BizPoInService bizPoInService) {
        this.bizPoInService = bizPoInService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('bizPoIn:list')")
    public void download(HttpServletResponse response, BizPoInQueryCriteria criteria) throws IOException {
        bizPoInService.download(bizPoInService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询采购入库单")
    @ApiOperation("查询采购入库单")
    @PreAuthorize("@el.check('bizPoIn:list')")
    public ResponseEntity<Object> getBizPoIns(BizPoInQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(bizPoInService.queryAll(criteria,pageable),HttpStatus.OK);
    }
    @GetMapping(value = "/get/{poId}")
    @Log("查询采购入库单")
    @ApiOperation("查询采购入库单")
    @PreAuthorize("@el.check('bizPoIn:list')")
    public ResponseEntity<Object> getBizPoInById(@PathVariable String poId){
        BizPoInDto data = new BizPoInDto();
        if (Long.parseLong(poId) <=0)
        {
            data.setId(-1l);//-1表示新增
        }else
        {
            data = bizPoInService.findById(Long.parseLong(poId));
        }
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @PostMapping
    @Log("新增采购入库单")
    @ApiOperation("新增采购入库单")
    @PreAuthorize("@el.check('bizPoIn:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody BizPoIn resources){
        return new ResponseEntity<>(bizPoInService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改采购入库单")
    @ApiOperation("修改采购入库单")
    @PreAuthorize("@el.check('bizPoIn:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody BizPoIn resources){
        bizPoInService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除采购入库单")
    @ApiOperation("删除采购入库单")
    @PreAuthorize("@el.check('bizPoIn:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        bizPoInService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}