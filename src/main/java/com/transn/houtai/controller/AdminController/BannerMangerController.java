package com.transn.houtai.controller.AdminController;

import com.transn.houtai.domain.BannerManger;
import com.transn.houtai.service.AdminUserService;
import com.transn.houtai.service.BannerMangerService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@org.springframework.stereotype.Controller
@RequestMapping("/admin/manger")
public class BannerMangerController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private BannerMangerService bannerMangerService;


    /*
         * 横幅列表
         */
    @RequestMapping("gethengfulist")
    public String hengfulist(Model model, QueryModelMul dm) {
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<BannerManger> bannerMangers = bannerMangerService.getallBannerByPage(pageable);
        model.addAttribute("data", bannerMangers);
        return "/admin/hengfulist";
    }


    /*
        * 横幅列表
        */
    @ResponseBody
    @RequestMapping("gethengfulist2")
    public Object hengfulist2(Model model, QueryModelMul dm) {
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<BannerManger> bannerMangers = bannerMangerService.getallBannerByPage(pageable);
        return bannerMangers;
    }


    /*
         * 横幅添加
         */
    @RequestMapping("addhengfu")
    public String addhengfu(Model model) {
        BannerManger b =new BannerManger();
        b.setId(0);
        b.setImage("");
        b.setUrl("");
        b.setTitle("");
        b.setOrders(0);

        model.addAttribute("data", b);
        return "/admin/addhengfu";
    }


    /*
         * 横幅添加
         */
    @RequestMapping("addhengfuinfo")
    public String addhengfuinfo(Model model,HttpServletRequest request, @RequestParam MultipartFile image) throws IOException {
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        String order = request.getParameter("order");
        String oldimage = request.getParameter("oldimage");
        String id = request.getParameter("id");




        BannerManger b = new BannerManger();
        if (!StringUtil.isBlank(id)) {
            b.setId(Integer.parseInt(id));
        }
        b.setTitle(title);
        b.setUrl(url);
        b.setOrders(Integer.parseInt(order));
        b.setTime(System.currentTimeMillis() + "");
        if(image.isEmpty()){
            b.setImage(oldimage);
        }else {
            String filePath1 = FileUpload.uploadFile(image, request);
            b.setImage(filePath1);
        }


            BannerManger bannerManger = bannerMangerService.saveBanner(b);


        QueryModelMul dm = new QueryModelMul();
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<BannerManger> bannerMangers = bannerMangerService.getallBannerByPage(pageable);
        model.addAttribute("data", bannerMangers);


        return "/admin/hengfulist";
    }


    /*
         * 横幅列表
         */
    @RequestMapping("deletehengfu")
    public String deletehengfu(Model model, BannerManger b) {

        boolean b1 = bannerMangerService.deleteBanner(b);
        QueryModelMul dm = new QueryModelMul();
        List<String> sort = new ArrayList<String>();
        sort.add("time");
        dm.setSort(sort);
        Pageable pageable = PageRequestTools.pageRequesMake(dm);
        Page<BannerManger> bannerMangers = bannerMangerService.getallBannerByPage(pageable);
        model.addAttribute("data", bannerMangers);

        return "/admin/hengfulist";
    }


    /*
             * 横幅列表
             */
//    @ResponseBody
    @RequestMapping("getOnehengfu")
    public String getOnehengfu(Model model,HttpServletRequest request ,BannerManger b) {
//        String id = request.getParameter("id");
        BannerManger b1 = bannerMangerService.getOneBanner(b.getId());

        model.addAttribute("data", b1);

        return "/admin/addhengfu";
//        return b1;
    }



}
