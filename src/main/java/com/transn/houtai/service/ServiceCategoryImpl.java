package com.transn.houtai.service;

import com.transn.houtai.domain.transncategory;
import com.transn.houtai.repository.ServiceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuxiaohe on 2016/11/9.
 */
@Service
public class ServiceCategoryImpl   {

    @Autowired
    private ServiceCategoryRepository serviceCategoryRepository;

    public List getallcategory() {
        List l=new ArrayList();


        List<transncategory> byfistgroup = serviceCategoryRepository.findByfistgroup();
        if (byfistgroup.size()!=0) {
            for(transncategory t:byfistgroup){
                List l2=new ArrayList();
                Map m=new HashMap<>();
                m.put("firstgroup",t.getFirstgroup());
                List<transncategory> bysecondgroup = serviceCategoryRepository.findBysecondgroup(t.getFirstgroup());
                if (bysecondgroup.size()!=0) {
                    for(transncategory tt:bysecondgroup){
                        Map m2=new HashMap<>();
                        m2.put("secondgroupname",tt.getSecondgroup());
                        List<transncategory> transncategories = serviceCategoryRepository.findByFirstgroupAndSecondgroup(t.getFirstgroup(), tt.getSecondgroup());
                        m2.put("data",transncategories);
                        l2.add(m2);

                    }
                    m.put("secondgroup",l2);
                }
                l.add(m);
            }

        }
        return l;
    }

    public List getallcategorylist() {
        return (List) serviceCategoryRepository.findAll();
    }

    public void savecategory(transncategory t) {
        serviceCategoryRepository.save(t);
    }

    public void deletecategory(transncategory t) {
        serviceCategoryRepository.delete(t);
    }



}
