package com.taotao.service.impl;

import java.util.List;

import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUiDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;

/**
 * 商品查询service
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem getItemById(Long itemId) {
		//使用拼装sql语句的方法
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		//通过id查询
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		
		TbItem tbItem = null;
		if(list != null && list.size() > 0){
			 tbItem = list.get(0);
		}
		return tbItem;
	}
	@Override
	public EasyUiDataGridResult getItemList(Integer page, Integer rows) {
		//使用分页插件进行设置
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		//调用mapper接口进行查询,使用拼sql方法查询，参数为null，群表查询
		List<TbItem> list = itemMapper.selectByExample(example);
		//返回的EasyUiDataGridResult对象中有total和rows两个属性，使用pageInfo从list中获取
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//创建EasyUiDataGridResult对象
		EasyUiDataGridResult result = new EasyUiDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}

}
