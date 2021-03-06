package me.luke.modules.system.service;

import me.luke.modules.system.domain.SysStore;
import me.luke.modules.system.service.dto.DeptDto;
import me.luke.modules.system.service.dto.SysStoreDto;
import me.luke.modules.system.service.dto.SysStoreQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

/**
* @author lukeWang
* @date 2020-04-03
*/
public interface SysStoreService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(SysStoreQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<SysStoreDto>
    */
    List<SysStoreDto> queryAll(SysStoreQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return SysStoreDto
     */
    SysStoreDto findById(Long id);
    /**
     * 根据ID查询
     * @param name 名字
     * @return SysStoreDto
     */
    SysStoreDto findByName(String name);


    int findByNameCount(Long id,String name,String topCompanyCode);


    /**
    * 创建
    * @param resources
    * @return SysStoreDto
    */
    SysStoreDto create(SysStore resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(SysStore resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);
    /**
     * 多选删除
     * @param sysStoreDtos /
     */
    void deleteAll(Set<SysStoreDto> sysStoreDtos);
    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<SysStoreDto> all, HttpServletResponse response) throws IOException;
}