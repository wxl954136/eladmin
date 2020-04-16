package me.luke.modules.system.service;

import me.luke.modules.system.domain.SysSku;
import me.luke.modules.system.domain.vo.Assist;
import me.luke.modules.system.service.dto.SysSkuDto;
import me.luke.modules.system.service.dto.SysSkuQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lukeWang
 * @date 2020-03-25
 */
public interface SysSkuService {
    /**
     * 查询数据分页
     * @param criteria 条件
     * @param pageable 分页参数
     * @return Map<String,Object>
     */
    Map<String,Object> queryAll(SysSkuQueryCriteria criteria, Pageable pageable);
    /**
     * 查询所有数据
     * @param criteria 条件
     * @return /
     */
    List<SysSkuDto> queryAll(SysSkuQueryCriteria criteria);

    /**
     * 查询所有品牌数据
     * @return /
     */
    List<Assist>  findAllByBrand(String ... data);
/*
    List<Assist>  findAllByBrands(String topCompanyCode);

 */
    /**
     * 查询所有颜色数据
     * @return /
     */
    List<Assist>  findAllByColor(String ... data);

    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    SysSkuDto findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    SysSkuDto create(SysSku resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(SysSku resources);

    /**
     * 删除
     * @param sysSkuDtos /
     *
     */
    void delete(Set<SysSkuDto> sysSkuDtos);


    /**
     * 删除
     * @param sysSkuDtos /
     *
     */
    void deleteAll(Set<SysSkuDto> sysSkuDtos);


    /**
     * 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<SysSkuDto> queryAll, HttpServletResponse response) throws IOException;


}