package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import com.taotao.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUiDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;

@Service
public class TbContentServiceImpl implements TbContentService {
	@Autowired
	private TbContentMapper contentMapper;
	@Override
	public TaotaoResult saveTbContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//插入数据
		contentMapper.insert(content);
		return TaotaoResult.ok();
	}
	@Override
	public EasyUiDataGridResult getTbContent(Long categoryId, Integer page, Integer rows) {
		//设置分页参数
		PageHelper.startPage(page, rows);
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = contentMapper.selectByExample(example);
		//分页处理
		PageInfo<TbContent> info = new PageInfo<TbContent>(list); 
		EasyUiDataGridResult result = new EasyUiDataGridResult();
		result.setRows(info.getList());
		result.setTotal(info.getTotal());
		return result;
	}

}
