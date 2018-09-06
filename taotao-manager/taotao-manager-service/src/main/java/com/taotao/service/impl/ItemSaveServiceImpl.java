package com.taotao.service.impl;

import java.util.Date;

import com.taotao.service.ItemSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;

@Service
public class ItemSaveServiceImpl implements ItemSaveService {
	
	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	@Override
	public TaotaoResult itemSave(TbItem tbItem, String desc, String itemParams) {
		//生成商品ID
		long itemId = IDUtils.genItemId();
		tbItem.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除
		tbItem.setStatus((byte) 1);
		Date date = new Date();
		//设置创建时间和更新时间
		tbItem.setCreated(date);
		tbItem.setUpdated(date);
		//插入商品表
		tbItemMapper.insert(tbItem);
		//创建商品描述对象
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemId(itemId);
		tbItemDesc.setCreated(date);
		tbItemDesc.setUpdated(date);
		tbItemDesc.setItemDesc(desc);
		//插入商品描述表
		tbItemDescMapper.insert(tbItemDesc);
		//保存商品规格参数信息
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParams);
		itemParamItem.setCreated(date);
		itemParamItem.setUpdated(date);
		itemParamItemMapper.insert(itemParamItem);
		TaotaoResult result = TaotaoResult.ok();
		return result;
	}

}
