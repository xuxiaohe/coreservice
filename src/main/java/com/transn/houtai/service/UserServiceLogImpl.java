package com.transn.houtai.service;

import com.transn.houtai.domain.userservicelog;
import com.transn.houtai.repository.UserServiceRepository;
import com.transn.houtai.util.PageRequestTools;
import com.transn.houtai.util.ReponseData;
import com.transn.houtai.util.ReponseDataTools;


import com.transn.houtai.util.pages.Pager;
import com.transn.houtai.util.pages.QueryModelMul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuxiaohe on 2016/11/30.
 */
@Service
public class UserServiceLogImpl {

    @Autowired
    private UserServiceRepository userServiceRepository;


    public List<userservicelog> getAlluserServiceLog() {
        return (List<userservicelog>) userServiceRepository.findAll();
    }


    public void saveUserServiceLog(userservicelog u) {
        userServiceRepository.save(u);
    }



    public Map getallBypage(QueryModelMul dm){
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<userservicelog> all = userServiceRepository.findAll(pageable);
        ReponseData rs=new ReponseData();
        ReponseData clientReponseData = ReponseDataTools.getClientReponseData(rs, all);
        Map m=new HashMap();
        m.put("result",all.getContent());
        m.put("total",clientReponseData.getTotal_rows());
        m.put("page",clientReponseData.getPage_rows());
        return m;
    }


    public Pager<userservicelog> getBypageAndServiceid(QueryModelMul dm, int serviceid) {
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<userservicelog> byServiceid = userServiceRepository.findByServiceid(pageable, serviceid);
        ReponseData rs=new ReponseData();
        ReponseData clientReponseData = ReponseDataTools.getClientReponseData(rs, byServiceid);
      /*  Map m=new HashMap();
        m.put("result",byServiceid.getContent());
        m.put("total",clientReponseData.getTotal_rows());
        m.put("page",clientReponseData.getPage_rows());*/
        Pager<userservicelog> pager=new Pager<userservicelog>();
        pager.setSize(dm.getN()+1);
        pager.setLimit(dm.getS());
        pager.setTotal(new Long(clientReponseData.getTotal_rows()).intValue());
        pager.setDatas(byServiceid.getContent());
        pager.setTotalpage(pager.getTotal(), pager.getLimit());
        pager.calcNavPagerNumbers();
        return pager;
    }
}
