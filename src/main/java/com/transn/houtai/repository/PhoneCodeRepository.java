/*******************************************************************************
 * Copyright 2015 Brient Oh @ Pristine Core
 * boh@pristinecore.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.transn.houtai.repository;

import com.transn.houtai.domain.PhoneCode;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier(value = "phoneCodeRepository")
public interface PhoneCodeRepository extends CrudRepository<PhoneCode, Long> {

//	public User findByUsername(String username);

    public PhoneCode findByPhonenumber(String phonenuber);

    public PhoneCode findByPhonenumberIsNot(String phonenuber);


    public PhoneCode findByPhonenumberAndId(String phonenumber,int id);


    public PhoneCode findByPhonenumberOrId(String phonenumber,int id);

    public List<PhoneCode> findByPhonenumberLike(String number);

    public Page<PhoneCode> findByPhonenumberLike(String number,Pageable pageable);

    @Query("from PhoneCode u where u.phonenumber=:phonenumber")
    public PhoneCode  findByone(@Param("phonenumber") String phonenumber);

    public List<PhoneCode> findByIdIn(List<Object> ids);

    public List<PhoneCode> findBytimeBetween(String begintime,String endtime);

    public List<PhoneCode> findByIdLessThan(int id);

    public List<PhoneCode> findByIdGreaterThan(int id);

//    public List<PhoneCodePojo> findByPhonenumberNotNullAndtimeIsNull();

    int countByPhonecodes(String phonecodes);
}
