package com.transn.houtai.controller.frontController;

import com.transn.houtai.controller.BaseController;
import com.transn.houtai.domain.BannerManger;
import com.transn.houtai.domain.Categorys;
import com.transn.houtai.domain.News;
import com.transn.houtai.service.BannerMangerService;
import com.transn.houtai.service.CategoryService;
import com.transn.houtai.service.NewsService;
import com.transn.houtai.util.PageRequestTools;
import com.transn.houtai.util.StringUtil;
import com.transn.houtai.util.pages.QueryModelMul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Controller
@RequestMapping("/news")
public class FrontNewsController extends BaseController{

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

    /*
             *新闻列表页面
             */
    @RequestMapping("/newslist")
    public String newslist(Model model,HttpServletRequest request,QueryModelMul dm) {
        List<Categorys> allCategory = categoryService.getAllCategory();
        for(int i=0;i<allCategory.size();i++){
            if ("未分类".equals(allCategory.get(i).getName())) {
                allCategory.remove(i);
            }
        }
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);

        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        String name=request.getParameter("name");
        if (StringUtil.isBlank(name)&&allCategory.size()!=0) {
            name=allCategory.get(0).getName();
        }
        Page<News> bannerMangers = newsService.getallNewsByPageAndCategory(pageable,name);

        model.addAttribute("categorys", allCategory);
        model.addAttribute("data", bannerMangers);
        model.addAttribute("categoryname", name);
        return "/front/newslist";
    }


    /*
            *新闻详情
            */
    @RequestMapping("/newsinfo")
    public String newsinfo(Model model,HttpServletRequest request) {
        String id = request.getParameter("id");
        News oneNews = newsService.getOneNews(Integer.parseInt(id));

        List<Categorys> allCategory = categoryService.getAllCategory();
        for(int i=0;i<allCategory.size();i++){
            if ("未分类".equals(allCategory.get(i).getName())) {
                allCategory.remove(i);
            }
        }
        model.addAttribute("news", oneNews);
        model.addAttribute("categorys", allCategory);
        return "/front/newsinfo";
    }



}
