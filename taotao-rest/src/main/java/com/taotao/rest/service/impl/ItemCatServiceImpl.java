package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.pojo.ItemCatChild;
import com.taotao.rest.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	TbItemCatMapper itemCatMapper;
	@Override
	public ItemCatResult getItemCat() {
		// 调用Mapper层方法查询数据
		List catResult = getItemByParentId(0l);
		ItemCatResult result = new ItemCatResult();
		result.setData(catResult);
		return result;
	}
	private List getItemByParentId(Long parentId){
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> result = itemCatMapper.selectByExample(example);
		List array = new ArrayList<>();
		int index = 0;
		for (TbItemCat tbItemCat : result) {
			//判断是否是父节点
			if(tbItemCat.getIsParent()){
				if(index == 14){
					break;
				}
				ItemCatChild node = new ItemCatChild();
				node.setUrl("/products/"+tbItemCat.getId()+".html");
				//如果是一级节点
				if(tbItemCat.getParentId() == 0){
					node.setName("<a href='/products/1.html'>"+tbItemCat.getName()+"</a>");
				}else{
					node.setName(tbItemCat.getName());
				}
				//采用递归遍历查询结果
				node.setItem(getItemByParentId(tbItemCat.getId()));
				array.add(node);
				index++;
			}else{
				//如果是叶子结点
				String items = "/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName();
				array.add(items);
			}
		}
		return array;
	}
}
