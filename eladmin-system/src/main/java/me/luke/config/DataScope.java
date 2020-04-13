package me.luke.config;

import me.luke.modules.system.domain.Dept;
import me.luke.modules.system.domain.SysSkuClassify;
import me.luke.modules.system.service.DeptService;
import me.luke.modules.system.service.RoleService;
import me.luke.modules.system.service.SysSkuClassifyService;
import me.luke.modules.system.service.UserService;
import me.luke.modules.system.service.dto.RoleSmallDto;
import me.luke.modules.system.service.dto.UserDto;
import me.luke.utils.SecurityUtils;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数据权限配置
 * @author Zheng Jie
 * @date 2019-4-1
 */
@Component
public class DataScope {

    private final String[] scopeType = {"全部","本级","自定义"};

    private final UserService userService;

    private final RoleService roleService;

    private final DeptService deptService;

    private final SysSkuClassifyService sysSkuClassifyService;


    public DataScope(UserService userService, RoleService roleService, DeptService deptService,SysSkuClassifyService sysSkuClassifyService) {
        this.userService = userService;
        this.roleService = roleService;
        this.deptService = deptService;
        this.sysSkuClassifyService = sysSkuClassifyService;
    }

    public Set<Long> getDeptIds() {

        UserDto user = userService.findByName(SecurityUtils.getUsername());

        // 用于存储部门id
        Set<Long> deptIds = new HashSet<>();

        // 查询用户角色
        List<RoleSmallDto> roleSet = roleService.findByUsersId(user.getId());

        for (RoleSmallDto role : roleSet) {

            if (scopeType[0].equals(role.getDataScope())) {
                return new HashSet<>() ;
            }

            // 存储本级的数据权限
            if (scopeType[1].equals(role.getDataScope())) {
                deptIds.add(user.getDept().getId());
            }

            // 存储自定义的数据权限
            if (scopeType[2].equals(role.getDataScope())) {
                Set<Dept> depts = deptService.findByRoleIds(role.getId());
                for (Dept dept : depts) {
                    deptIds.add(dept.getId());
                    List<Dept> deptChildren = deptService.findByPid(dept.getId());
                    if (deptChildren != null && deptChildren.size() != 0) {
                        deptIds.addAll(getDeptChildren(deptChildren));
                    }
                }
            }
        }
        return deptIds;
    }


    public Set<Long> getSkuClassifyIds() {



        // 用于商品分类的id
        Set<Long> sysClassifyIds = new HashSet<>();

//        sysSkuClassifyService

        return sysClassifyIds;
    }
    public List<Long> getDeptChildren(List<Dept> deptList) {
        List<Long> list = new ArrayList<>();
        deptList.forEach(dept -> {
                    if (dept!=null && dept.getEnabled()){
                        List<Dept> depts = deptService.findByPid(dept.getId());
                        if(deptList.size() != 0){
                            list.addAll(getDeptChildren(depts));
                        }
                        list.add(dept.getId());
                    }
                }
        );
        return list;
    }
    public List<Long> getSysSkuClassifyChildren(List<SysSkuClassify> sysSkuClassifyList) {


        List<Long> list = new ArrayList<>();
        sysSkuClassifyList.forEach(classify -> {
                    if (classify!=null && classify.getEnabled()){
                        List<SysSkuClassify> sysSkuClassifys = sysSkuClassifyService.findByPid(classify.getId());
                        if(sysSkuClassifyList.size() != 0){
                            list.addAll(getSysSkuClassifyChildren(sysSkuClassifys));
                        }
                        list.add(classify.getId());
                    }
                }
        );
        return list;
    }
}
