package com.taotao.service.impl;

import com.taotao.service.UploadPictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.FastDFSClient;

@Service
public class UploadPictureServiceImpl implements UploadPictureService {
	
	//从属性文件里面去图片服务器的基础url
	@Value("${IMAGE_SERVICE_BASE_URL}")
	private String IMAGE_SERVICE_BASE_URL;

	@Override
	public PictureResult uploadFile(MultipartFile uploadFile) throws Exception {
		PictureResult result = new PictureResult();
		//判断图片是否为空，如果为空直接返回错误信息
		if(uploadFile.isEmpty()){
			result.setError(1);
			result.setMessage("图片为空");
			return result;
		}
		//调用工具类上传图片
		FastDFSClient fastDFSClient = new FastDFSClient("classpath:properties/client.conf");
		//取扩展名
		String filename = uploadFile.getOriginalFilename();
		String extName = filename.substring(filename.lastIndexOf(".") + 1);
		String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
		url = IMAGE_SERVICE_BASE_URL+url;
		result.setError(0);
		result.setUrl(url);
		return result;
	}

}
