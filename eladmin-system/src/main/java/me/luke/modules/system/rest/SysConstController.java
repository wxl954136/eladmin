package me.luke.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luke.aop.log.Log;


import me.luke.modules.system.service.SysConstService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "固定信息:应付款等")
@RestController
@RequestMapping("/api/sysConst")
public class SysConstController {

    private final SysConstService sysConstService ;

    public SysConstController(SysConstService sysConstService){
        this.sysConstService  =  sysConstService;
    }

    @GetMapping
    @Log("应付款收款方式获取")
    @ApiOperation("应付款收款方式获取")
  //  @PreAuthorize("@el.check('sysConst:list')")
    public ResponseEntity<Object> getSysConst(String type){
        System.out.println("c---------"  +type);
        return new ResponseEntity<>(sysConstService.findByType(type), HttpStatus.OK);
    }
}
