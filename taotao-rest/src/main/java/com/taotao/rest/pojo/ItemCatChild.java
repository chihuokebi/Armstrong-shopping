package com.taotao.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemCatChild {
	/**
	 * 地址
	 * 
	 * 使用@JsonProperty是为了返回json时符合要求的命名格式
	 */
	@JsonProperty("u")
	private String url;
	/**
	 * 名字
	 */
	@JsonProperty("n")
	private String name;
	/**
	 * 类目
	 */
	@JsonProperty("i")
	private List item;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getItem() {
		return item;
	}
	public void setItem(List item) {
		this.item = item;
	}
	
}
