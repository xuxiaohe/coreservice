package com.transn.houtai.controller;

import com.transn.houtai.domain.PhoneCode;
import com.transn.houtai.domain.TmpSelectUser;
import com.transn.houtai.domain.userservicelog;
import com.transn.houtai.repository.PhoneCodeRepository;
import com.transn.houtai.repository.TmpSelectUserRepository;
import com.transn.houtai.repository.UserServiceRepository;
import com.transn.houtai.util.Config;
import com.transn.houtai.util.PageRequestTools;
import com.transn.houtai.util.ReponseDataTools;
import com.transn.houtai.util.pages.QueryModelMul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by xuxiaohe on 16/8/25.
 */
@RequestMapping(value = "/test/")
@Controller
public class test extends BaseController{
//    @Autowired
//    private UserRepository userRepository;


    @Autowired
    private PhoneCodeRepository phoneCodeRepository;

    @Autowired
    private TmpSelectUserRepository tmpSelectUserRepository;


    @Autowired
    private UserServiceRepository userServiceRepository;


    @ResponseBody
    @RequestMapping(value = "/userserivcesave")
    public Object userserivcesave(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String info=request.getParameter("info");
        String userid=request.getParameter("userid");
        userservicelog u=new userservicelog();
        u.setOssuserid(Integer.parseInt(userid));
        u.setInfo(info);
        u.setOssusername(name);
        u.setTime(System.currentTimeMillis()+"");
        userServiceRepository.save(u);
        return u;
    }




    @ResponseBody
    @RequestMapping(value = "/getalluserserivce")
    public Object getalluserserivce(HttpServletRequest request, HttpServletResponse response,QueryModelMul dm) {
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<userservicelog> all = userServiceRepository.findAll(pageable);
        ReponseDataTools.getClientReponseData(getReponseData(), all);
        return addPageResponse(Config.STATUS_200, Config.MSG_200, getReponseData(),Config.STATUS_200, "");
    }


    @ResponseBody
    @RequestMapping(value = "/getuserserivcebyserviceid")
    public Object getuserserivcebyserviceid(HttpServletRequest request, HttpServletResponse response,QueryModelMul dm) {
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        String serviceid = request.getParameter("serviceid");
        Page<userservicelog> all = userServiceRepository.findByServiceid(pageable,Integer.parseInt(serviceid));
        ReponseDataTools.getClientReponseData(getReponseData(), all);
        return addPageResponse(Config.STATUS_200, Config.MSG_200, getReponseData(),Config.STATUS_200, "");
    }






    @ResponseBody
    @RequestMapping(value = "/test")
    public Object test() {
        List l=new ArrayList();
        List<PhoneCode> all = (List<PhoneCode>) phoneCodeRepository.findAll();
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);
        return all;
    }


    @ResponseBody
    @RequestMapping(value = "/deletetesttmp")
    public Object testtmp() {
        tmpSelectUserRepository.deleteByCustomerid(277);
        return true;
    }


    @ResponseBody
    @RequestMapping(value = "/findById")
    public Object findById(String phonenumber) {
        List l=new ArrayList();
        PhoneCode all= (PhoneCode)phoneCodeRepository.findByPhonenumber(phonenumber);
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);
        return all;
    }


    @ResponseBody
    @RequestMapping(value = "/findByIdAndPhonenumber")
    public Object findByIdAndPhonenumber(String phonenumber,int id) {
        List l=new ArrayList();
        PhoneCode all= (PhoneCode)phoneCodeRepository.findByPhonenumberAndId(phonenumber,id);
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);
        return all;
    }


    @ResponseBody
    @RequestMapping(value = "/findByIdOrPhonenumber")
    public Object findByIdOrPhonenumber(String phonenumber,int id) {
        List l=new ArrayList();
        PhoneCode all= (PhoneCode)phoneCodeRepository.findByPhonenumberOrId(phonenumber,id);
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);
        return all;
    }


    @ResponseBody
    @RequestMapping(value = "/findByPhonenumberLike")
    public Object findByPhonenumberLike(String phonenumber) {
        List l=new ArrayList();
        List<PhoneCode> all= (List<PhoneCode>)phoneCodeRepository.findByPhonenumberLike("%"+phonenumber+"%");
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);

        return all;
    }


    @ResponseBody
    @RequestMapping(value = "/findone")
    public Object findone(String phonenumber) {
        List l=new ArrayList();
        PhoneCode all= phoneCodeRepository.findByone(phonenumber);
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);

        return all;
    }




    @ResponseBody
    @RequestMapping(value = "/findByIdIn")
    public Object findByIdIn(int id1,int id2) {
        List l2=new ArrayList();
        l2.add(id1);
        l2.add(id2);

        List l=new ArrayList();
        List<PhoneCode> all= phoneCodeRepository.findByIdIn(l2);
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);

        return all;
    }


    @ResponseBody
    @RequestMapping(value = "/findBytimebetween")
    public Object findBytimebetween(String t1,String t2) {
        List l=new ArrayList();
        List<PhoneCode> all= phoneCodeRepository.findBytimeBetween(t1,t2);
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);

        return all;
    }




    @ResponseBody
    @RequestMapping(value = "/findByidless")
    public Object findByidless(int id) {
        List l=new ArrayList();
        List<PhoneCode> all= phoneCodeRepository.findByIdLessThan(id);
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);

        return all;
    }




    @ResponseBody
    @RequestMapping(value = "/findByidgrate")
    public Object findByidgrate(int id) {
        List l=new ArrayList();
        List<PhoneCode> all= phoneCodeRepository.findByIdGreaterThan(id);
//        User u=all.get(0);
//        u.setUserRoles(null);
//        u.setAddressSet(null);

        return all;
    }


    @ResponseBody
    @RequestMapping(value = "/saveTmpselectuser")
    public Object saveTmpselectuser() {
        TmpSelectUser t=new TmpSelectUser();
        t.setCustomerid(1);
        t.setUserid(1);
        t.setUserlogo("123");
        t.setUsernumber("123");
        t.setLanguage("西瓜");
        tmpSelectUserRepository.save(t);

        return true;
    }


    @ResponseBody
    @RequestMapping(value = "/getTmpselectuser")
    public Object getTmpselectuser(int customerid) {

        List<TmpSelectUser> byCustomerid = tmpSelectUserRepository.findByCustomerid(customerid);

        return byCustomerid;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteTmpselectuser")
    public Object deleteTmpselectuser(int id) {
        TmpSelectUser t=new TmpSelectUser();
        t.setId(id);
        tmpSelectUserRepository.delete(t);

        return true;
    }


//    @ResponseBody
//    @RequestMapping(value = "/findByidpage")
//    public Object findByidpage(String phonenumber,QueryModel dm) {
//        //根据请求参数封装一个分页信息对象
//        dm.setSort("time");
//        Pageable pageable = PageRequestTools.pageRequesMake(dm);
//        List l=new ArrayList();
//        Page<PhoneCodePojo> all= phoneCodeRepository.findByPhonenumberLike("%"+phonenumber+"%",pageable);
////        User u=all.get(0);
////        u.setUserRoles(null);
////        u.setAddressSet(null);
//
//        return all;
//    }

//    @ResponseBody
//    @RequestMapping(value = "/adduser")
//    public Object adduser() {
//        User u=new User();
//        u.setFirstName("test");
//        u.setLastName("xuxiaohe");
//        u.setPassword("222");
//        userRepository.save(u);
//        return u;
//    }

//    @ResponseBody
//    @RequestMapping(value = "/findname")
//    public Object findname() {
//
//        User test = userRepository.findByUsername("");
//
//        return test;
//    }



}

