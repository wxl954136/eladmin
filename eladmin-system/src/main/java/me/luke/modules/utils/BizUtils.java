package me.luke.modules.utils;

import me.luke.modules.po.domain.BizTradeSerialFlow;
import me.luke.modules.security.security.vo.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Component
@Controller
public class BizUtils {

    private   RedisUtils redisUtils;
    public BizUtils(){}
    public BizUtils(RedisUtils redisUtils){
        this.redisUtils = redisUtils;
    }
    public  Object getJwtUser(){
        String token = UserUtil.getCurrentRequest().getHeader("Authorization") ;
        return  redisUtils.get(token);
    }


    //处理串号数据，凡是与串号相关的，通过此处处理，然后再业务中去保存
    /**
     * 整理业务处理中的修改的串号等数据，便于保存数据
     * @param type 类型条件:ADD/UPD/DEL
     * @param oldList 旧值，即从数据库中取的值
     * @param newList 新值，即从前端传过来的值
     * @return Map<String,Object>
     */
    public  Map<String, List<BizTradeSerialFlow>> getPrepareBizTradeSerialFlow(String type,List<BizTradeSerialFlow> oldList, List<BizTradeSerialFlow> newList){

        JwtUser jwtUser = (JwtUser)getJwtUser() ;


        Map<String,List<BizTradeSerialFlow>> dataCollect = new HashMap<>(3);
        dataCollect.put("ADD",new ArrayList<>());
        dataCollect.put("DEL",new ArrayList<>());
        dataCollect.put("UPD",new ArrayList<>());
        //新增记录时
        if ("ADD".equalsIgnoreCase(type)){
            dataCollect.get("ADD").addAll(newList);
        }
        //修改记录时
        Map<Long,BizTradeSerialFlow> newContentIds = new HashMap<>();
        if ("UPD".equalsIgnoreCase(type)){
            //001:寻找新增记录:
            for (BizTradeSerialFlow biz : newList){
                if (null == biz.getId() ||  biz.getId() < 0 ) {
                    biz.setVersion(0);
                    biz.setTopCompanyCode(jwtUser.getTopCompanyCode());  //这里要把topCompanyCodel加进去 ，想一个公共方法最容易获随即，写到这里，应该建议，前端直接放公司代码了
                    dataCollect.get("ADD").add(biz);
                }else
                {
                    //存放修改记录值
                    newContentIds.put(biz.getId(),biz) ;
                }
            }
            //002:第二步根据现有DB数据筛选DEL,UPD
            for(BizTradeSerialFlow biz : oldList){
                if (newContentIds.containsKey(biz.getId())){
                    BizTradeSerialFlow _update = newContentIds.get(biz.getId());  //用于判断是否更新
                    if (!_update.toString().equalsIgnoreCase(biz.toString()))
                    {
                        _update.setVersion(_update.getVersion()==null?0:_update.getVersion() + 1);
                        dataCollect.get("UPD").add(_update);
                    }
                }else   //删除
                {
                    biz.setIsDelete(true);
                    biz.setVersion(biz.getVersion()==null?0:biz.getVersion() + 1);
                    dataCollect.get("DEL").add(biz);
                }
            }
        }
        return dataCollect;
    }
}
