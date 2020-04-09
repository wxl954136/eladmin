package me.luke.modules.system.service;

import me.luke.modules.system.domain.SysSkuClassify;
import me.luke.modules.system.service.dto.SysSkuClassifyDto;
import me.luke.modules.system.service.dto.SysSkuClassifyQueryCriteria;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author lukeWang
 * @date 2020-03-25
 */
public interface SysSkuClassifyService {

    /**
     * 查询所有数据
     * @param criteria 条件
     * @return /
     */
    List<SysSkuClassifyDto> queryAll(SysSkuClassifyQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id /
     * @return /
     */
    SysSkuClassifyDto findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
    SysSkuClassifyDto create(SysSkuClassify resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(SysSkuClassify resources);

    /**
     * 删除
     * @param sysSkuClassifyDtos /
     *
     */
    void delete(Set<SysSkuClassifyDto> sysSkuClassifyDtos);

    /**
     * 构建树形数据
     * @param sysSkuClassifyDtos 原始数据
     * @return /
     */
    Object buildTree(List<SysSkuClassifyDto> sysSkuClassifyDtos);

    /**
     * 根据PID查询
     * @param pid /
     * @return /
     */
    List<SysSkuClassify> findByPid(long pid);




    /**
     * 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<SysSkuClassifyDto> queryAll, HttpServletResponse response) throws IOException;

    /**
     * 获取待删除的部门
     * @param sysSkuClassifyList /
     * @param sysSkuClassifyDtos /
     * @return /
     */
    Set<SysSkuClassifyDto> getDeleteSysSkuClassifys(List<SysSkuClassify> sysSkuClassifyList, Set<SysSkuClassifyDto> sysSkuClassifyDtos);
}