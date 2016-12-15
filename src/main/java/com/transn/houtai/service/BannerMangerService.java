package com.transn.houtai.service;

import com.transn.houtai.domain.AdminUser;
import com.transn.houtai.domain.BannerManger;
import com.transn.houtai.repository.AdminUserRepository;
import com.transn.houtai.repository.BannerMangerRepository;
import com.transn.houtai.util.pages.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Service
public class BannerMangerService {
    @Autowired
    private BannerMangerRepository bannerMangerRepository;

    public BannerManger saveBanner(BannerManger a){
        bannerMangerRepository.save(a);
        return a;
    }

    public Page<BannerManger> getallBannerByPage( Pageable pageable){
        Page<BannerManger> all = bannerMangerRepository.findAll(pageable);
        return  all;
    }


    public boolean deleteBanner(BannerManger a){
        bannerMangerRepository.delete(a);
        return true;
    }

    public BannerManger getOneBanner(int id){
        BannerManger one = bannerMangerRepository.findById(id);
        return one;
    }

//    public BannerManger updateBanner(BannerManger a){
//        BannerManger one = bannerMangerRepository.findById(id);
//        return one;
//    }

}
