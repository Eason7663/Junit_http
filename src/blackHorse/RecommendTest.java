package blackHorse;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.xml.internal.ws.api.message.saaj.SaajStaxWriter;

import net.sf.json.JSONObject;

public class RecommendTest {
	private String userName = null;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test1() {
		String s=HttpRequest.sendGet("http://10.15.144.72/dzh/blackhorse/recommend", 
				"usertoken=H52DYemO7bAUtbE9DBWfostrSDtH*nR1VQmv-*F8P5A.1496749135&pool=多周期共振策略&token=00000002:2359591317:debdf92aca398eb500e85819cd560ae4a9249d47");
		JSONObject ss = JSONObject.fromObject(s);

		System.out.println(ss.get(ss));

		
		
//        //发送 POST 请求z
//        String sr=HttpRequest.sendPost("https://hao.360.cn", "key=123&v=456");
//        System.out.println(sr);
	}
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//	
	

}
