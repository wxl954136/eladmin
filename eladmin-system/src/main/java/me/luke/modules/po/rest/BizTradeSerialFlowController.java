package me.luke.modules.po.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luke.aop.log.Log;
import me.luke.modules.po.domain.BizTradeSerialFlow;
import me.luke.modules.po.service.BizTradeSerialFlowService;
import me.luke.modules.po.service.dto.BizTradeSerialFlowQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @author lukeWang
* @date 2020-05-05
*/
@Api(tags = "bizTradeSerialFlow管理")
@RestController
@RequestMapping("/api/bizTradeSerialFlow")
public class BizTradeSerialFlowController {

    private final BizTradeSerialFlowService bizTradeSerialFlowService;

    public BizTradeSerialFlowController(BizTradeSerialFlowService bizTradeSerialFlowService) {
        this.bizTradeSerialFlowService = bizTradeSerialFlowService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('bizTradeSerialFlow:list')")
    public void download(HttpServletResponse response, BizTradeSerialFlowQueryCriteria criteria) throws IOException {
        bizTradeSerialFlowService.download(bizTradeSerialFlowService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询bizTradeSerialFlow")
    @ApiOperation("查询bizTradeSerialFlow")
    @PreAuthorize("@el.check('bizTradeSerialFlow:list')")
    public ResponseEntity<Object> getBizTradeSerialFlows(BizTradeSerialFlowQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(bizTradeSerialFlowService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增bizTradeSerialFlow")
    @ApiOperation("新增bizTradeSerialFlow")
    @PreAuthorize("@el.check('bizTradeSerialFlow:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody BizTradeSerialFlow resources){
        return new ResponseEntity<>(bizTradeSerialFlowService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改bizTradeSerialFlow")
    @ApiOperation("修改bizTradeSerialFlow")
    @PreAuthorize("@el.check('bizTradeSerialFlow:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody BizTradeSerialFlow resources){
        bizTradeSerialFlowService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除bizTradeSerialFlow")
    @ApiOperation("删除bizTradeSerialFlow")
    @PreAuthorize("@el.check('bizTradeSerialFlow:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        bizTradeSerialFlowService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}