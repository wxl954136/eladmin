package me.luke.modules.po.service;

import me.luke.modules.po.domain.BizPoIn;
import me.luke.modules.po.service.dto.BizPoInDto;
import me.luke.modules.po.service.dto.BizPoInQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author lukeWang
* @date 2020-04-17
*/
public interface BizPoInService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(BizPoInQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<BizPoInDto>
    */
    List<BizPoInDto> queryAll(BizPoInQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return BizPoInDto
     */
    BizPoInDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return BizPoInDto
    */
    BizPoInDto create(BizPoIn resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(BizPoIn resources);

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
    void download(List<BizPoInDto> all, HttpServletResponse response) throws IOException;
}