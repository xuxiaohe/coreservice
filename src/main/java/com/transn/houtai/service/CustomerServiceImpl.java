package com.transn.houtai.service;

import com.transn.houtai.domain.TmpSelectUser;
import com.transn.houtai.exception.ServiceException;
import com.transn.houtai.repository.TmpSelectUserRepository;
import com.transn.houtai.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuxiaohe on 2016/11/3.
 */
@Service
public class CustomerServiceImpl {
    @Autowired
    private TmpSelectUserRepository tmpSelectUserRepository;

    public List<TmpSelectUser> saveTmpSelectUser(TmpSelectUser t) throws ServiceException{
        TmpSelectUser byCustomeridAndUserid = tmpSelectUserRepository.findByCustomeridAndUserid(t.getCustomerid(), t.getUserid());
        if(byCustomeridAndUserid!=null){
            throw new ServiceException(Config.STATUS_201, Config.MSG_FAV_201, null);
        }
        tmpSelectUserRepository.save(t);
        return tmpSelectUserRepository.findByCustomerid(t.getCustomerid());

    }


    public List<TmpSelectUser> getTmpSelectUser(int customerid) {
        return tmpSelectUserRepository.findByCustomerid(customerid);
    }



    public boolean getTmpSelectUserByUserid(int customerid,int userid) {
        TmpSelectUser byCustomeridAndUserid = tmpSelectUserRepository.findByCustomeridAndUserid(customerid, userid);
        if (byCustomeridAndUserid!=null) {
            return false;
        }
        else {
            return true;
        }
    }


    public List<TmpSelectUser> deleteTmpSelectUser(int id,int customerid) throws ServiceException {
        TmpSelectUser one = tmpSelectUserRepository.findById(id);
        if (one==null) {
            throw new ServiceException(Config.STATUS_201, Config.MSG_FAVDAY_201, null);
        }
        TmpSelectUser t=new TmpSelectUser();
        t.setId(id);
        tmpSelectUserRepository.delete(t);
        return tmpSelectUserRepository.findByCustomerid(customerid);
    }


    public void deleteBycustomerid(int customerid) {
        tmpSelectUserRepository.deleteByCustomerid(customerid);
    }


	public void updateByCustomerid(int userid,String userlogo) {
		tmpSelectUserRepository.updateByCustomerid(userid, userlogo);
	}
}
