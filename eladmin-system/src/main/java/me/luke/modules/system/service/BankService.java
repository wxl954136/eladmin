package me.luke.modules.system.service;


import me.luke.modules.system.domain.Bank;
import me.luke.modules.system.service.dto.BankDto;


import me.luke.modules.system.service.dto.BankQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @author lukeWang
* @date 2020-03-24
*/
public interface BankService {

    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    BankDto findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    BankDto create(Bank resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(Bank resources);

    /**
     * 删除
     * @param ids /
     */
    void delete(Set<Long> ids);

    /**
     * 分页查询
     * @param criteria 条件
     * @param pageable 分页参数
     * @return /
     */
    Map<String,Object> queryAll(BankQueryCriteria criteria, Pageable pageable);

    /**
     * 查询全部数据
     * @param criteria /
     * @return /
     */
    List<BankDto> queryAll(BankQueryCriteria criteria);

    /**
     * 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<BankDto> queryAll, HttpServletResponse response) throws IOException;
}