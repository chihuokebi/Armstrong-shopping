package com.taotao.service;

import com.taotao.common.pojo.EasyUiDataGridResult;
import com.taotao.common.pojo.TaotaoResult;

/**
 * 规格参数Service
 * @author Administrator
 *
 */
public interface ItemParamService {
	/**
	 * 获取规格参数
	 * @return TbItemParam
	 */
	EasyUiDataGridResult getItemParam(Integer page, Integer rows);
	/**
	 * 判断是否添加规格参数
	 * @author Administrator
	 *
	 */
	TaotaoResult hasItemParam(long cid);
	/**
	 * 保存商品规格参数模板
	 * @param cid
	 * @param paramData
	 * @return
	 */
	TaotaoResult saveItemParam(long cid, String paramData);
	TaotaoResult deleteItemParam(String ids);
}
