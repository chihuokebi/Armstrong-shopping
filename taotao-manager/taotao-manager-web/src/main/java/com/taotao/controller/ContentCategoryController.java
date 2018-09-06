package com.taotao.controller;

import java.util.List;

import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyTreeNode;
import com.taotao.common.pojo.TaotaoResult;

/**
 * 内容分类业务逻辑
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/content")
public class ContentCategoryController {

	@Autowired
	ContentCategoryService contentCategoryService;
	/**
	 * 查询内容分类节点信息
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value = "/category/list")
	@ResponseBody
	public List<EasyTreeNode> getCategories(@RequestParam(value="id", defaultValue="0")Long parentId){
		List<EasyTreeNode> result = contentCategoryService.getContentCategory(parentId);
		return result;
	}
	/**
	 * 添加内容分类节点信息
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("/category/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId, String name){
		TaotaoResult createContentCategory = contentCategoryService.createContentCategory(parentId, name);
		return createContentCategory;
	}
	/**
	 * 删除节点
	 * @param parentId
	 * @param id
	 * @return
	 */
	@RequestMapping("/category/delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(Long parentId, Long id){
		TaotaoResult result = contentCategoryService.deleteContentCategory(parentId, id);
		return result;
	}
	/**
	 * 修改内容分类节点名称
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/category/update")
	@ResponseBody
	public TaotaoResult updateContentCategory(Long id, String name){
		TaotaoResult result = contentCategoryService.updateContentCategory(id, name);
		return result;
	}
}
