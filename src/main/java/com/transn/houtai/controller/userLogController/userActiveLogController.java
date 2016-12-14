package com.transn.houtai.controller.userLogController;

import com.transn.houtai.controller.BaseController;
import com.transn.houtai.domain.UserActiveLog;
import com.transn.houtai.domain.userservicelog;
import com.transn.houtai.repository.UserActiveLogRepository;
import com.transn.houtai.repository.UserServiceRepository;
import com.transn.houtai.util.Config;
import com.transn.houtai.util.ResponseContainer;
import com.transn.houtai.util.StringUtil;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xuxiaohe on 2016/11/30.
 */
@Controller
@RequestMapping("/userlog")
public class userActiveLogController extends BaseController {

    @Autowired
    private UserActiveLogRepository userActiveLogRepository;

    @ResponseBody
    @RequestMapping(value = "/save")
    public Object userserivcesave(HttpServletRequest request, HttpServletResponse response, UserActiveLog u) {
        u.setTime(System.currentTimeMillis()+"");
        userActiveLogRepository.save(u);
        return u;
    }


    @ResponseBody
    @RequestMapping(value = "/getall")
    public Object userserivcesave(HttpServletRequest request, HttpServletResponse response) {
        Iterable<UserActiveLog> all = userActiveLogRepository.findAll();
        return all;
    }
}
