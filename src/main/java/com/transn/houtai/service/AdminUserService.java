package com.transn.houtai.service;

import com.transn.houtai.domain.AdminUser;
import com.transn.houtai.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Service
public class AdminUserService {
    @Autowired
    private AdminUserRepository adminUserRepository;

    public AdminUser saveAdminUser(AdminUser a){
        adminUserRepository.save(a);
        return a;
    }

    public boolean isAdminUser(AdminUser a){
        boolean b=false;
        AdminUser byNameAndPassword = adminUserRepository.findByNameAndPassword(a.getName(), a.getPassword());
        if(byNameAndPassword!=null){
            b=true;
        }
        return b;
    }
}
