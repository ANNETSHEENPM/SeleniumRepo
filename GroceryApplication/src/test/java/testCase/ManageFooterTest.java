package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.LoginPage;
import elementRepository.ManageFooterPage;

public class ManageFooterTest extends BaseClass{
	
	LoginPage lp;
	AdminPage ap;
	ManageFooterPage mf;
	
  @Test(groups="smoke")
  public void verifyAlertWhenUpdatedFooTerTextDetails() throws InvalidFormatException, IOException {
	    lp=new LoginPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		mf=ap.clickOnManageFooterTextTab();
		mf.FooterText(footertextdata(1,0),footertextdata(1,1),footertextdata(1,2));
		String actual=mf.getFooterTextAlertString();
		String expected = "Footer Text Updated Successfully";         
		boolean actual2 =actual.contains(expected);
		Assert.assertEquals(actual2, true, Constant.alertVerification);
		
  }
}
