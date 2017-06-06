package blackHorse;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.json.JSONObject;

public class RecommendTest {

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
				"usertoken=C33kH2UwVqQ0ZcTG5bg4b0eNXA8ngq74b7djvCw5XSc.1496732782&pool=多周期共振策略&token=00000002:2359591317:debdf92aca398eb500e85819cd560ae4a9249d47");
		JSONObject ss;
        System.out.println(s);
        System.out.println(s);

//        //发送 POST 请求z
//        String sr=HttpRequest.sendPost("https://hao.360.cn", "key=123&v=456");
//        System.out.println(sr);
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	

}
