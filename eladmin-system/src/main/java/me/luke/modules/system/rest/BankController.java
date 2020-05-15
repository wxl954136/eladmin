package me.luke.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.luke.aop.log.Log;
import me.luke.config.DataScope;
import me.luke.exception.BadRequestException;

import me.luke.modules.system.domain.Bank;
import me.luke.modules.system.service.BankService;
import me.luke.modules.system.service.dto.BankQueryCriteria;
import me.luke.modules.utils.ThrowableUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-03-29
*/
@Slf4j
@Api(tags = "系统：银行管理")
@RestController
@RequestMapping("/api/bank")
public class BankController {

    private final BankService bankService;

    private final DataScope dataScope;

    private static final String ENTITY_NAME = "bank";

    public BankController(BankService bankService, DataScope dataScope) {
        this.bankService = bankService;
        this.dataScope = dataScope;
    }

    @Log("导出岗位数据")
    @ApiOperation("导出岗位数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('bank:list')")
    public void download(HttpServletResponse response, BankQueryCriteria criteria) throws IOException {
        bankService.download(bankService.queryAll(criteria), response);
    }

    @Log("查询银行")
    @ApiOperation("查询银行")
    @GetMapping
    @PreAuthorize("@el.check('bank:list')")
    public ResponseEntity<Object> getBanks(BankQueryCriteria criteria, Pageable pageable){
        // 数据权限
       // criteria.setDeptIds(dataScope.getDeptIds());
        return new ResponseEntity<>(bankService.queryAll(criteria, pageable),HttpStatus.OK);
    }

    @Log("新增银行")
    @ApiOperation("新增银行")
    @PostMapping
    @PreAuthorize("@el.check('bank:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Bank resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity<>(bankService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改银行")
    @ApiOperation("修改银行")
    @PutMapping
    @PreAuthorize("@el.check('bank:edit')")
    public ResponseEntity<Object> update(@Validated(Bank.Update.class) @RequestBody Bank resources){
        bankService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除银行")
    @ApiOperation("删除银行")
    @DeleteMapping
    @PreAuthorize("@el.check('bank:del')")
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids){
        try {
            bankService.delete(ids);
        }catch (Throwable e){
            ThrowableUtil.throwForeignKeyException(e, "所选银行存在用户关联，请取消关联后再试");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}