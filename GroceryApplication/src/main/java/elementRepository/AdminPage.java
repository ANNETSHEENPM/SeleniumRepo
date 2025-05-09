package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;

public class AdminPage {
	
	GeneralUtility gu = new GeneralUtility();
	WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboardText;
	@FindBy(xpath="//a//p[text()='Manage News']")
	WebElement  manageNewsTab;
	@FindBy(xpath="//a//p[text()='Manage Product']")
	WebElement  manageProductTab;
	@FindBy(xpath="//a//p[text()='Manage Category']")
	WebElement  manageCategoryTab;
	@FindBy(xpath="//a//p[text()='Manage Contact']")
	WebElement  manageContactTab;
	@FindBy(xpath="//a//i[@class='nav-icon fas fa-users']")
	WebElement  manageAdminUsersTab;
	@FindBy(xpath = "//a//p[text()='Manage Users']")
	WebElement manageUsers;
	@FindBy(xpath = "//li[@class='nav-item has-treeview ']//a//p")
	WebElement settings;
	@FindBy(xpath = "//p[text()='Manage Menu']")
	WebElement manageMenu;
	@FindBy(xpath = "//p[text()='Manage Footer Text']")
	WebElement manageFooterText;

	public String getDashboardString() {
		return dashboardText.getText();
	}
	
	public ManageNewsPage clickOnManageNewsTab() {
		manageNewsTab.click();
		return new ManageNewsPage(driver);
	}
	
	public ManageProductPage clickOnManageProductTab() {
		manageProductTab.click();
		return new ManageProductPage(driver);
	}
	
	public ManageCategoryPage clickOnManageCategoryTab() {
		manageCategoryTab.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageContactPage clickOnManageContactTab() {
		manageContactTab.click();
		return new ManageContactPage(driver);
	}
	
	public AdminUsersPage clickOnAdminUsersTab() {
		manageAdminUsersTab.click();
		return new AdminUsersPage(driver);
	}
	
	public AdminUsersPage clickOnManageUsersTab() {
		manageUsers.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageMenuPage clickOnSettingsTab() {
		settings.click();
		return new ManageMenuPage(driver);
	}
	
	public ManageMenuPage clickOnManageMenuTab() {
		manageMenu.click();
		return new ManageMenuPage(driver);
	}
	
	public ManageFooterPage clickOnManageFooterTextTab() {
		manageFooterText.click();
		return new ManageFooterPage(driver);
	}
}
