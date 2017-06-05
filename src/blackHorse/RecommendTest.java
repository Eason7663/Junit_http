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
		String s=HttpRequest.sendGet("https://hao.360.cn", "key=123&v=456");
		JSONObject ss;
        System.out.println(s);

//        //∑¢ÀÕ POST «Î«Ûz
//        String sr=HttpRequest.sendPost("https://hao.360.cn", "key=123&v=456");
//        System.out.println(sr);
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	

}
