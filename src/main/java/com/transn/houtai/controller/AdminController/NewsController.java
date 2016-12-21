package com.transn.houtai.controller.AdminController;

import com.transn.houtai.controller.BaseController;
import com.transn.houtai.domain.BannerManger;
import com.transn.houtai.domain.Categorys;
import com.transn.houtai.domain.News;
import com.transn.houtai.service.AdminUserService;
import com.transn.houtai.service.BannerMangerService;
import com.transn.houtai.service.CategoryService;
import com.transn.houtai.service.NewsService;
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
@RequestMapping("/admin/news")
public class NewsController extends BaseController{

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private NewsService newsService;


    @Autowired
    private CategoryService categoryService;

    /*
             *新闻列表页面
             */
    @RequestMapping("newslist")
    public String newslist(Model model,HttpServletRequest request,QueryModelMul dm) {

//        String n = request.getParameter("n");
//        if (!StringUtil.isBlank(n)) {
//            dm.setN(Integer.parseInt(n));
//        }
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);

        Pageable pageable = PageRequestTools.pageRequesMake(dm);

        Page<News> bannerMangers = newsService.getallNewsByPage(pageable);
//        List<Categorys> allCategory = categoryService.getAllCategory();
//        String ca = "";
//        if (allCategory.size() != 0) {
//            for (Categorys s : allCategory) {
//                ca += s.getName() + "  、";
//            }
//        }

        model.addAttribute("data", bannerMangers);
//        model.addAttribute("categorys", ca);
//        model.addAttribute("categorylist", allCategory);
        return "/admin/newslist";
    }


    /*
             *新闻列表页面
             */
    @ResponseBody
    @RequestMapping("newslist2")
    public Object newslist2(Model model, QueryModelMul dm) {
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<News> bannerMangers = newsService.getallNewsByPage(pageable);
        List<Categorys> allCategory = categoryService.getAllCategory();
        String ca = "";
        if (allCategory.size() != 0) {
            for (Categorys s : allCategory) {
                ca += s.getName() + "  、";
            }
        }

        return bannerMangers;
    }


    /*
             * 添加新闻页面
             */
    @RequestMapping("addnew")
    public String addnews(Model model, HttpServletRequest request) {
        List<Categorys> allCategory = categoryService.getAllCategory();
        model.addAttribute("categorys", allCategory);
        News n = new News();
        n.setContent("");
        n.setCategory("");
        n.setImage("");
        n.setTitle("");
        n.setTop(0);

        model.addAttribute("news", n);

        return "/admin/addnews2";
    }


    /*
           * 添加新闻页面
           */
    @RequestMapping("updatenews")
    public String updatenew(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        News oneNews = newsService.getOneNews(Integer.parseInt(id));
//        String text = oneNews.getContent();
//        text = text.substring(3, text.length() - 4);
//        text=text.replaceAll("<p>","");
//        text=text.replaceAll("</p>","");
//        oneNews.setContent(text);

        List<Categorys> allCategory = categoryService.getAllCategory();
        model.addAttribute("categorys", allCategory);
        model.addAttribute("news", oneNews);
        return "/admin/addnews2";
    }


    /*
             * 添加新闻
             */
    @RequestMapping("addnewinfo")
    public String addnewinfo(Model model, HttpServletRequest request, @RequestParam MultipartFile image) throws IOException {
        String title = request.getParameter("title");
        String categoryid = request.getParameter("ischoose");
        String top = request.getParameter("top");
        String content = request.getParameter("content");
        String isshow = request.getParameter("isshow");

        if (!StringUtil.isBlank(top) && "1".equals(top)) {
            newsService.updateByTop();
        }

        Categorys category = categoryService.getCategory(Integer.parseInt(categoryid));
        News n = new News();
        if (category != null) {
            n.setCategory(category.getName());
            n.setCategoryid(Integer.parseInt(categoryid));
        }
        String filePath1 = "";
        if (!image.isEmpty()) {
            filePath1 = FileUpload.uploadFile(image, request);
        }

        n.setImage(filePath1);
        n.setTitle(title);
        n.setContent(content);
        n.setTop(Integer.parseInt(top));
        n.setTime(System.currentTimeMillis());

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

        return "/admin/newslist";
    }


    /*
            * 添加分类
            */
    @RequestMapping("addCategory")
    public String addCategory(Model model, HttpServletRequest request) {

        String id = request.getParameter("id");
        String name = request.getParameter("categoryname");
        if (!StringUtil.isBlank(id)&&!"0".equals(id)) {
            if(!StringUtil.isBlank(name)){
                categoryService.updateCategoryByid(name,Integer.parseInt(id));
            }
        }
        else {

            Categorys c = new Categorys();
            c.setName(name);
            categoryService.saveCategory(c);
        }

        List<Categorys> allCategory = categoryService.getAllCategory();
        model.addAttribute("categorys", allCategory);
        return "/admin/categorylist";
    }

    /*
            * 删除分类
            */
    @RequestMapping("deleteCategory")
    public String deleteCategory(Model model, HttpServletRequest request) {


        String id = request.getParameter("id");
        Categorys c = new Categorys();
        c.setId(Integer.parseInt(id));
        categoryService.deleteCategory(c);

        List<Categorys> allCategory = categoryService.getAllCategory();
        model.addAttribute("categorys", allCategory);
        return "/admin/categorylist";
    }


    /*
            * 编辑分类
            */
    @RequestMapping("updateCategory")
    public String updateCategory(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        Categorys category = categoryService.getCategory(Integer.parseInt(id));
        model.addAttribute("category", category);
        return "/admin/addcategory";
    }


    /*
          获取分类列表
          */
    @RequestMapping("getcategorylist")
    public String getcategorylist(Model model, HttpServletRequest request) {
        List<Categorys> allCategory = categoryService.getAllCategory();
        model.addAttribute("categorys", allCategory);
        return "/admin/categorylist";
    }


    /*
          * 添加分类
          */
    @RequestMapping("addcategory")
    public String addcategory(Model model, HttpServletRequest request) {
        Categorys c = new Categorys();
        c.setName("");
        c.setId(0);
        model.addAttribute("category", c);
        return "/admin/addcategory";
    }



    /*
            * 删除新闻
            */
    @RequestMapping("deleteNews")
    public String deleteNews(Model model, HttpServletRequest request) {

        QueryModelMul dm =new QueryModelMul();
        String id = request.getParameter("id");
       News n=new News();
       n.setId(Integer.parseInt(id));
        newsService.deleteNews(n);
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);

        Pageable pageable = PageRequestTools.pageRequesMake(dm);

        Page<News> bannerMangers = newsService.getallNewsByPage(pageable);
        model.addAttribute("data", bannerMangers);
        return "/admin/newslist";
    }

}
