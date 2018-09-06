package com.taotao.test;

import org.csource.fastdfs.*;
import org.junit.Test;

public class FastdfsTest {

	@Test
	public void test() throws Exception {
		//初始化全局配置，家在一个配置文件
		ClientGlobal.init("F:/xuexi2/taotao-manager/taotao-manager-web/src/main/resources/properties/client.conf");
		//创建一个TrackerClient对象，
		TrackerClient trackerClient = new TrackerClient();
		//创建一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//声明一个StorageServer对象，为null
		StorageServer storageServer = null;
		//获得StorageClient对象
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//直接调用storageClient上传文件
		String[] strings = storageClient.upload_file("D:\\IMG_0356.JPG", "JPG", null);
		//打印输出
		for (String string : strings) {
			System.out.println(string);
		}
	}

}
