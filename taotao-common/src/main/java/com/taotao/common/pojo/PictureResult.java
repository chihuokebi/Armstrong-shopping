package com.taotao.common.pojo;
/**
 * 上传图片后响应前台的数据
 * @author Administrator
 *
 */
public class PictureResult {
	
	private int error;
	private String url;
	private String message;
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
