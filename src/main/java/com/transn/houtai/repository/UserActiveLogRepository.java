package com.transn.houtai.repository;

import com.transn.houtai.domain.PhoneCode;
import com.transn.houtai.domain.UserActiveLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xuxiaohe on 2016/12/5.
 */
@Repository
@Qualifier(value = "userActiveLogRepository")
public interface UserActiveLogRepository extends CrudRepository<UserActiveLog, Long> {

}
