/**
 * 
 */
package blackHorse;

import static org.junit.Assert.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.imageio.plugins.wbmp.WBMPImageReader;

import fileOperator.ExcelOperator;

/**
 * @author Administrator
 *
 */
public class UserSetTest {
	static ExcelOperator excelOperator = null;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		excelOperator = new ExcelOperator(".\\dat\\test case.xlsx");
		
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
