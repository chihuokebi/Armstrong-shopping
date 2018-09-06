package com.taotao.controller;

import com.taotao.service.ItemSaveService;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUiDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;
/*	@Autowired
	ItemSaveService itemSaveService;*/
	/**
	 * 测试json数据
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value="/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable(value="itemId") long itemId){
		TbItem item = itemService.getItemById(itemId);
		System.out.println("少时诵诗书所所："+item.getTitle());
		return item;
	}
	/**
	 * 商品查询
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUiDataGridResult getItemList(Integer page, Integer rows){
		EasyUiDataGridResult result = itemService.getItemList(page, rows);
		System.out.println("查询成功");
		return result;
	}
/*	*//**
	 * 添加商品Controller
	 * @param tbItem
	 * @param desc
	 * @return
	 *//*
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult itemSave(TbItem tbItem, String desc, String itemParams){
		TaotaoResult result = itemSaveService.itemSave(tbItem, desc, itemParams);
		return result;
	}*/
}
