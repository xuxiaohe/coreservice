package com.transn.houtai.repository;

import com.transn.houtai.domain.TmpSelectUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xuxiaohe on 2016/11/3.
 */
@Repository
@Qualifier(value = "TmpSelectUserRepository")
public interface TmpSelectUserRepository extends CrudRepository<TmpSelectUser, Long> {

    public TmpSelectUser findById(int id);

    public List<TmpSelectUser> findByCustomerid(int phonenuber);

    public TmpSelectUser findByCustomeridAndUserid(int customerid,int userid);
    @Transactional
    @Modifying
    @Query("delete from TmpSelectUser u where u.customerid = :customerid")
    public void deleteByCustomerid(@Param("customerid") int customerid);
    
    
    @Transactional
    @Modifying
    @Query("update  TmpSelectUser u set u.userlogo= :userlogo  where u.userid = :userid")
    public void updateByCustomerid(@Param("userid") int userid,@Param("userlogo") String userlogo);

//    public void deleteByCustomeridAndUserid(int customerid);

//    @Query("from TmpSelectUser u where u.customerid=:customerid group by language")
//    public List<TmpSelectUser> findByLanguagegroup(@Param("customerid") int customerid);

//    public List<TmpSelectUser> findByCustomeridAndLanguage(int customerid,String language);
    
}
