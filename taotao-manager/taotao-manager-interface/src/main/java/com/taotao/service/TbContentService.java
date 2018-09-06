package com.taotao.service;

import com.taotao.common.pojo.EasyUiDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * 内容管理Service
 * @author Administrator
 *
 */
public interface TbContentService {
	/**
	 * 添加内容分类详细
	 * @param content
	 * @return
	 */
	public TaotaoResult saveTbContent(TbContent content);
	/**
	 * 分页查找内容分类详细
	 */
	public EasyUiDataGridResult getTbContent(Long categoryId, Integer page, Integer rows);
}
