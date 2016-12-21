package com.transn.houtai.repository;

import com.transn.houtai.domain.Categorys;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Repository
@Qualifier(value = "categoryRepository")
public interface CategoryRepository extends PagingAndSortingRepository<Categorys, Long> {

    public Categorys findById(int id);

    @Transactional
    @Modifying
    @Query("update  Categorys u set u.name=:name  where u.id = :id")
    public void updateCategoryById(@Param("name") String name,@Param("id") int id);

}
