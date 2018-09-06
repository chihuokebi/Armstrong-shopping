package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 首页以及菜单页面跳转处理
 * @author Administrator
 *
 */
@Controller
public class ShowPageController {
	/**
	 * 访问首页跳转
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	/**
	 * 菜单页面跳转
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
