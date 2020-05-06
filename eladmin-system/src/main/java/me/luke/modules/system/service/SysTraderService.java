package me.luke.modules.system.service;

import me.luke.modules.system.domain.SysTrader;
import me.luke.modules.system.service.dto.SysTraderDto;
import me.luke.modules.system.service.dto.SysTraderQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author lukeWang
* @date 2020-04-16
*/
public interface SysTraderService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(SysTraderQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<SysTraderDto>
    */
    List<SysTraderDto> queryAll(SysTraderQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return SysTraderDto
     */
    SysTraderDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return SysTraderDto
    */
    SysTraderDto create(SysTrader resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(SysTrader resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<SysTraderDto> all, HttpServletResponse response) throws IOException;
}