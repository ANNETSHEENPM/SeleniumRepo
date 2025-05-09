package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.LoginPage;
import elementRepository.ManageCategoryPage;

public class ManageCategoryTest extends BaseClass {
	LoginPage lp;
	AdminPage ap;
	ManageCategoryPage mc;

	@Test(priority = 1, groups="smoke")
	public void verifyAlertWhenNewCategoryIsCreated() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.Login(grocerydata(1,0),grocerydata(1,1));
		mc = ap.clickOnManageCategoryTab();
		mc.createNewCategory();
		String ac = mc.getCategoryAlertString();
		String ex = "×" + "\n" + "Alert!" + "\n" + "Category Created Successfully";
		Assert.assertEquals(ac, ex, Constant.mc_verifyNewCategoryIsCreated);
	} 

	@Test(priority = 2)
	public void verifyAlertWhenUpdateOfCategoryCreated() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.Login(grocerydata(1,0),grocerydata(1,1));
		mc = ap.clickOnManageCategoryTab();
		mc.updateNewCategory();
		String act = mc.getupdateCategoryAlertString();
		String expect = "×" + "\n" + "Alert!" + "\n" + "Category Updated Successfully";
		Assert.assertEquals(act, expect, Constant.alertVerification);
	}
	
	@Test(priority = 3)
	public void verifyUpdatedCategoryStatus() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.Login(grocerydata(1,0),grocerydata(1,1));
		mc = ap.clickOnManageCategoryTab();
		mc.statusUpdatedCategory();
	}

	@Test(priority = 4)
	public void verifyAlertWhenUpdatedCategoryIsDeleted() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		// ap=new AdminPage(driver);
		// mn=new ManageNewsPage(driver);
		ap = lp.Login(grocerydata(1,0),grocerydata(1,1));
		mc = ap.clickOnManageCategoryTab();
		mc.deleteNewCategory();
		String actu = mc.getDeleteCategoryAlertString();
		String expecte = "×" + "\n" + "Alert!" + "\n" + "Category Deleted Successfully";
		Assert.assertEquals(actu, expecte, Constant.alertVerification);
	}
	
	@Test(priority = 5)
	public void verifyUrlIsChangedAfterReset() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		ap = lp.Login(grocerydata(1,0),grocerydata(1,1));
		mc = ap.clickOnManageCategoryTab();
		mc.searchCategory();
		String urlactual = driver.getCurrentUrl();
		mc.resetButton.click();
		String urlexpected = driver.getCurrentUrl();
		boolean actual2 =urlactual.contains(urlexpected);
		Assert.assertEquals(actual2, false, Constant.mc_verifyUrlIsChangedAfterReset );
	}
}
