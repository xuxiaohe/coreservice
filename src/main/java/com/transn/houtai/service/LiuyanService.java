package com.transn.houtai.service;

import com.transn.houtai.domain.Liuyan;
import com.transn.houtai.repository.LiuyanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Service
public class LiuyanService {
    @Autowired
    private LiuyanRepository liuyanRepository;



    public Liuyan saveLiuyan(Liuyan a){
        liuyanRepository.save(a);
        return a;
    }

    public Page<Liuyan> getallLiuyanByPage( Pageable pageable){
        Page<Liuyan> all = liuyanRepository.findAll(pageable);

        return  all;
    }



    public Liuyan getOneLiuyan(int id){
        Liuyan one = liuyanRepository.findById(id);
        return one;
    }

    public boolean addBack(int id ,String back){
        liuyanRepository.updatebackByid(back,id);
        return true;

    }


    public boolean updatecheck(int id, String ischeck){
        liuyanRepository.updateischeckByid(ischeck,id);
        return true;
    }

    public boolean deleteliuyan(int id){
        Liuyan l=new Liuyan();
        l.setId(id);
        liuyanRepository.delete(l);
        return true;
    }


}
