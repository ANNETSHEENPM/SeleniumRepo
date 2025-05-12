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


public class ManageCategoryPage {

	WebDriver driver;
	FakerUtility fu = new FakerUtility();
	WaitUtilities wu = new WaitUtilities();
	GeneralUtility gu = new GeneralUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']//i[@class='fas fa-edit']")
	WebElement newCategory;
	@FindBy(xpath = "//input[@id='category']")
	WebElement category;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement sourceElement;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//label[2]//input[@name='top_menu']")
	WebElement topmenu;
	@FindBy(xpath = "//label[2]//input[@name='top_menu']")
	WebElement showhome;
	//@FindBy(xpath = "//button[text()='Save']")
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveCategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement createNewCategoryAlert;
	@FindBy(xpath = "//span[@class='fas fa-trash-alt']")
	WebElement trash;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updateCategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateNewCategoryAlert;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteNewCategoryAlert;
	@FindBy(xpath = "//div[@class='card-footer clearfix']//nav//ul//li[5]//a[@class='page-link']")
	WebElement pageNo;
	@FindBy(xpath = "//i[@class=' fa fa-search']")
	WebElement search;
	@FindBy(xpath = "//input[@placeholder='Category']")
	WebElement inputCategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButton;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	public WebElement resetButton;

	public void createNewCategory() {
		newCategory.click();
		category.sendKeys("Test New Category");
		sourceElement.click();
		chooseFile.sendKeys("C:\\Users\\annet\\OneDrive\\Documents\\Obsqura_Zone\\Files\\FoodProductImage.png");
		//topmenu.click();
		//showhome.click();
		gu.pageScroll(0, 1000, driver);
		wu.waitForElementToBeClickable(driver, saveCategory, 10);
		gu.clickJavaScriptExecutor(saveCategory, driver);
		//saveCategory.click();
	}

	public String getCategoryAlertString() {
		wu.waitForElementToBeClickable(driver, createNewCategoryAlert, 10);
		return createNewCategoryAlert.getText();
	}

	public void updateNewCategory() {
		List<WebElement> tableName = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		String message = "Test New Category";
		for (int i = 0; i < tableName.size(); i++) {
			if (tableName.get(i).getText().equals(message)) {
				String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\"+(i+1)+\"]//td[4]//a//i[@class='fas fa-edit']";
				WebElement element = driver.findElement(By.xpath(locator));
				element.click();
				break;
			}
		}
		category.clear();
		category.sendKeys("Test New Category Update");
		trash.click();
		driver.switchTo().alert().accept();
		gu.pageScroll(0, 1000, driver);
		wu.waitForElementToBeClickable(driver, updateCategory, 25);
		gu.clickJavaScriptExecutor(updateCategory, driver);
		//updateCategory.click();
	}

	public String getupdateCategoryAlertString() {
		return updateNewCategoryAlert.getText();
	}

	public void statusUpdatedCategory() {
		List<WebElement> tableName = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		String message2 = "Test New Category";
		for (int i = 0; i < tableName.size(); i++) {
			if (tableName.get(i).getText().equals(message2)) {
				String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\"+(i+1)+\"]//td[3]//a//span";
				WebElement element = driver.findElement(By.xpath(locator));
				System.out.println(element.getText());
				break;
			}
		}
	}
	
	public void deleteNewCategory() {
		List<WebElement> tableName = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		String message2 = "Test New Category";
		for (int i = 0; i < tableName.size(); i++) {
			if (tableName.get(i).getText().equals(message2)) {
				String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\"+(i+1)+\"]//td[4]//a//i[@class='fas fa-trash-alt']";
				WebElement element = driver.findElement(By.xpath(locator));
				element.click();
				driver.switchTo().alert().accept();
				break;
			}
		}
	}

	public String getDeleteCategoryAlertString() {
		return deleteNewCategoryAlert.getText();
	}
	
	public void searchCategory() {
		//pageNo.click();	
		search.click();
		inputCategory.sendKeys("Rudolph");
		searchButton.click();
		List<WebElement> tableName = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[1]"));
		String msg= "Rudolph";
		for(int i=0; i<tableName.size();i++) {
			if(tableName.get(i).getText().equals(msg)) {
				System.out.println("The category is present");
				break;
			}
		}
		String urlactual = driver.getCurrentUrl();
		gu.clickJavaScriptExecutor(resetButton, driver);
		//resetButton.click();
	}	
}
