package com.taotao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {

	@Test
	public void test() {
		//1、获取mapper
		ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		TbItemMapper itemMapper = ioc.getBean(TbItemMapper.class);
		//2、设置分页参数
		PageHelper.startPage(4, 100);
		//3、sql语句
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//4、取分页后结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("total:"+total);
		int pages = pageInfo.getPages();
		System.out.println("pages:"+pages);
		int pageSize = pageInfo.getPageSize();
		System.out.println("pageSize:"+pageSize);
	}

}
