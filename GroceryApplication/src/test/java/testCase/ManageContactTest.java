package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.LoginPage;
import elementRepository.ManageContactPage;

public class ManageContactTest extends BaseClass {

	LoginPage lp;
	AdminPage ap;
	ManageContactPage mp;

	@Test(groups="smoke")
	public void verifyAlertWhenContactIsUpdated() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		mp=ap.clickOnManageContactTab();
		mp.contactUsDetails();
		mp.updateContactUs();
		String actual=mp.getUpdateContactAlertString();
		String expected = "Contact Updated Successfully";         
		boolean actual2 =actual.contains(expected);
		Assert.assertEquals(actual2, true, Constant.alertVerification);
	/*	String expected = "×"+ "\n"+ "Alert!"+ "\n"+ "Contact Updated Successfully";                  
		Assert.assertEquals(actual, expected, Constant.alertVerification);*/
	}
}
