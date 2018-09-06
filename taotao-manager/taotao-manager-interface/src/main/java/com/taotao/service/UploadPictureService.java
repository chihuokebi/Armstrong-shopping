package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传图片Service
 * @author Administrator
 *
 */
public interface UploadPictureService {
	
	PictureResult uploadFile(MultipartFile uploadFile) throws Exception;
}
