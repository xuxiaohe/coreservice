package com.transn.houtai.controller.AdminController;

import com.transn.houtai.domain.AdminUser;
import com.transn.houtai.service.AdminUserService;
import com.transn.houtai.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@org.springframework.stereotype.Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;






}
