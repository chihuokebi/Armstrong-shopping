package com.taotao.controller;

import com.taotao.service.UploadPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.JsonUtils;

/**
 * 图片上传controller
 * @author Administrator
 *
 */
@Controller
public class PicController {
	
	@Autowired
	UploadPictureService picService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadPic(MultipartFile uploadFile) throws Exception{
		PictureResult pictureResult = picService.uploadFile(uploadFile);
		String result = JsonUtils.objectToJson(pictureResult);
		return result;
	}
	
}	
