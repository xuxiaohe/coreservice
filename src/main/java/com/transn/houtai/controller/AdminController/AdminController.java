package com.transn.houtai.controller.AdminController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@org.springframework.stereotype.Controller
@RequestMapping("/admin/")
public class AdminController {
	
	/*
	 * 主页
	 */
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("message", "This测试信息") ;
		model.addAttribute("count", 21) ;
		model.addAttribute("execMode", "dev") ;
		model.addAttribute("login", true) ;
		model.addAttribute("role", "admin") ;
		model.addAttribute("manager", "manager") ;
		
		List<Map<String, Object>> prods = new ArrayList<Map<String, Object>>() ;
		Map<String, Object> prod = new HashMap<String, Object>() ;
		prod.put("name", "苹果") ;
		prod.put("price", 2.4) ;
		prod.put("inStock", true) ;
		prods.add(prod) ;
		model.addAttribute("prods", prods) ;
		
		return "index" ;
	}

	/*
	 * 主页
	 */
	@RequestMapping("testajax")
	public String testajax(Model model) {


		return "testajax" ;
	}

	
	/**
	 *  model:(模板测试). 
	 *  @return_type:String
	 *  @author zhangtian 
	 *  @return
	 */
	@RequestMapping("model")
	public String model(Model model) {
		model.addAttribute("date", new Date()) ;
		model.addAttribute("name", "中华任你") ;
		return "model" ;
	}


	@RequestMapping("/login")
	public String login() {
		return "admin/login" ;
	}
	

	/*
         * 横幅列表
         */
	@RequestMapping("hengfulist")
	public String hengfulist() {
		return "/admin/hengfulist" ;
	}



	/*
         * 横幅添加
         */
	@RequestMapping("addhengfu")
	public String addhengfu() {
		return "/admin/addhengfu" ;
	}



	@RequestMapping(value = "/userlogin")
	public String login(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if ("123".equals(name)) {
			model.addAttribute("name",name);
			model.addAttribute("passwd",password);
			return "/admin/hengfulist";
		}
		else {
			model.addAttribute("error","信息错误");
			return "/admin/login";
		}



	}


}
