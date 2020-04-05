package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.Dept;
import me.zhengjie.modules.system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

/**
 * @author Zheng Jie
 * @date 2018-11-22
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * 根据用户名查询
     * @param username 用户名
     * @return /
     */
    User findByUsername(String username);
    /**
     * 根据用户名查询
     * @param username 用户名
     * @return /
     */

    User findByUsernameAndTopCompanyCode(String username,String topCompanyCode);
    /**
     * 根据邮箱查询
     * @param email 邮箱
     * @return /
     */
    User findByEmail(String email);

    /**
     * 修改密码
     * @param username 用户名
     * @param pass 密码
     * @param lastPasswordResetTime /
     */
    @Modifying
    @Query(value = "update user set password = ?2 , last_password_reset_time = ?3 where username = ?1",nativeQuery = true)
    void updatePass(String username, String pass, Date lastPasswordResetTime);

    /**
     * 修改邮箱
     * @param username 用户名
     * @param email 邮箱
     */
    @Modifying
    @Query(value = "update user set email = ?2 where username = ?1",nativeQuery = true)
    void updateEmail(String username, String email);


/*
    @Query("select new com.wmd.springtest.jparepcustomobj.domain.UserDept(" +
            "u.id, u.name, d.id, d.name" +
            ") " +
            "from User u, Dept d " +
            "where u.deptId=d.id")
    List findAllForUserDept();
*/
    @Query(value = " select count(1) from user  " +
                   " where dept_id=?1 " +
                   " and  top_company_code =?2 " ,
                    nativeQuery = true
          )
    int findByDeptUseCount(Long dept_id,String top_company_code);
}
