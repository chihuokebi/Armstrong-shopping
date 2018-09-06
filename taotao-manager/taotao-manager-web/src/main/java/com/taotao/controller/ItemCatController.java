package com.taotao.controller;

import java.util.List;

import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyTreeNode;

/**
 * 商品分类管理Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyTreeNode> getItemCat(@RequestParam(value="id",defaultValue = "0")long parentId){
		List<EasyTreeNode> result = itemCatService.getItemCatList(parentId);
		return result;
	}
}
