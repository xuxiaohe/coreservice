package com.transn.houtai.controller.ossController;

import com.transn.houtai.controller.BaseController;
import com.transn.houtai.domain.userservicelog;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuxiaohe on 2016/11/30.
 */
@Controller
@RequestMapping("/oss")
public class ossController extends BaseController {

    @Autowired
    private UserServiceRepository userServiceRepository;

    @ResponseBody
    @RequestMapping("/save")
    public JSONPObject sub(HttpServletRequest request, HttpServletResponse response) {
        String  ossuserid = (String) request.getSession().getAttribute("names");
        String  username = (String) request.getSession().getAttribute("username");
        String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
        if(StringUtil.isBlank(ossuserid)){
            ResponseContainer responseContainer = addResponse(Config.STATUS_201, Config.MSG_201, null);
            return new JSONPObject(callbackFunName,responseContainer);
        }


        String name =request.getParameter("name");//得到js函数名称
        String info =request.getParameter("info");

        userservicelog u=new userservicelog();
        u.setOssuserid(Integer.parseInt(ossuserid));
        u.setInfo(info);
        u.setOssusername(username);
        u.setTime(System.currentTimeMillis()+"");
        userServiceRepository.save(u);

        ResponseContainer responseContainer = addResponse(Config.STATUS_200, Config.MSG_200, u);
        return new JSONPObject(callbackFunName,responseContainer);

    }
}
