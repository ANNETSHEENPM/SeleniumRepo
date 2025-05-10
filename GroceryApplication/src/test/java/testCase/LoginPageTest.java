package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	AdminPage ap;

	@Test(groups="smoke")
	public void verifyDashboardTextWhileLoginWithValidCredential() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		//ap=new AdminPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		String actual=ap.getDashboardString();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, Constant.lp_verifyDashboardTextWhileLoginWithValidCredential);
	}
	
	@DataProvider(name = "invalid credentials")
	 public Object[][] dpMethod() {
		return new Object[][] {{"Admin","Admin"}, {"admin","Admin"},{"Admin","AdMiN"}};
	  }
	
	@Test(dataProvider = "invalid credentials")
	public void verifyErrorMessageWhileLoginWithInValidCredential(String userName, String password) {
		lp=new LoginPage(driver);
		lp.Login(userName, password);
		String actual=lp.getErrorMessage();
		String expected = "Invalid Username/Password";
		boolean actual2 =actual.contains(expected);
		Assert.assertEquals(actual2, true, Constant.lp_verifyErrorMessageWhileLoginWithInValidCredential);
		//Assert.assertEquals(actual, expected, "::Error message not as expected");
	}
}
