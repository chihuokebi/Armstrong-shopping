package com.taotao.service;

import com.taotao.common.pojo.EasyTreeNode;

import java.util.List;

/**
 * 商品分类管理Service
 * @author Administrator
 *
 */
public interface ItemCatService {
	
	public List<EasyTreeNode> getItemCatList(long parentId);
}
