package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.JsonUtils;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;

@Controller
@RequestMapping("list")
public class ItemShowController {
	@Autowired
	private ItemCatService itemCatService;
	/**
	 * 支持jsonp
	 * @param callback
	 * @return
	 */
	@RequestMapping(value = "/cat/item", produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItems(String callback){
		 ItemCatResult itemCat = itemCatService.getItemCat();
		if(callback.isEmpty()){
			//使用jsonUtils将itemCat转换成json字符串
			String result = JsonUtils.objectToJson(itemCat);
			return result;
		}
		
		 // 如果callback不为空,拼接字符串
		 
		String result = JsonUtils.objectToJson(itemCat);
		result = callback+"("+ result +");";
		return result;
	}
	/*@RequestMapping(value = "/cat/item")
	@ResponseBody
	public Object getItems(String callback){
		ItemCatResult itemCat = itemCatService.getItemCat();
		if(callback.isEmpty()){
			//使用jsonUtils将itemCat转换成json字符串
			return itemCat;
		}
		
		 * 如果callback不为空,拼接字符串
		 
		MappingJacksonValue jacksonValue = new MappingJacksonValue(itemCat);
		jacksonValue.setJsonpFunction(callback);
		return jacksonValue;
	}*/
}
