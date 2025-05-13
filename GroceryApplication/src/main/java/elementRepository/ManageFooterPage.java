package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	WebDriver driver;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement addressField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNoField;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement footerUpdate;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateFooterTextAlert;
	
	
	public ManageFooterPage FooterText(String address, String email,String phoneNo ) {	
		List<WebElement> tableName = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]"));
		for(int i=0; i<tableName.size();i++) {
				String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[4]//a//i[@class='fas fa-edit']";
				WebElement element = driver.findElement(By.xpath(locator));
				element.click();
				break;
			}
		addressField.clear();
		addressField.sendKeys(address);
		emailField.clear();
		emailField.sendKeys(email);
		phoneNoField.clear();
		phoneNoField.sendKeys(phoneNo);
		footerUpdate.click();
		return new ManageFooterPage(driver); 		 
	}
	
	public String getFooterTextAlertString() {
		return updateFooterTextAlert.getText();
	}
}
