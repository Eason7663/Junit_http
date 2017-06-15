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

import com.sun.org.apache.bcel.internal.generic.NEW;

import blackHorseUtil.UserToken;
import fileOperator.ExcelOperator;
import fileOperator.GsonUtil;
import net.sf.json.JSONObject;
import requestUtils.HttpRequest;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
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

	public static String makeContent(String Usertoken, String token, String pool, String strPrefer) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("usertoken=");
		stringBuilder.append(Usertoken);
		stringBuilder.append("&token=");
		stringBuilder.append(token);
		stringBuilder.append("&pool=");
		stringBuilder.append(pool);
		stringBuilder.append("&prefer=");
		stringBuilder.append(strPrefer);
		return stringBuilder.toString();
	}
	
	/**
	 * @Description ������־�����ɲ��Խ��
	 * @param logger ������־
	 * @param strCaseName ����������
	 * @param strResponse ������Ӧ�ַ���
	 * @return_type void
	 * @author Eason
	 * @date 2017��6��15�� ����5:45:11  
	 */
	public void logInfo(Logger logger, String strCaseName, String strResponse) {
		if (JSONObject.fromObject(strResponse).get("Err").equals(0)) {
			assertEquals("���ش���", 0, JSONObject.fromObject(strResponse).get("Err"));
			logger.info(strCaseName + "�ӿڲ���������ִ�У�pass!");
		}else{
			UserSetPreferCommonResponse userSetPreferCommonResponse = GsonUtil.parseJsonWithGson(strResponse, 
					UserSetPreferCommonResponse.class);
			
			logger.info(strCaseName + "����������ִ�У�fail!" + "����ԭ��"+
					userSetPreferCommonResponse.getData().getDesc());
			fail("������Ϊ-1");
		}
	}


	private static String makeGetContent(String usertoken2, String token2, String property) {
		// TODO Auto-generated method stub
		return null;
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


	/**
	 * @Description TODO
	 * @return_type void
	 * @param 
	 * @author Eason
	 * @date 2017��6��15�� ����5:43:58  
	 */
	@Test
	public void testAdd() { String strURL = HttpRequest.makeURL(getUserSetHost(),UserSetTest.Prop.getProperty("preferAddPath"));
		String strContent = UserSetTest.makeContent(getUsertoken(), getToken(), Prop.getProperty("pool"), Prop.getProperty("prefer")); 
		String  strResponse = HttpRequest.sendGet(strURL, strContent);
		logger.info("��������"+strURL+"?"+strContent);
		
		logInfo(logger, "ƫ�����ýӿ�", strResponse);
	}
	
	@Test
	public void testGet(){
		String strURL = HttpRequest.makeURL(getUserSetHost(),UserSetTest.Prop.getProperty("preferGetPath"));
		String strContent = UserSetTest.makeGetContent(getUsertoken(), getToken(), Prop.getProperty("pool"));
		String strResponse = HttpRequest.sendGet(strURL, strContent);	
	}


}
