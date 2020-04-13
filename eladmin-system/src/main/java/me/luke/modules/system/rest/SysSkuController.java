package me.luke.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.luke.aop.log.Log;
import me.luke.config.DataScope;
import me.luke.modules.security.security.vo.JwtUser;
import me.luke.modules.system.domain.SysSku;
import me.luke.modules.system.service.SysSkuClassifyService;
import me.luke.modules.system.service.SysSkuService;
import me.luke.modules.system.service.dto.SysSkuDto;
import me.luke.modules.system.service.dto.SysSkuQueryCriteria;
import me.luke.utils.PageUtil;
import me.luke.utils.RedisUtils;
import me.luke.utils.StringUtils;
import me.luke.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Api(tags = "商品信息")
@RestController
@RequestMapping("/api/sysSku")
public class SysSkuController {

    private final SysSkuService sysSkuService;
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DataScope dataScope;

    @Autowired
    private SysSkuClassifyService sysSkuClassifyService ;


    public SysSkuController(SysSkuService sysSkuService) {
        this.sysSkuService = sysSkuService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('sysSku:list')")
    public void download(HttpServletResponse response, SysSkuQueryCriteria criteria) throws IOException {
        JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        criteria.setTopCompanyCode(jwtUser.getTopCompanyCode());
        sysSkuService.download(sysSkuService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询商品信息")
    @ApiOperation("查询商品信息")
    @PreAuthorize("@el.check('sysSku:list')")
    public ResponseEntity<Object> getSysSkus(SysSkuQueryCriteria criteria, Pageable pageable){
        JwtUser jwtUser = (JwtUser)redisUtils.get(request.getHeader("Authorization"));
        criteria.setTopCompanyCode(jwtUser.getTopCompanyCode());
        Set<Long> sysSkuClassifySet = new HashSet<>();
        Set<Long> result = new HashSet<>();

        if (!ObjectUtils.isEmpty(criteria.getClassifyId())) {
            sysSkuClassifySet.add(criteria.getClassifyId());
            sysSkuClassifySet.addAll(dataScope.getSysSkuClassifyChildren(sysSkuClassifyService.findByPid(criteria.getClassifyId())));
        }
        result.addAll(sysSkuClassifySet);
        criteria.setClassifyIds(result);//仅使用clssifyIds即可,获得子分类后需清空单一的jpa-classifyId条件
        criteria.setClassifyId(null);  //
        return new ResponseEntity<>(sysSkuService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增仓库")
    @ApiOperation("新增仓库")
    @PreAuthorize("@el.check('sysSku:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody SysSku resources){
        JwtUser jwtUser = (JwtUser) UserUtil.getLoginUser(redisUtils,request);
        resources.setTopCompanyCode(jwtUser.getTopCompanyCode());
        resources.setKeywords(StringUtils.getUUID(resources.getKeywords()));
        return new ResponseEntity<>(sysSkuService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改商品信息")
    @ApiOperation("修改商品信息")
    @PreAuthorize("@el.check('sysSku:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody SysSku resources){
        sysSkuService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除商品信息")
    @ApiOperation("删除商品信息")
    @PreAuthorize("@el.check('sysSku:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        Set<SysSkuDto> sysSkuDtos = new HashSet<>();
        for(Long id:ids){
            sysSkuDtos.add(sysSkuService.findById(id));
        }
        sysSkuService.deleteAll(sysSkuDtos);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}