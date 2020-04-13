package me.luke.modules.system.repository;


import me.luke.modules.system.domain.SysSkuClassify;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


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

    /**
     * 修改邮箱
     * @param oldStr 旧的字符串
     * @param newStr 新的字符串
     */
    @Modifying
    @Query(value = "update sys_sku_classify set full_name = replace(full_name,?1,?2) where full_name like concat(?1,'%') ",nativeQuery = true)
    /*
    注解方式2
    @Query(value = "select name,author,price from Book b where b.name = :name AND b.author=:author AND b.price=:price")
    List<Book> findByNamedParam(@Param("name") String name, @Param("author") String author,
                                @Param("price") long price);
     */
    void updateFullName(String oldStr, String newStr);

    @Modifying
    @Query(value =  " update sys_sku_classify " +
                    " set full_name = replace(full_name,:#{#data[0]},:#{#data[1]}) " +
                    " where full_name like concat(:#{#data[0]},'%') " +
                    " and top_company_code = :#{#data[2]}",
                    nativeQuery = true)
    void updateFullNameAsEntity(String ... data);
/*
    @Modifying
    @Transactional
    @Query("update Test a set " +
            "a.name = CASE WHEN :#{#testAre.name} IS NULL THEN a.name ELSE :#{#testAre.name} END ," +
            "a.age = CASE WHEN :#{#testAre.age} IS NULL THEN a.age ELSE :#{#testAre.age} END ," +
            "a.insertTime = CASE WHEN :#{#testAre.insertTime} IS NULL THEN a.insertTime ELSE :#{#testAre.insertTime} END ," +
            "a.spare =  CASE WHEN :#{#testAre.spare} IS NULL THEN a.spare ELSE :#{#testAre.spare} END " +
            "where a.id = :#{#testAre.id}")

    int update(@Param("testAre") TestAre testAre);
*/

}