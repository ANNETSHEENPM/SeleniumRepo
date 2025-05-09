package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FakerUtility;
import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class ManageMenuPage {
	WebDriver driver;
	FakerUtility fu = new FakerUtility();
	WaitUtilities wu = new WaitUtilities();
	GeneralUtility gu = new GeneralUtility();

	public ManageMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickNew;
	@FindBy(xpath = "//input[@id='name']")
	WebElement menuName;
	@FindBy(xpath = "//select[@id='menu_id']")
	WebElement parentMenu;
	@FindBy(xpath = "//input[@id='url']")
	WebElement url;
	@FindBy(xpath = "//input[@id='icon']")
	WebElement faIcon;
	@FindBy(xpath = "//input[@id='menu_table']")
	WebElement tableName;
	@FindBy(xpath = "//input[@id='active_file']")
	WebElement activeFiles;
	@FindBy(xpath = "//input[@id='menu_color']")
	WebElement color;
	@FindBy(xpath = "//label//input[@value='yes']")
	WebElement setHome;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement buttonSave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement createNewMenuAlert;
	
	public void createNewMenu() {
		clickNew.click();
		menuName.sendKeys("NewTestMenu");
		Select obj = new Select(parentMenu); 
	    obj.selectByVisibleText("Dashboard");
	    url.sendKeys("Testurl");
	    faIcon.sendKeys("TestfaIcon");
	    tableName.sendKeys("TestTableName");
	    activeFiles.sendKeys("file name-1,file name-2");
	    color.sendKeys("Green");
	    setHome.click();
	    gu.pageScroll(0, 1000, driver);
		wu.waitForElementToBeClickable(driver, buttonSave, 10);
	    buttonSave.click();  
	}
	public String getNewMenuAlertString() {
		return createNewMenuAlert.getText();
	}
}
