package com.transn.houtai.controller.frontController;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.transn.houtai.controller.BaseController;
import com.transn.houtai.domain.BannerManger;
import com.transn.houtai.domain.Categorys;
import com.transn.houtai.domain.Liuyan;
import com.transn.houtai.domain.News;
import com.transn.houtai.service.*;
import com.transn.houtai.util.FileUpload;
import com.transn.houtai.util.PageRequestTools;
import com.transn.houtai.util.StringUtil;
import com.transn.houtai.util.pages.QueryModelMul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Controller
public class FrontController extends BaseController{

    @Autowired
    private NewsService newsService;

    @Autowired
    private BannerMangerService bannerMangerService;


    @Autowired
    private LiuyanService liuyanService;

    /*
             *新闻列表页面
             */
    @RequestMapping("/")
    public String index(Model model,HttpServletRequest request) {
        QueryModelMul dm=new QueryModelMul();
        dm.setN(1);
        dm.setS(6);
        List<String> sort = new ArrayList<String>();
        sort.add("orders");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<BannerManger> bannerMangers = bannerMangerService.getallBannerByPage(pageable);
        QueryModelMul dm2=new QueryModelMul();
        dm2.setN(1);
        dm2.setS(3);
        List<String> sort2 = new ArrayList<String>();
        sort2.add("top");
        dm2.setSort(sort2);
        Pageable pageable2 = PageRequestTools.pageRequesMake(dm2);
        Page<News> newss = newsService.getallNewsByPage(pageable2);

        model.addAttribute("data", bannerMangers);
        model.addAttribute("news", newss);
        return "/front/index2";
    }



    /*
            *新闻列表页面
            */
    @RequestMapping("/about")
    public String about(Model model,HttpServletRequest request) {

        return "/front/about";
    }


    /*
           *新闻列表页面
           */
    @RequestMapping("/join")
    public String join(Model model,HttpServletRequest request) {

        return "/front/comment";
    }

    /*
               *新闻列表页面
               */
    @RequestMapping("/commend")
    public String commend(Model model, HttpServletRequest request, Liuyan l) {
        if (!StringUtil.isBlank(l.getContent())) {
            l.setTime(System.currentTimeMillis());
            liuyanService.saveLiuyan(l);
        }

        return "/front/comment";
    }




}
