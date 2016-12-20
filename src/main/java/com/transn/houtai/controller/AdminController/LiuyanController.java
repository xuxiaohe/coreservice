package com.transn.houtai.controller.AdminController;

import com.transn.houtai.domain.Categorys;
import com.transn.houtai.domain.Liuyan;
import com.transn.houtai.domain.News;
import com.transn.houtai.service.AdminUserService;
import com.transn.houtai.service.LiuyanService;
import com.transn.houtai.util.PageRequestTools;
import com.transn.houtai.util.pages.QueryModelMul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuxiaohe on 2016/12/20.
 */
@Controller
@RequestMapping("/admin/liuyan")
public class LiuyanController {

    @Autowired
    private LiuyanService liuyanService;

    /*
             *新闻列表页面
             */
    @RequestMapping("liuyanlist")
    public String liuyanlist(Model model, HttpServletRequest request, QueryModelMul dm) {

        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);

        Pageable pageable = PageRequestTools.pageRequesMake(dm);

        Page<Liuyan> bannerMangers = liuyanService.getallLiuyanByPage(pageable);

        model.addAttribute("data", bannerMangers);
        return "/admin/liuyan";
    }


    /*
            *新闻列表页面
            */
    @RequestMapping("liuyaninfo")
    public String liuyaninfo(Model model, HttpServletRequest request,int id) {

        Liuyan bannerMangers = liuyanService.getOneLiuyan(id);

        model.addAttribute("data", bannerMangers);
        return "/admin/liuyaninfo";
    }


    /*
           *新闻列表页面
           */
    @ResponseBody
    @RequestMapping("addliuyan")
    public Object addliuyan(Model model, HttpServletRequest request, Liuyan l) {

        l.setTime(System.currentTimeMillis());
        liuyanService.saveLiuyan(l);
        return l;
    }


    /*
            *留言添加回复
            */
    @RequestMapping("backliuyan")
    public String backliuyan(Model model, HttpServletRequest request,int id,String back) {

        liuyanService.addBack(id,back);

        Liuyan bannerMangers = liuyanService.getOneLiuyan(id);

        model.addAttribute("data", bannerMangers);
        return "/admin/liuyaninfo";
    }


}
