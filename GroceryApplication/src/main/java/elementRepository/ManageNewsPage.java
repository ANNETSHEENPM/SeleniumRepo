package elementRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']//i[@class='fas fa-edit']")
	WebElement newButton;
	@FindBy(id="news")
	WebElement news;
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	@FindBy(xpath="//button[text()='Update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement createNewAlert;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement createUpdateAlert;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement reset;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement newsSearch;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement clickSearch;
	
	
	public void createNewMessage() {
		newButton.click();
		news.sendKeys("Create News message");
		save.click();	
	}
	
	public String getAlertString() {
		return createNewAlert.getText();
	}
	
	public void updateMessage() {
		List<WebElement> tableName = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		String message= "Create News message";
		for(int i=0; i<tableName.size();i++) {
			if(tableName.get(i).getText().equals(message)) {
				String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(i+1)+"]//td[2]//a//i[@class='fas fa-edit']";
				WebElement element = driver.findElement(By.xpath(locator));
				element.click();
				break;
			}
		}
		news.clear();
		news.sendKeys("Test the News message update");
		update.click();
		}
	
	public String getUpdateAlertString() {
		return createUpdateAlert.getText();
	}
	
	public void searchMessage() {
		reset.click();
		search.click();
		newsSearch.sendKeys("Test the News message update");
		clickSearch.click();
		List<WebElement> tableName = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		String message1= "Test the News message update";
		for(int i=0; i<tableName.size();i++) {
			if(tableName.get(i).getText().equals(message1)) {
				System.out.println("The updated message is present");
				break;
			}
		}
	}
	
	public void deleteMessage() {
		List<WebElement> tableName = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		String message1= "Test the News message update";
		for(int i=0; i<tableName.size();i++) {
			if(tableName.get(i).getText().equals(message1)) {
				String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(i+1)+"]//td[2]//a//i[@class='fas fa-trash-alt']";
				WebElement element = driver.findElement(By.xpath(locator));
				element.click();
				driver.switchTo().alert().accept();
				break;
			}
		}
		}
	
	public String getDeleteAlertString() {
		return deleteAlert.getText();
	}
}
