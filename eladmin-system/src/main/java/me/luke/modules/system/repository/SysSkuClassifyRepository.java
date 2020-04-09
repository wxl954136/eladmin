package me.luke.modules.system.repository;


import me.luke.modules.system.domain.SysSkuClassify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@SuppressWarnings("all")
public interface SysSkuClassifyRepository extends JpaRepository<SysSkuClassify, Long>, JpaSpecificationExecutor<SysSkuClassify> {

    /**
     * 根据 PID 查询
     * @param id pid
     * @return /
     */
    List<SysSkuClassify> findByPid(Long id);

    /**
     * 根据ID查询名称
     * @param id ID
     * @return /
     */
    @Query(value = "select name from sys_sku_classify where id = ?1",nativeQuery = true)
    String findNameById(Long id);

}