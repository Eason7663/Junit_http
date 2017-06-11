package blackHorse;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.xml.internal.ws.api.message.saaj.SaajStaxWriter;

import blackHorseUtil.UserToken;
import fileOperator.FileUtils;
import fileOperator.GsonUtil;

public class RecommendTest {
	
	private static Logger logger = Logger.getLogger(RecommendTest.class); 
	
	private static String userName;
	private String userToken;
	private static String recommendHost;
	private static String recommendPath;
	private static String recommendURL;
	
	private String requestContent;
	private static String pool;
	private static String token;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties properties =  new Properties();
		properties.load(new FileInputStream(new File("dat\\recommend.properties")));
		userName = properties.getProperty("userName");
		recommendHost = properties.getProperty("host");
		recommendPath = properties.getProperty("path");
		pool = properties.getProperty("pool");
		token = properties.getProperty("token");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	public String getUserName() {
		return userName;
	}
	public String getUserToken() {
		return userToken;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getRecommendHost() {
		return recommendHost;
	}

	public void setRecommendHost(String recommendHost) {
		this.recommendHost = recommendHost;
	}

	public String getRecommendPath() {
		return recommendPath;
	}

	public void setRecommendPath(String recommendPath) {
		this.recommendPath = recommendPath;
	}
	
	public String getRecommendURL() {
		return recommendURL;
	}

	public void setRecommendURL(String recommendURL) {
		this.recommendURL = recommendURL;
	}

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public String makeURL() {
		StringBuilder strURL = new StringBuilder();
		strURL.append(recommendHost);
		strURL.append(recommendPath);
		return strURL.toString();
	}
	
	public String makeContent() {
		StringBuilder strContent = new StringBuilder();
		strContent.append("usertoken=");
		strContent.append(getUserToken());
		strContent.append("&pool=");
		strContent.append(getPool());
		strContent.append("&token=");
		strContent.append(getToken());		
		return strContent.toString();
	}

	@Before
	public void setUp() throws Exception {
//		setUserToken(UserToken.getUserToken(getUserName()));
//		setRecommendURL(makeURL());
//		setRequestContent(makeContent());
	}

	@Test
	public void recommendBaseTest() {
//		String strResponse = HttpRequest.sendGet(getRecommendURL(),getRequestContent());
		String strResponse;
		try {
			strResponse = FileUtils.readFile("dat\\result.txt");
			BlackHorseRecommendResponse blackHorseRecommendResponse = 
					GsonUtil.parseJsonWithGson(strResponse, BlackHorseRecommendResponse.class);
			if (blackHorseRecommendResponse == null) {
				logger.error("json初始化失败！");
			}
			assertSame("查询失败", 0, blackHorseRecommendResponse.getErr());
			logger.info("recommend查询接口测试用例执行，pass！");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
