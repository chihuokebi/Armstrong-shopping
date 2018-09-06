package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUiDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;

@Service
public class ItemParamServiceImpl implements ItemParamService {
	
	@Autowired
	private TbItemParamMapper tbItemParamMapper;
	@Override
	public EasyUiDataGridResult getItemParam(Integer page, Integer rows) {
		//设置分页参数
		PageHelper.startPage(page, rows);
		TbItemParamExample example = new TbItemParamExample();
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		for (TbItemParam tbItemParam : list) {
			String data = tbItemParam.getParamData();
			System.out.println(data);
		}
		//获取分页信息
		PageInfo<TbItemParam> pageInfo = new PageInfo<TbItemParam>(list);
		EasyUiDataGridResult result = new EasyUiDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}
	@Override
	public TaotaoResult hasItemParam(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		System.err.println("111111111");
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		for (TbItemParam tbItemParam : list) {
			String string = tbItemParam.getParamData();
			System.err.println(string);
		}
		TaotaoResult result = new TaotaoResult();
		if(list != null && list.size() > 0){
			result = result.ok(list.get(0));
			return result;
		}else{
			return result.ok();
		}
	}
	@Override
	public TaotaoResult saveItemParam(long cid, String paramData) {
		TbItemParam record = new TbItemParam();
		record.setItemCatId(cid);
		record.setParamData(paramData);
		record.setCreated(new Date());
		record.setUpdated(new Date());
		int insert = tbItemParamMapper.insert(record);
		TaotaoResult result = new TaotaoResult();
		return result.ok(insert);
	}
	@Override
	public TaotaoResult deleteItemParam(String ids) {
		TaotaoResult result = new TaotaoResult();
		if(ids == null || ids == ""){
			result.setStatus(404);
			result.setMsg("没有id");
		}
		String[] idss = ids.split(",");
		for (String string : idss) {
			System.out.println(string);
			tbItemParamMapper.deleteByPrimaryKey((long)Integer.valueOf(string));
		}
		
		return result.ok();
	}

}
