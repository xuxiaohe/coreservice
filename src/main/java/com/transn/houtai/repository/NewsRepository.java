package com.transn.houtai.repository;

import com.transn.houtai.domain.BannerManger;
import com.transn.houtai.domain.News;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Repository
@Qualifier(value = "newsRepository")
public interface NewsRepository extends CrudRepository<News, Long> {

   public Page<News> findAll(Pageable pageable);

   public Page<News> findByCategory(Pageable pageable,String category);

   public Page<News> findByTitleLike(String title,Pageable pageable);

   public News findById(int id);

   @Transactional
   @Modifying
   @Query("update  News u set u.categoryid=1,u.category='未分类'  where u.categoryid = :categoryid")
   public void updateByCategoryid(@Param("categoryid") int categoryid);


   @Transactional
   @Modifying
   @Query("update  News u set u.top=0")
   public void updateByTop();

}
