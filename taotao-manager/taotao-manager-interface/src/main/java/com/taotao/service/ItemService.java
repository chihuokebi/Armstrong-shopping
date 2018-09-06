package com.taotao.service;

import com.taotao.common.pojo.EasyUiDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	/**
	 * 通过商品ID查询商品信息
	 * @param itemId
	 * @return 返回该商品信息，TbItem类型
	 */
	TbItem getItemById(Long itemId);
	/**
	 * 获取商品分页信息
	 * @param page 当前页数
	 * @param rows 当前页显示记录数
	 * @return 返回EasyUiDataGridResult对象
	 */
	EasyUiDataGridResult getItemList(Integer page, Integer rows);
}
