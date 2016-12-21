package com.transn.houtai.repository;

import com.transn.houtai.domain.Liuyan;
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
@Qualifier(value = "liuyanRepository")
public interface LiuyanRepository extends CrudRepository<Liuyan, Long> {

   public Page<Liuyan> findAll(Pageable pageable);

   public Liuyan findById(int id);

   @Transactional
   @Modifying
   @Query("update  Liuyan u set u.back=:back  where u.id = :id")
   public void updatebackByid(@Param("back") String back,@Param("id") int id);


   @Transactional
   @Modifying
   @Query("update  Liuyan u set u.ischeck=:ischeck  where u.id = :id")
   public void updateischeckByid(@Param("ischeck") String ischeck,@Param("id") int id);
//
//
//   @Transactional
//   @Modifying
//   @Query("update  Liuyan u set u.top=0")
//   public void updateByTop();

}
