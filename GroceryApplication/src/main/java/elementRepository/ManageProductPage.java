package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FakerUtility;
import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class ManageProductPage {
	WebDriver driver;
	FakerUtility fu = new FakerUtility();
	WaitUtilities wu = new WaitUtilities();
	GeneralUtility gu = new GeneralUtility();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']//i[@class='fas fa-edit']")
	WebElement newProduct;
	@FindBy(xpath="//div[@class='col-sm-12 form-group']//input[@class='form-control']")
	WebElement title;
	@FindBy(xpath="//input[@value='Veg']")
	WebElement productType;
	@FindBy(xpath="//input[@placeholder='Enter the Tag']")
	WebElement tag;
	@FindBy(xpath="//select[@id='grp_id']")
	WebElement group;
	@FindBy(xpath="//input[@value='weight']")
	WebElement priceType;
	@FindBy(xpath="//select[@id='p_minimum']")
	WebElement minPiece;
	@FindBy(xpath="//input[@id='m_weight']")
	WebElement weightValue;
	@FindBy(xpath="//select[@id='w_unit']")
	WebElement weightUnit;
	@FindBy(xpath="//input[@id='max_weight']")
	WebElement maxWeight;
	@FindBy(xpath="//input[@id='w_price']")
	WebElement price;
	@FindBy(xpath="//input[@id='w_mrp']")
	WebElement mrp;
	@FindBy(xpath="//input[@id='w_stock']")
	WebElement stock;
	@FindBy(xpath="//input[@id='w_pp']")
	WebElement purchasePrice;
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement description;
	@FindBy(xpath="//div[@class='col-sm-6 form-group']//label[2]//input[@name='stock']")
	WebElement stockCheck;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement imageUpload;
	@FindBy(xpath="//label[2]//input[@name='featured']")
	WebElement featured;
	@FindBy(xpath="//label[2]//input[@name='combo']")
	WebElement comboPack;
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement createNewProductAlert;
		
	public void createNewProduct() {
		newProduct.click();
		title.sendKeys("Test Product");
		productType.click();
		tag.sendKeys("Test tag");
		Select object1 = new Select(group); 
	    object1.selectByIndex(1);
	 /* Select object2 = new Select(minPiece); 
	    object2.selectByVisibleText("10 Piece");*/
	    weightValue.sendKeys("1000");
	    Select object3 = new Select(weightUnit); 
	    object3.selectByValue("g");  
	    maxWeight.sendKeys("10000");
	    price.sendKeys("100");
	    mrp.sendKeys("100");
	    stock.sendKeys("100");
	    purchasePrice.sendKeys("150");
	    description.sendKeys("Test Create Product");
	   /* stockCheck.click();*/
		imageUpload.sendKeys("C:\\Users\\annet\\OneDrive\\Documents\\Obsqura_Zone\\Files\\FoodProductImage.png");
		//featured.click();
		gu.pageScroll(0, 5000, driver);
		wu.waitForElementToBeClickable(driver, save, 10);
		gu.clickJavaScriptExecutor(save, driver);
		//save.click();
	}	
	
	public String getNewProductAlertString() {
		return createNewProductAlert.getText();
	}
}
