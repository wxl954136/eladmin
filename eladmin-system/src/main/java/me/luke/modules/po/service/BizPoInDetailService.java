package me.luke.modules.po.service;

import me.luke.modules.po.domain.BizPoInDetail;
import me.luke.modules.po.service.dto.BizPoInDetailDto;
import me.luke.modules.po.service.dto.BizPoInDetailQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author lukeWang
* @date 2020-04-18
*/
public interface BizPoInDetailService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(BizPoInDetailQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<BizPoInDetailDto>
    */
    List<BizPoInDetailDto> queryAll(BizPoInDetailQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return BizPoInDetailDto
     */
    BizPoInDetailDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return BizPoInDetailDto
    */
    BizPoInDetailDto create(BizPoInDetail resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(BizPoInDetail resources);
    /**
     * 批量 编辑
     * @param resourcesList /
     */
    void update(List<BizPoInDetail> resourcesList);
    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);


    /**
     * 多选删除
     * @param ids /
     */
    void deleteAllByHeadId(Long headId);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<BizPoInDetailDto> all, HttpServletResponse response) throws IOException;
}