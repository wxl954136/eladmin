package me.luke.modules.po.rest;

import me.luke.aop.log.Log;
import me.luke.modules.po.domain.BizPoIn;
import me.luke.modules.po.service.BizPoInService;
import me.luke.modules.po.service.BizTradeSerialFlowService;
import me.luke.modules.po.service.dto.BizPoInDetailDto;
import me.luke.modules.po.service.dto.BizPoInDto;
import me.luke.modules.po.service.dto.BizPoInQueryCriteria;
import me.luke.modules.security.security.vo.JwtUser;
import me.luke.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
* @date 2020-04-17
*/
@Api(tags = "采购入库单管理")
@RestController
@RequestMapping("/api/bizPoIn")
public class BizPoInController {
    private static final Logger logger = LoggerFactory.getLogger(BizPoInController.class);
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private HttpServletRequest request;

    private final BizPoInService bizPoInService;
    private final BizTradeSerialFlowService bizTradeSerialFlowService;

    public BizPoInController(BizPoInService bizPoInService, BizTradeSerialFlowService bizTradeSerialFlowService) {
        this.bizPoInService = bizPoInService;
        this.bizTradeSerialFlowService = bizTradeSerialFlowService;
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
    public ResponseEntity<Object> getBizPoInById(@PathVariable String poId) {
        BizPoInDto data = new BizPoInDto();
        if (Long.parseLong(poId) <= 0) {
            data.setId(-1l);//-1表示新增

            return null;
        } else {
            data = bizPoInService.findById(Long.parseLong(poId));
            //查找复合主键映射方法
            //注意获取串号明细表
            if (data.getBizPoInDetails() != null && data.getBizPoInDetails().size() > 0) {
                for (BizPoInDetailDto detailDto : data.getBizPoInDetails()) {
                    if (detailDto.getSysSku().getCostFlag()) {
                        detailDto.setBizTradeSerialFlow(bizTradeSerialFlowService.findByBizDetailKeywords(detailDto.getKeywords(), SysStatusEnum.BIZ_NOTE_TYPE_PO_PI.getValue()));
                    }
                }
            }
        }
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @PostMapping
    @Log("新增采购入库单")
    @ApiOperation("新增采购入库单")
    @PreAuthorize("@el.check('bizPoIn:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody BizPoIn resources){
        JwtUser jwtUser = (JwtUser) UserUtil.getLoginUser(redisUtils,request);
        resources.setTopCompanyCode(jwtUser.getTopCompanyCode());
      //  resources.setKeywords(StringUtils.getUUID(resources.getKeywords()));
        resources.setBizType(SysStatusEnum.BIZ_NOTE_TYPE_PO_PI.getValue());
        return new ResponseEntity<>(bizPoInService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改采购入库单")
    @ApiOperation("修改采购入库单")
    @PreAuthorize("@el.check('bizPoIn:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody BizPoIn resources){

        bizPoInService.update(resources);
       // return new ResponseEntity<>(genConfigService.update(genConfig.getTableName(), genConfig),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("删除采购入库单")
    @ApiOperation("删除采购入库单")
    @PreAuthorize("@el.check('bizPoIn:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        Set<BizPoInDto> bizPoInDtos = new HashSet<>();
        for(Long id:ids){
            bizPoInDtos.add(bizPoInService.findById(id));
        }
        bizPoInService.deleteAll(bizPoInDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}