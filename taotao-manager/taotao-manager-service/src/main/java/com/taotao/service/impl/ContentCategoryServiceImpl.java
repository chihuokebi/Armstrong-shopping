package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	private TbContentCategoryMapper categoryMapper;
	@Override
	public List<EasyTreeNode> getContentCategory(Long parentId) {
		/**
		 * 通过父节点查询子节点信息
		 * 将查询的数据转换为要返回的数据
		 */
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = categoryMapper.selectByExample(example);
		//遍历list，判断每条数据是否是父节点；是：设置state为close，否则，反之
		List<EasyTreeNode> nodeList  = new ArrayList<EasyTreeNode>();
		for (TbContentCategory tbContentCategory : list) {
			EasyTreeNode node = new EasyTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			nodeList.add(node);
		}
		return nodeList;
	}
	@Override
	public TaotaoResult createContentCategory(Long parentId, String name) {
		TbContentCategory category = new TbContentCategory();
		category.setParentId(parentId);
		category.setName(name);
		category.setIsParent(false);
		category.setSortOrder(1);
		//1(正常)，2(删除)
		category.setStatus(1);
		category.setCreated(new Date());
		category.setUpdated(new Date());
		categoryMapper.insert(category);
		//返回主键
		Long id = category.getId();
		System.out.println(id);
		/*
		 * 当添加分类节点的同时判断父节点是否是叶子节点，如果是叶子节点，则更新isParent字段。
		 */
		TbContentCategory parentNode = categoryMapper.selectByPrimaryKey(parentId);
		if(!parentNode.getIsParent()){
			TbContentCategory tbContentCategory = new TbContentCategory();
			tbContentCategory.setIsParent(true);
			tbContentCategory.setId(parentNode.getId());
			categoryMapper.updateByPrimaryKeySelective(tbContentCategory);
		}
		return TaotaoResult.ok(id);
	}
	@Override
	public TaotaoResult deleteContentCategory(Long parentId, Long id) {
		/*
		 * 1：删除叶子节点==>直接删除；
		 * 2：删除父节点==>查询该父节点下所有子节点，循环遍历递归删除，删除父节点包括全部子节点，，采用递归。
		 */
		try {
			deleteForeach(parentId, id);
			return TaotaoResult.ok();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(500, e.toString());
		}
	}
	private void deleteForeach(Long parentId, Long id){
		TbContentCategory primaryKey = categoryMapper.selectByPrimaryKey(id);
		if(!primaryKey.getIsParent()){
			//是叶子节点直接删除
			categoryMapper.deleteByPrimaryKey(id);
		}else{
			/**
			 * 不是叶子节点，通过id查询所有子节点，并遍历删除
			 */
			TbContentCategoryExample example = new TbContentCategoryExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andParentIdEqualTo(id);
			//遍历删除儿子
			List<TbContentCategory> list = categoryMapper.selectByExample(example);
			for (TbContentCategory tbContentCategory : list) {
				deleteForeach(tbContentCategory.getParentId(), tbContentCategory.getId());
			}
			//删除自己
			deleteForeach(parentId, id);
		}
		//判断该节点的父节点下面是否还有子节点，无的话修改父节点状态
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> selectByExample = categoryMapper.selectByExample(example);
		if(selectByExample.size()==0){
			TbContentCategory record = new TbContentCategory();
			record.setIsParent(false);
			record.setId(parentId);
			categoryMapper.updateByPrimaryKeySelective(record);
		}
	}
	@Override
	public TaotaoResult updateContentCategory(Long id, String name) {
		TbContentCategory category = new TbContentCategory();
		category.setId(id);
		category.setName(name);
		categoryMapper.updateByPrimaryKeySelective(category);
		return TaotaoResult.ok();
	}
}
