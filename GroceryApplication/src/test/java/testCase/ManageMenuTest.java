package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.LoginPage;
import elementRepository.ManageMenuPage;

public class ManageMenuTest extends BaseClass {
	
	LoginPage lp;
	AdminPage ap;
	ManageMenuPage mm;
	
  @Test(groups="smoke")
  public void verifyAlertWhenNewMenuIsCreated() throws InvalidFormatException, IOException {
	    lp=new LoginPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		mm=ap.clickOnSettingsTab();
		mm=ap.clickOnManageMenuTab();
		mm.createNewMenu();
		String actual=mm.getNewMenuAlertString();
		/*String expected = "×"+ "\n"+ "Alert!"+ "\n"+ "Menu Created Successfully";         
		Assert.assertEquals(actual, expected, Constant.alertVerification);*/
		String expected = "The Category field is required.";         
		boolean actual2 =actual.contains(expected);
		Assert.assertEquals(actual2, true, Constant.alertVerification);
  }
}
