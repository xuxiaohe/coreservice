package com.transn.houtai.repository;

import com.transn.houtai.domain.userservicelog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xuxiaohe on 2016/11/30.
 */
@Repository
@Qualifier(value = "userServiceRepository")
public interface UserServiceRepository extends CrudRepository<userservicelog, Long> {

    Page<userservicelog> findAll(Pageable pageable);

    Page<userservicelog> findByServiceid(Pageable pageable,int serviceid);


}
