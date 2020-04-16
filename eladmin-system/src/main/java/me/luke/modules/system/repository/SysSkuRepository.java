package me.luke.modules.system.repository;


import io.lettuce.core.dynamic.annotation.Param;
import me.luke.modules.system.domain.SysSku;
import me.luke.modules.system.domain.vo.Assist;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
* @author Zheng Jie
* @date 2019-03-25
*/
@SuppressWarnings("all")
public interface SysSkuRepository extends JpaRepository<SysSku, Long>, JpaSpecificationExecutor<SysSku> {
    @Query(value = "select 'SUCCESS' as result ,brand  as value,'SUCCESS' as content from sys_sku " +
                    " where is_delete = 0 " +
                    " and top_company_code = :#{#data[0]} "  +
                    " group by brand " +
                    " order by brand  ",nativeQuery = true)
    List<Object[]> findAllByBrand(String ... data);
/*
    @Query(value = "select new me.luke.modules.system.domain.vo(a.brand)" +
            " from sys_sku a " +
            " where a.is_delete = 0 " +
            " and a.top_company_code = :topCompanyCode "  +
            " group by a.brand " +
            " order by a.brand  ")
    List<Assist> findAllByBrands(@Param("topCompanyCode") String topCompanyCode);
*/

    @Query(value = "select 'SUCCESS' as result,color as value ,'SUCCESS' as content from sys_sku " +
            " where is_delete = 0 " +
            " and top_company_code = :#{#data[0]} "  +
            " group by color " +
            " order by color  ",nativeQuery = true)

    List<Object[]> findAllByColor(String ... data);





}