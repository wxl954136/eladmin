package me.luke.modules.system.service.impl;



import lombok.extern.slf4j.Slf4j;
import me.luke.modules.system.domain.Bank;
import me.luke.modules.system.repository.BankRepository;
import me.luke.modules.system.service.BankService;
import me.luke.modules.system.service.dto.BankDto;
import me.luke.modules.system.service.dto.BankQueryCriteria;
import me.luke.modules.system.service.mapper.BankMapper;
import me.luke.modules.utils.FileUtil;
import me.luke.modules.utils.PageUtil;
import me.luke.modules.utils.QueryHelp;
import me.luke.modules.utils.ValidationUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
* @author Zheng Jie
* @date 2019-03-29
*/
@Slf4j
@Service
@CacheConfig(cacheNames = "bank")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    private final BankMapper bankMapper;



    public BankServiceImpl(BankRepository bankRepository, BankMapper bankMapper) {
        this.bankRepository = bankRepository;
        this.bankMapper = bankMapper;
    }
/*
    @Override
    @Cacheable
    public Map<String,Object> queryAll(BankQueryCriteria criteria, Pageable pageable) {
        Page<Bank> page = bankRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        List<BankDto> banks = new ArrayList<>();
        for (Bank job : page.getContent()) {
            banks.add(bankMapper.toDto(job,deptRepository.findNameById(job.getDept().getPid())));
        }
        return PageUtil.toPage(banks,page.getTotalElements());
    }
*/


@Override
@Cacheable
public Map<String, Object> queryAll(BankQueryCriteria bank, Pageable pageable){

    Page<Bank> page = bankRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, bank, cb), pageable);
    return PageUtil.toPage(page.map(bankMapper::toDto));
}
    @Override
    @Cacheable
    public List<BankDto> queryAll(BankQueryCriteria criteria) {
        List<Bank> list = bankRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
        return bankMapper.toDto(list);
    }

    @Override
    @Cacheable(key = "#p0")
    public BankDto findById(Long id) {
        Bank bank = bankRepository.findById(id).orElseGet(Bank::new);
        ValidationUtil.isNull(bank.getId(),"Bank","id",id);
        return bankMapper.toDto(bank);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public BankDto create(Bank resources) {
        return bankMapper.toDto(bankRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Bank resources) {
        Bank bank = bankRepository.findById(resources.getId()).orElseGet(Bank::new);
        ValidationUtil.isNull( bank.getId(),"Bank","id",resources.getId());
        resources.setId(bank.getId());
        bankRepository.save(resources);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for (Long id : ids) {
            bankRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<BankDto> bankDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (BankDto bankDTO : bankDtos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("银行名称", bankDTO.getName());
            map.put("银行状态", bankDTO.getEnabled() ? "启用" : "停用");
            map.put("创建日期", bankDTO.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}