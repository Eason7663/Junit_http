/**
 * 
 */
package blackHorse;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.Theories;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.sun.org.apache.bcel.internal.generic.NEW;

import blackHorse.RecommendResponse.Data.RepDataBlackHorseRecommend.Strategy;
import blackHorse.RecommendResponse.Data.RepDataBlackHorseRecommend.Strategy.StockInfo;
import blackHorseUtil.UserToken;
import fileOperator.ExcelOperator;
import fileOperator.GsonUtil;
import net.sf.json.JSONObject;
import requestUtils.HttpRequest;

/**
 * @Description TODO
 * @author Eason
 * 
 */
/**
 * @Description TODO
 * @author Eason
 * 
 */
public class UserSetTest {
	private static Logger logger = Logger.getLogger(UserSetTest.class);
	private static Properties prop = new Properties();
	
	private UserSetRequsetURL userSetRequsetURL;
	

	/**
	 * @Description TODO
	 * @param logger
	 * @param strCaseName
	 * @param strResponse
	 * @return_type void
	 * @author Eason
	 * @date 2017年6月19日 上午9:18:23  
	 */
	public void logInfo(Logger logger, String strCaseName, String strResponse) {
		if (JSONObject.fromObject(strResponse).get("Err").equals(0)) {
			assertEquals("返回码不等于0", 0, JSONObject.fromObject(strResponse).get("Err"));
//			logger.info(strResponse);
			logger.info(strCaseName + "测试用例已执行，执行结果pass!");
		}else{
			UserSetPreferCommonResponse userSetPreferCommonResponse = GsonUtil.parseJsonWithGson(strResponse, 
					UserSetPreferCommonResponse.class);
//			logger.info(strResponse);
			logger.info(strCaseName + "测试用例已执行，执行结果fail!" + " 错误描述：" +
					userSetPreferCommonResponse.getData().getDesc());
			fail("-1");
		}
	}
	
	
	public Strategy getRecommendStockCode(UserSetRequsetURL userSetRequsetURL) {
		userSetRequsetURL.setStrPath("/dzh/blackhorse/recommend");
		
		Strategy strategy = new RecommendResponse().new Data().new RepDataBlackHorseRecommend().new Strategy();
		String  strResponse = HttpRequest.sendGet(userSetRequsetURL.toString()); //
		RecommendResponse recommendResponse = GsonUtil.parseJsonWithGson(strResponse, RecommendResponse.class);
		for (Strategy iterable_element : recommendResponse.getData().getRepDataBlackHorseRecommend().get(0).getStrategy()) {
			System.out.println(iterable_element.getName());
			strategy.setName(iterable_element.getName());
			if (!iterable_element.getStockInfo().isEmpty()) {
				for (StockInfo stockInfoElement : iterable_element.getStockInfo()) {
					if (stockInfoElement.getIsFollow() == 1) {
						break;
					}else{
						List<StockInfo> list = new ArrayList<StockInfo>();
						list.add(stockInfoElement);
						strategy.setStockInfo(list);
						return strategy;
					}
				}
				
			}
		}
			
		return strategy;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		prop.load(new FileReader("dat\\userset.properties"));
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
		userSetRequsetURL = new UserSetRequsetURL(prop.getProperty("host"), 
				null, 
				prop.getProperty("token"),
				prop.getProperty("userName"),
				prop.getProperty("pool"),
				null,
				null
				);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		userSetRequsetURL.setStrPath(null);
		userSetRequsetURL.setPrefer(null);
		userSetRequsetURL.setStock(null);
	}


	/**
	 * @Description 偏好设置用例
	 * @return_type void
	 * @author Eason
	 * @date 2017年6月19日 上午9:23:48  
	 */
	@Test
	public void testPreferAdd() { 
		userSetRequsetURL.setStrPath(prop.getProperty("preferAddPath"));
		String  strResponse = HttpRequest.sendGet(userSetRequsetURL.preferUrl(prop.getProperty("preferAdd")));
		logger.info("发送请求" + userSetRequsetURL.preferUrl(prop.getProperty("preferAdd")));
		
		logInfo(logger, "偏好设置", strResponse);
	}
	
	/**
	 * @Description TODO
	 * @return_type void
	 * @author Eason
	 * @date 2017年6月19日 上午9:24:10  
	 */
	@Test
	public void testPreferGet(){
		userSetRequsetURL.setStrPath(prop.getProperty("preferGetPath"));
		String strResponse = HttpRequest.sendGet(userSetRequsetURL.toString());	
		logger.info("发送请求" + userSetRequsetURL.toString());
		
		logInfo(logger, "偏好获取", strResponse);
	}
	

	/**
	 * @Description TODO
	 * @return_type void
	 * @author Eason
	 * @date 2017年6月19日 上午9:24:41  
	 */
	@Test
	public void testPreferDelete(){
		userSetRequsetURL.setStrPath(prop.getProperty("preferDelPath"));
		String  strResponse = HttpRequest.sendGet(userSetRequsetURL.preferUrl(prop.getProperty("preferDel")));
		logger.info("发送请求" + userSetRequsetURL.preferUrl(prop.getProperty("preferDel")));
		
		logInfo(logger, "偏好删除", strResponse);
	}

	/**
	 * @Description TODO
	 * @return_type void
	 * @author Eason
	 * @date 2017年6月19日 上午9:25:13  
	 */
	@Test
	public void testStockAdd(){
		
		Strategy strategy = getRecommendStockCode(userSetRequsetURL);
//		System.out.println(result.toString());
		userSetRequsetURL.setStrPath(prop.getProperty("preferGetPath"));
		userSetRequsetURL.setPool(strategy.getName());
		userSetRequsetURL.setStock(strategy.getStockInfo().get(0).getStockCode());
		String  strResponse = HttpRequest.sendGet(userSetRequsetURL.stockUrl());
		logger.info("发送请求" + userSetRequsetURL.stockUrl());

		logInfo(logger, "股票跟踪", strResponse);
	}
	
}
