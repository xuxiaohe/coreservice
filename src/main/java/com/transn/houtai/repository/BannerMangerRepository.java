package com.transn.houtai.repository;

import com.transn.houtai.domain.AdminUser;
import com.transn.houtai.domain.BannerManger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Repository
@Qualifier(value = "bannerMangerRepository")
public interface BannerMangerRepository extends CrudRepository<BannerManger, Long> {
   public Page<BannerManger> findAll(Pageable pageable);

   public BannerManger findById(int id);


}
