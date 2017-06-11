/**
 * 
 */
package blackHorse;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.Theories;

import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import fileOperator.ExcelOperator;

/**
 * @author Administrator
 *
 */
public class UserSetTest {
	private ExcelOperator excelOperator = null;
	private ArrayList<String> paramArrayList;
	private static Logger logger = Logger.getLogger(UserSetTest.class);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

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
		this.excelOperator = new ExcelOperator(".\\dat\\test case.xlsx");
		this.paramArrayList.addAll(excelOperator.getParam("parameters", "prefer"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		while (!paramArrayList.isEmpty()) {
			
		}
	}

}
