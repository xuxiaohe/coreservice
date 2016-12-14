package com.transn.houtai.repository;

import com.transn.houtai.domain.TmpSelectUser;
import com.transn.houtai.domain.transncategory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuxiaohe on 2016/11/3.
 */
@Repository
@Qualifier(value = "ServiceCategoryRepository")
public interface ServiceCategoryRepository extends CrudRepository<transncategory, Long> {

    @Query("from transncategory u group by u.firstgroup")
    public List<transncategory> findByfistgroup();

    @Query("from transncategory u where u.firstgroup=:firstgroup group by u.secondgroup")
    public List<transncategory> findBysecondgroup(@Param("firstgroup") String firstgroup);

    public List<transncategory> findByFirstgroupAndSecondgroup(String firstgroup,String secondgroup);
}
