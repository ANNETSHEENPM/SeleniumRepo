package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ExcelUtility;
import utilities.ScreenShotCapture;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	
	public static Properties pro;
	public static void testBasic() throws IOException {
		pro = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		pro.load(fp);
	}
	
	public static String grocerydata(int row, int column) throws IOException, InvalidFormatException {
		String data = ExcelUtility.readDataFromExcelParcelRowColumn(row, column, "\\src\\test\\resources\\Excel\\LoginCredentials.xlsx",
				"Sheet1");
		return data;
	}
	
	public static String footertextdata(int row, int column) throws IOException, InvalidFormatException {
		String data = ExcelUtility.readDataFromExcelParcelRowColumn(row, column, "\\src\\test\\resources\\Excel\\LoginCredentials.xlsx",
				"Sheet2");
		return data;
	}
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void beforeMethod(String browserName) throws IOException {
		testBasic();
		if(browserName.equals("Chrome")) {
			driver = new ChromeDriver();	
		}
		else if(browserName.equals("Firefox")) {
		driver = new FirefoxDriver();	
		}
		driver.get(pro.getProperty("baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod (ITestResult iTestResult)throws IOException{
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
			}
		//driver.quit();
	}
}

