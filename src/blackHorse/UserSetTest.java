/**
 * 
 */
package blackHorse;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import blackHorseUtil.UserToken;
import fileOperator.ExcelOperator;
import fileOperator.GsonUtil;
import net.sf.json.JSONObject;
import requestUtils.HttpRequest;

/**
 * @author Administrator
 *
 */
public class UserSetTest {
	private static Logger logger = Logger.getLogger(UserSetTest.class);
	private static Properties Prop = new Properties();
	
	private ExcelOperator excelOperator = null;
	private ArrayList<String> paramArrayList;
	private String userName;
	private String userSetHost; //һ��Ϊua��ַ
	private String usertoken;
	private String token;
	private String prefer;
	private String pool;
	private String stock;
	
	
	public String getUserName() {
		return userName;
	}

	public String getUserSetHost() {
		return userSetHost;
	}

	public String getUsertoken() {
		return usertoken;
	}

	public String getToken() {
		return token;
	}

	public String getPrefer() {
		return prefer;
	}

	public String getPool() {
		return pool;
	}

	public String getStock() {
		return stock;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserSetHost(String userSetHost) {
		this.userSetHost = userSetHost;
	}

	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setPrefer(String prefer) {
		this.prefer = prefer;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public static String makeContent(String Usertoken, String token, String pool, String... strPrefer) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("usertoken=");
		stringBuilder.append(Usertoken);
		stringBuilder.append("&token=");
		stringBuilder.append(token);
		stringBuilder.append("&pool=");
		stringBuilder.append(pool);
		if (strPrefer!= null) {
			stringBuilder.append("&prefer=");
			stringBuilder.append(strPrefer);
		}
		return stringBuilder.toString();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Prop.load(new FileReader("dat\\userset.properties"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		setUserName(Prop.getProperty("username"));
		setUsertoken(UserToken.getUserToken(getUserName()));
//		this.excelOperator = new ExcelOperator(".\\dat\\test case.xlsx");
//		this.paramArrayList.addAll(excelOperator.getParam("parameters", "prefer"));
		setUserSetHost(Prop.getProperty("host"));
		setToken(Prop.getProperty("token"));
		setPool(Prop.getProperty("pool"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addTest() {
		String strURL = HttpRequest.makeURL(getUserSetHost(),UserSetTest.Prop.getProperty("preferAddPath"));
		String strContent = UserSetTest.makeContent(getUsertoken(), getToken(), Prop.getProperty("pool"),Prop.getProperty("prefer"));
		String strResponse = HttpRequest.sendGet(strURL, strContent);
		UserSetPreferCommonResponse commonResponse = GsonUtil.parseJsonWithGson(strResponse, UserSetPreferCommonResponse.class);
		if (commonResponse == null) {
			logger.error("������Ϊ��!");
		}else{
			if (commonResponse.getErr() == -1) {
				logger.error("���ù�Ʊƫ�ýӿڲ���������ִ�У�fail!");
				logger.error(commonResponse.getData().getDesc());
				fail("ƫ�ýӿ����󷵻�ʧ��!");
			}else{
				assertSame("����ʧ��", 0, commonResponse.getErr());
				logger.info("���ù�Ʊƫ�ýӿڲ���������ִ�У�pass!");
			}
		}
	}
	
	@Test
	public void getTest(){
		String strURL = HttpRequest.makeURL(getUserSetHost(),UserSetTest.Prop.getProperty("preferGetPath"));
		String strContent = UserSetTest.makeContent(getUsertoken(), getToken(), Prop.getProperty("pool"));
		String strResponse = HttpRequest.sendGet(strURL, strContent);
		
		JSONObject jsonObject = JSONObject.fromObject(strResponse);
		
		
		UserSetPreferGetResponse userSetPreferGetResponse = GsonUtil.parseJsonWithGson(strResponse, UserSetPreferGetResponse.class);
		if (userSetPreferGetResponse == null) {
			logger.error("������Ϊ��!");
			fail("��ȡ��Ʊƫ�ýӿڲ���������ִ�У�failed!");
		}else{
			if (userSetPreferGetResponse.getErr() == -1) {
				logger.error("��ȡ��Ʊƫ�ýӿڲ���������ִ�У�fail!");
				logger.error(userSetPreferGetResponse.getData());
				fail("ƫ�ýӿ����󷵻�ʧ��!");
			}else{
				assertSame("��ȡʧ��", 0, userSetPreferGetResponse.getErr());
				logger.info("��ȡ��Ʊƫ�ýӿڲ���������ִ�У�pass!");
			}
		}
	}

}
