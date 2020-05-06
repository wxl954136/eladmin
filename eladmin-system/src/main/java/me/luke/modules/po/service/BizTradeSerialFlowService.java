package me.luke.modules.po.service;

import me.luke.modules.po.domain.BizTradeSerialFlow;
import me.luke.modules.po.service.dto.BizPoInQueryCriteria;
import me.luke.modules.po.service.dto.BizTradeSerialFlowDto;
import me.luke.modules.po.service.dto.BizTradeSerialFlowQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
* @author lukeWang
* @date 2020-05-05
*/
public interface BizTradeSerialFlowService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(BizTradeSerialFlowQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<BizTradeSerialFlowDto>
    */
    List<BizTradeSerialFlowDto> queryAll(BizTradeSerialFlowQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return BizTradeSerialFlowDto
     */
    BizTradeSerialFlowDto findById(Long id);

    /**
     * 根据业务明细表数据查询出所有的关流串号流水信息
     * @param bizDetailId 条件参数 :关联明细表id
     * @param bizType  条件参数:单据类型
     * @return List<BizTradeSerialFlowDto>
     */
    List<BizTradeSerialFlowDto> findByBizDetailKeywords(String  bizDetailKeywords,String bizType);

    /**
    * 创建
    * @param resources /
    * @return BizTradeSerialFlowDto
    */
    BizTradeSerialFlowDto create(BizTradeSerialFlow resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(BizTradeSerialFlow resources);

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
    void download(List<BizTradeSerialFlowDto> all, HttpServletResponse response) throws IOException;
}