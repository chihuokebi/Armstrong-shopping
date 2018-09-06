package com.taotao.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页访问控制Controller
 * @author Administrator
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String showIndex(){
		return "index";
	}
}
