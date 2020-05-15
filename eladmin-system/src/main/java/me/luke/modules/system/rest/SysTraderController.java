package me.luke.modules.system.rest;

import me.luke.aop.log.Log;
import me.luke.modules.security.security.vo.JwtUser;
import me.luke.modules.system.domain.SysTrader;
import me.luke.modules.system.service.SysTraderService;
import me.luke.modules.system.service.dto.SysTraderQueryCriteria;
import me.luke.modules.utils.RedisUtils;
import me.luke.modules.utils.StringUtils;
import me.luke.modules.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author lukeWang
* @date 2020-04-16
*/
@Api(tags = "trader管理")
@RestController
@RequestMapping("/api/sysTrader")
public class SysTraderController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private HttpServletRequest request;

    private final SysTraderService sysTraderService;

    public SysTraderController(SysTraderService sysTraderService) {
        this.sysTraderService = sysTraderService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('trader:list')")
    public void download(HttpServletResponse response, SysTraderQueryCriteria criteria) throws IOException {
        JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        criteria.setTopCompanyCode(jwtUser.getTopCompanyCode());
        sysTraderService.download(sysTraderService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询往来单位")
    @ApiOperation("查询往来单位")
    @PreAuthorize("@el.check('trader:list')")
    public ResponseEntity<Object> getSysTraders(SysTraderQueryCriteria criteria, Pageable pageable){
        JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        criteria.setTopCompanyCode(jwtUser.getTopCompanyCode());
        return new ResponseEntity<>(sysTraderService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增往来单位")
    @ApiOperation("新增往来单位")
    @PreAuthorize("@el.check('trader:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody SysTrader resources){
        JwtUser jwtUser = (JwtUser) UserUtil.getLoginUser(redisUtils,request);
        resources.setTopCompanyCode(jwtUser.getTopCompanyCode());
        resources.setKeywords(StringUtils.getUUID(resources.getKeywords()));
        return new ResponseEntity<>(sysTraderService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改往来单位")
    @ApiOperation("修改往来单位")
    @PreAuthorize("@el.check('trader:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody SysTrader resources){
        sysTraderService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除往来单位")
    @ApiOperation("删除往来单位")
    @PreAuthorize("@el.check('trader:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        sysTraderService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}