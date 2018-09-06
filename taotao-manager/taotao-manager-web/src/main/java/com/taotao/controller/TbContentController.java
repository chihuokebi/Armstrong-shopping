package com.taotao.controller;

import com.taotao.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUiDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * 内容管理Controller
 * @author Administrator
 *
 */
@RequestMapping("content")
@Controller
public class TbContentController {
	
	@Autowired
	private TbContentService tbContentService;
	
	/**
	 * 添加内容分类
	 * @param tbContent
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult saveTbContent(TbContent tbContent){
		TaotaoResult result = tbContentService.saveTbContent(tbContent);
		return result;
	}
	/**
	 * 查询内容分类详细信息
	 */
	@RequestMapping("/query/list")
	@ResponseBody
	public EasyUiDataGridResult getTbContent(Long categoryId, Integer page, Integer rows){
		EasyUiDataGridResult result = tbContentService.getTbContent(categoryId, page, rows);
		return result;
	}
}
