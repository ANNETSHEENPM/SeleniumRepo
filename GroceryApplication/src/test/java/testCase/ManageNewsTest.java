package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.LoginPage;
import elementRepository.ManageNewsPage;

public class ManageNewsTest extends BaseClass {
	
	LoginPage lp;
	AdminPage ap;
	ManageNewsPage mn;

	@Test(priority=1,groups="smoke")
	public void verifyAlertWhenANewsIsCreated() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		//ap=new AdminPage(driver);
		//mn=new ManageNewsPage(driver);
		mn=ap.clickOnManageNewsTab();
		mn.createNewMessage();
		String actual=mn.getAlertString();
		/*String expected = "×"+ "\n"+ "Alert!"+ "\n"+ "News Created Successfully";         
		Assert.assertEquals(actual, expected, Constant.alertVerification);*/
		String expected = "News Created Successfully";   
		boolean actual2 =actual.contains(expected);
		Assert.assertEquals(actual2, true, Constant.alertVerification);
	}
	
	@Test(priority=2)
	public void verifyAlertWhenANewsIsUpdated() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		mn=ap.clickOnManageNewsTab();
		mn.updateMessage();
		String actual1=mn.getUpdateAlertString();
		String expected1 = "News Updated Successfully";
		boolean actual2 =actual1.contains(expected1);
		Assert.assertEquals(actual2, true, Constant.alertVerification);
		/*String expected1 = "×"+ "\n"+ "Alert!"+ "\n"+ "News Updated Successfully";                  
		Assert.assertEquals(actual1, expected1, Constant.alertVerification);*/
		
	}
	
	@Test(priority=3)
	public void verifySearchedNewsIsDisplayed() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		mn=ap.clickOnManageNewsTab();
		mn.searchMessage();
	}
		
	@Test(priority=4)
	public void verifyAlertWhenNewsCreatedIsDeleted() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		ap=lp.Login(grocerydata(1,0),grocerydata(1,1));
		mn=ap.clickOnManageNewsTab();
		mn.deleteMessage();
		String actual3=mn.getDeleteAlertString();
		String expected3 = "News Deleted Successfully";
		boolean actual2 =actual3.contains(expected3);
		Assert.assertEquals(actual2, true, Constant.alertVerification);
		/*String expected3 = "×"+ "\n"+ "Alert!"+ "\n"+ "News Deleted Successfully";                  
		Assert.assertEquals(actual3, expected3, Constant.alertVerification);*/
		
	}
}
