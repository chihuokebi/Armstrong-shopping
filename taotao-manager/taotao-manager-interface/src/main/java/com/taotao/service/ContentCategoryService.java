package com.taotao.service;

import com.taotao.common.pojo.EasyTreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * 内容分类业务逻辑
 * @author Administrator
 *
 */
public interface ContentCategoryService {
	/**
	 * 获取后台内容分类节点信息
	 * @return
	 */
	List<EasyTreeNode> getContentCategory(Long parentId);
	/**
	 * 添加内容分类节点
	 * @param parentId
	 * @param name
	 * @return
	 */
	TaotaoResult createContentCategory(Long parentId, String name);
	/**
	 * 删除内容分类节点
	 * @param parentId
	 * @param id
	 * @return
	 */
	TaotaoResult deleteContentCategory(Long parentId, Long id);
	/**
	 * 修改内容分类节点名称
	 * @param id
	 * @param name
	 * @return
	 */
	TaotaoResult updateContentCategory(Long id, String name);
}
