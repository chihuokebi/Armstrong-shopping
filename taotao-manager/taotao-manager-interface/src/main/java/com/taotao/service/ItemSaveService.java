package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * 保存表单数据
 * @author Administrator
 *
 */
public interface ItemSaveService {
	/**
	 * 接收来自controller的两个参数，TbItem,和商品描述，String类型
	 * @param tbItem
	 * @param desc
	 * @return 返回类型为TaotaoResult
	 */
	TaotaoResult itemSave(TbItem tbItem, String desc, String itemParams);
}
