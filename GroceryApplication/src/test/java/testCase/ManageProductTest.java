package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ManageProductTest extends BaseClass {
	
	LoginPage lp;
	AdminPage ap;
	ManageProductPage mp;

  @Test(groups="smoke")
  public void verifyAlertWhenANewProductIsCreated() throws InvalidFormatException, IOException {
	    lp=new LoginPage(driver);
	    ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
	    mp=ap.clickOnManageProductTab();
		mp.createNewProduct();
		String actual=mp.getNewProductAlertString();
		String expected = "The Category field is required.";         
		boolean actual2 =actual.contains(expected);
		Assert.assertEquals(actual2, true, Constant.alertVerification);
  }
}
