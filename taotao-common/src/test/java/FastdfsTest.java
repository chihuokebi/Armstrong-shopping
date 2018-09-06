import static org.junit.Assert.*;
import org.junit.Test;
import com.taotao.common.utils.FastDFSClient;

public class FastdfsTest {

	@Test
	public void test() throws Exception {
		//加载配置文件
		FastDFSClient fastDFSClient = new FastDFSClient("F:/xuexi2/taotao-manager/taotao-manager-web/src/main/resources/properties/client.conf");
		//上传图片
		String string = fastDFSClient.uploadFile("D:\\IMG_0356.JPG", "JPG");
		System.out.println(string);
	}

}
