package com.transn.houtai.controller.AdminController;

import com.transn.houtai.domain.AdminUser;
import com.transn.houtai.domain.BannerManger;
import com.transn.houtai.service.AdminUserService;
import com.transn.houtai.service.BannerMangerService;
import com.transn.houtai.util.PageRequestTools;
import com.transn.houtai.util.StringUtil;
import com.transn.houtai.util.pages.QueryModelMul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
public class AdminloginController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private BannerMangerService bannerMangerService;

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }


    @RequestMapping(value = "/userlogin")
    public String login(HttpServletRequest request, Model model, AdminUser a) {

        boolean b = false;
        if (!StringUtil.isBlank(a.getName()) && !StringUtil.isBlank(a.getPassword())) {
            if (adminUserService.isAdminUser(a)) {

                b = true;
            }
        }

        if (b) {
            request.getSession().setAttribute("name", a.getName());
            QueryModelMul dm = new QueryModelMul();
            List<String> sort = new ArrayList<String>();
            sort.add("time");
            dm.setSort(sort);
            Pageable pageable = PageRequestTools.pageRequesMake(dm);
            Page<BannerManger> bannerMangers = bannerMangerService.getallBannerByPage(pageable);
            model.addAttribute("data",bannerMangers);
            return "/admin/hengfulist";

        } else {
            model.addAttribute("error", "用户信息有误！");
            return "/admin/login";
        }


    }





    @RequestMapping(value = "/userlogout")
    public String userlogout(HttpServletRequest request) {
            request.getSession().setAttribute("name", "");
            return "/admin/login";
        }





}
