package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class ManageContactPage {
	WebDriver driver;
	FakerUtility fu = new FakerUtility();
	WaitUtilities wu = new WaitUtilities();
	GeneralUtility gu = new GeneralUtility();

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateContactAlert;

	public void contactUsDetails() {
		List<WebElement> tableHead = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//thead//tr//th"));
		for (int i = 0; i < tableHead.size(); i++) {
			System.out.print(tableHead.get(i).getText() + " ");
		}
		System.out.println();
		List<WebElement> tableRow1 = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td"));
		for (int i = 0; i < tableRow1.size(); i++) {
			System.out.print(tableRow1.get(i).getText() + " ");
		}
		System.out.println();
	}

	public void updateContactUs() {
		List<WebElement> tableName = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		for (int i = 0; i < tableName.size(); i++) {
				String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[6]//a//i[@class='fas fa-edit']";
				WebElement element1 = driver.findElement(By.xpath(locator));
				element1.click();
				break;
			}
		phone.clear();
		phone.sendKeys(fu.generateRandomDigits(10));
		gu.pageScroll(0, 500, driver);
		wu.waitForElementToBeClickable(driver, phone, 65);
		gu.clickJavaScriptExecutor(update, driver);
		//update.click();
	}

	public String getUpdateContactAlertString() {
		return updateContactAlert.getText();
	}
}
