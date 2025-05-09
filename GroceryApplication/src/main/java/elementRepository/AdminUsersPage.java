package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']//i[@class='fas fa-edit']")
	WebElement newUserButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userType;
	@FindBy(xpath = "//button[@name='Create']//i[@class='fa fa-save']")
	WebElement saveUser;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement createNewUserAlert;
	@FindBy(xpath = "//div[@class='action-buttons']//a//i")
	WebElement passwordDetails;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement createNewUserLockAlert;

	public void createNewUser() {
		newUserButton.click();
		userName.sendKeys("TestNewUser");
		password.sendKeys("Test");
		Select object4 = new Select(userType);
		object4.selectByVisibleText("Admin");
		saveUser.click();
	}

	public String getNewUserAlertString() {
		return createNewUserAlert.getText();
	}

	public void verifyNewUser() {
		List<WebElement> table1 = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td"));
		for (int i = 0; i < table1.size(); i++) {
			if (table1.get(i).getText().equals("TestNewUser")) {
				System.out.print(table1.get(i).getText()+" ");
				WebElement status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]//a//span"));
				System.out.println(status.getText());
			}
		}
		passwordDetails.click();
		List<WebElement> password = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[@class='detail-row open']//span"));
		for (int i = 0; i < password.size(); i++) {
			if (password.get(i).getText().equals("Test")) {
				System.out.print("Password is correct"+" ");
			}
		}
	}
	
	public void lockNewUser() {
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td"));
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getText().equals("TestNewUser")) {
				WebElement statusAction = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]//i[@class='fa fa-unlock']"));
				statusAction.click();
				WebElement status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]//a//span"));
				System.out.println(status.getText());
			}
		}
	}
	
	public String getNewUserLockAlertString() {
		return createNewUserLockAlert.getText();
	}
}	

