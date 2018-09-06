package com.taotao.common.pojo;

import java.io.Serializable;

/**
 * EasyTreeNode POJO
 * @author Administrator
 *
 */
public class EasyTreeNode implements Serializable {
	
	private long id;
	private String text;
	private String state;
	public EasyTreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public EasyTreeNode(long id, String text, String state) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
	}
	
}
