package com.taotao.controller;

import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUiDataGridResult;
import com.taotao.common.pojo.TaotaoResult;

/**
 * 规格参数COntroller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	
	@Autowired
	ItemParamService itemParamService;
	/**
	 * 获取规格参数
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUiDataGridResult getItemParam(Integer page, Integer rows){
		EasyUiDataGridResult result = itemParamService.getItemParam(page, rows);
		return result;
	}
	/**
	 * 判断该类目是否添加了规格参数模板
	 * @param cid
	 * @return
	 */
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult hasItemParam(@PathVariable long cid){
		TaotaoResult result = itemParamService.hasItemParam(cid);
		return result;
	}
	/**
	 * 保存itemParam商品规格参数
	 * @param cid
	 * @param paramData
	 * @return
	 */
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult saveItemParam(@PathVariable long cid, String paramData){
		TaotaoResult result = itemParamService.saveItemParam(cid, paramData);
		return result;
	}
	/**
	 * 删除规格参数
	 * @param cid
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult saveItemParam(String cid){
		TaotaoResult result = itemParamService.deleteItemParam(cid);
		return result;
	}
}
