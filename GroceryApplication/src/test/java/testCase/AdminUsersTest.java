package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;

public class AdminUsersTest extends BaseClass {
	
	LoginPage lp;
	AdminPage ap;
	AdminUsersPage au;

  @Test(groups="smoke")
  public void verifyAlerWhenNewAdminUserIsCreated() throws InvalidFormatException, IOException {
	    lp=new LoginPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		au=ap.clickOnAdminUsersTab();
		au=ap.clickOnManageUsersTab();
		au.createNewUser();
		String actual=au.getNewUserAlertString();
		String expected = "User Created Successfully";
		boolean actual2 =actual.contains(expected);
		Assert.assertEquals(actual2, true, Constant.alertVerification);	
		/*String expected = "×"+ "\n"+ "Alert!"+ "\n"+ "User Created Successfully";         
		Assert.assertEquals(actual, expected, "::Alert text not as expected");*/
  }
  
  @Test
  public void verifyAlerWhenNewAdminUserIsLocked() throws InvalidFormatException, IOException {
	  lp=new LoginPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		au=ap.clickOnAdminUsersTab();
		au=ap.clickOnManageUsersTab();
		au.verifyNewUser();
		au.lockNewUser();
		String act=au.getNewUserLockAlertString();
		String exp = "User Status Changed Successfully";
		boolean actu =act.contains(exp);
		Assert.assertEquals(actu, true, Constant.alertVerification);
		/*System.out.println(act);
		String exp = "×"+ "\n"+ "Alert!"+ "\n"+ "User Status Changed Successfully"; 
		System.out.println(exp);
		Assert.assertEquals(act, exp, Constant.alertVerification);*/
  }
}
