package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 针对EasyUiDataGrid插件封装的基类，抽取出来，系统中其他类都可以使用
 * @author Administrator
 *
 */
public class EasyUiDataGridResult implements Serializable {
	
	private long total;	//总记录数
	private List<?> rows;	//返回的数据集合
	public EasyUiDataGridResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EasyUiDataGridResult(long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
