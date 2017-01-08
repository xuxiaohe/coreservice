package com.transn.houtai.controller.AdminController;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.transn.houtai.controller.BaseController;
import com.transn.houtai.domain.AdminUser;
import com.transn.houtai.domain.BannerManger;
import com.transn.houtai.domain.Categorys;
import com.transn.houtai.domain.News;
import com.transn.houtai.service.AdminUserService;
import com.transn.houtai.service.BannerMangerService;
import com.transn.houtai.service.CategoryService;
import com.transn.houtai.service.NewsService;
import com.transn.houtai.util.Config;
import com.transn.houtai.util.PageRequestTools;
import com.transn.houtai.util.StringUtil;
import com.transn.houtai.util.pages.QueryModelMul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;


@Controller
public class AdminloginController extends BaseController{

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private BannerMangerService bannerMangerService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

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
            model.addAttribute("addnewsaddress", Config.ADDNEWS);

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

    @ResponseBody
    @RequestMapping("/addadmin")
    public Object addadmin(AdminUser a) {
        a.setTime(System.currentTimeMillis()+"");
        adminUserService.saveAdminUser(a);
        return a;
    }



    /*
             * 添加新闻
             */
    @ResponseBody
    @RequestMapping("addnewinfo")
    public Object addnewinfo(Model model, HttpServletRequest request) throws IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String categoryid = request.getParameter("ischoose");
        String top = request.getParameter("top");
        String content = request.getParameter("content");
        String oldimage = request.getParameter("oldimage");

        if (!StringUtil.isBlank(top) && "1".equals(top)) {
            newsService.updateByTop();
        }

        Categorys category = categoryService.getCategory(Integer.parseInt(categoryid));
        News n = new News();
        if (category != null) {
            n.setCategory(category.getName());
            n.setCategoryid(Integer.parseInt(categoryid));
        }

        if (StringUtil.isBlank(oldimage)) {
            n.setImage("");
        }else {
            n.setImage(oldimage);
        }
        n.setTitle(title);
        n.setContent(content);
        n.setTop(Integer.parseInt(top));
        n.setTime(System.currentTimeMillis());
        n.setSubcontent(removeHtmlTag(content));

        if(!StringUtil.isBlank(id)){
            n.setId(Integer.parseInt(id));
        }

        News news = newsService.saveBanner(n);

        QueryModelMul dm = new QueryModelMul();
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<News> bannerMangers = newsService.getallNewsByPage(pageable);
        List<Categorys> allCategory = categoryService.getAllCategory();
        model.addAttribute("data", bannerMangers);
        model.addAttribute("categorys", allCategory);

        Map m=new HashMap();
        m.put("data",true);
        return m;

    }




    /*
           * 添加新闻页面
           */
    @ResponseBody
    @RequestMapping("addnews")
    public Object updatenew(HttpServletRequest request) {
//        String id = request.getParameter("id");
//        News oneNews = newsService.getOneNews(Integer.parseInt(id));
//        String text = oneNews.getContent();
//        text = text.substring(3, text.length() - 4);
//        text=text.replaceAll("<p>","");
//        text=text.replaceAll("</p>","");
//        oneNews.setContent(text);

        List<Categorys> allCategory = categoryService.getAllCategory();
        Map m=new HashMap();
        m.put("data",allCategory);

        return m;
    }



    /*
          * 编辑新闻页面
          */
    @ResponseBody
    @RequestMapping("updateaddnews")
    public Object updateaddnews(HttpServletRequest request) {
        String id = request.getParameter("id");
        News oneNews = newsService.getOneNews(Integer.parseInt(id));

        List<Categorys> allCategory = categoryService.getAllCategory();
        Map m=new HashMap();
        m.put("data",allCategory);
        m.put("news",oneNews);

        return m;
    }



}
