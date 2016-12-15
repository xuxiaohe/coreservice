package com.transn.houtai.repository;

import com.transn.houtai.domain.AdminUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Repository
@Qualifier(value = "adminUserRepository")
public interface AdminUserRepository extends CrudRepository<AdminUser, Long> {
   public AdminUser findByNameAndPassword(String name,String password);
}
