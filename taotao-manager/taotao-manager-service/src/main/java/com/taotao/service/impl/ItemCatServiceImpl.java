package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<EasyTreeNode> getItemCatList(long parentId) {
		//创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		//将查询结果遍历转存到EasyTreeNode的List里
		//创建List<EasyTreeNode>
		List<EasyTreeNode> nodeList = new ArrayList<EasyTreeNode>();
		for(TbItemCat tbItemCat : list){
			EasyTreeNode easyNode = new EasyTreeNode();
			easyNode.setId(tbItemCat.getId());
			easyNode.setText(tbItemCat.getName());
			easyNode.setState(tbItemCat.getIsParent() ?"closed":"open");
			nodeList.add(easyNode);
		}
		return nodeList;
	}

}
