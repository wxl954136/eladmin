package me.luke.modules.system.repository;


import me.luke.modules.system.domain.BaseQuery;
import me.luke.modules.system.domain.SysSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


/**
* @author Zheng Jie
* @date 2019-03-25
*/
@SuppressWarnings("all")
public interface SysSkuRepository extends JpaRepository<SysSku, Long>, JpaSpecificationExecutor<SysSku> {

    @Query(value = "select brand  as result from sys_sku " +
                    " where is_delete = 0 " +
                    " and top_company_code = :#{#data[0]} "  +
                    " group by brand " +
                    " order by brand  ",nativeQuery = true)
    List<Object> findAllByBrand(String ... data);

    @Query(value = "select color as result from sys_sku " +
            " where is_delete = 0 " +
            " and top_company_code = :#{#data[0]} "  +
            " group by color " +
            " order by color  ",nativeQuery = true)
    List<Object> findAllByColor(String ... data);


}