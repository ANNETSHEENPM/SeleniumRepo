package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtility {

	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	// Select dropdown option by index (0-based)
	public void selectDropdownByIndex(WebElement element, int index) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	// Select dropdown option by visible text
	public void selectDropdownByVisibleText(WebElement element, String visibleText) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(visibleText);
	}

	// Select dropdown option by value attribute
	public void selectDropdownByValue(WebElement element, String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	// Get selected option's visible text
	public String getSelectedOption(WebElement element) {
		Select dropdown = new Select(element);
		return dropdown.getFirstSelectedOption().getText();
	}
	// Get all dropdown options as a list of Strings

	public List<String> getAllDropdownOptions(WebElement element) {
		Select dropdown = new Select(element);
		List<WebElement> options = dropdown.getOptions();
		List<String> values = new ArrayList<>();
		for (WebElement option : options) {
			values.add(option.getText().trim());
		}
		return values;
	}

	// Check if dropdown is multi-select
	public boolean isMultiple(WebElement element) {
		Select dropdown = new Select(element);
		return dropdown.isMultiple();
	}

	// Deselect all (only works if multi-select)
	public void deselectAll(WebElement element) {
		Select dropdown = new Select(element);
		if (dropdown.isMultiple()) {
			dropdown.deselectAll();
		}
	}

	// ===== Checkbox Utility =====
	// Check a checkbox if it's not already selected
	public void checkCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected())
			checkbox.click();
	}

	// Uncheck a checkbox if it's selected
	public void uncheckCheckbox(WebElement checkbox) {
		if (checkbox.isSelected())
			checkbox.click();
	}

	// Toggle a checkbox (regardless of state)
	public void toggleCheckbox(WebElement checkbox) {
		checkbox.click();
	}

	// Check if a checkbox is selected
	public boolean isCheckboxSelected(WebElement checkbox) {
		return checkbox.isSelected();
	}
	// Check all checkboxes in a list

	public void checkAllCheckboxes(List<WebElement> checkboxes) {
		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}

	// Uncheck all checkboxes in a list
	public void uncheckAllCheckboxes(List<WebElement> checkboxes) {
		for (WebElement checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}

	// ===== Radio Utility =====
	// radio button isSelected
	public boolean isRadioButtonSelected(WebElement element) {
		return element.isSelected();
	}

	// radio button isDisplayed
	public boolean isRadioButtonDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// radio button isEnabled
	public boolean isRadioButtonEnabled(WebElement element) {
		return element.isEnabled();
	}

	// return true or false if any radio button from a group is selected
	public boolean isAnyRadioButtonSelected(List<WebElement> element) {
		for (WebElement radio : element) {
			if (radio.isSelected()) {
				return true;
			}
		}
		return false;
	}

	// Returns the selected radio button WebElement from a group, or null if none is
	// selected
	public WebElement getSelectedRadioButton(List<WebElement> element) {
		for (WebElement radio : element) {
			if (radio.isSelected()) {
				return radio;
			}
		}
		return null; // None selected
	}

	// ===== Mouse Actions =====
	// Mouse hover
	public void hoverOverElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// Right-click on an element (context click)
	public void rightClickElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// Double-click on an element
	public void doubleClickElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// Drag and drop from source to target element
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	// ===== Keyboard Actions =====
	// Send a key (or string) to an element
	public void sendKeysToElement(WebDriver driver, WebElement element, String text) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().sendKeys(text).perform();
	}

	// ===== Alert Handling Utilities =====
	// Accept a simple alert (equivalent to clicking "OK")
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// Dismiss an alert (equivalent to clicking "Cancel")
	public void dismissAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// Get the text of an alert
	public String getAlertText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	// Send text to a prompt alert
	public void sendTextToAlert(WebDriver driver, String inputText) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(inputText);
		alert.accept();
	}

	// ===== Frame Utilities =====
	// Switch to a frame by index (e.g., driver.switchTo().frame(0))
	public void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	// Switch to a frame by name or ID attribute
	public void switchToFrameByNameOrId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// Switch to a frame by WebElement reference
	public void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Switch back to the main document (default content)
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// Switch to the parent frame (one level up)
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	// ===== File Upload Utility =====
	// Upload a file by sending the file path to the input element
	public void uploadFile(WebElement fileInputElement, String filePath) {
		fileInputElement.sendKeys(filePath);
	}

	// ======Dynamic Table Utility=======
	// Get total row count (excluding header)
	public int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
		return rows.size();
	}

	// Get total column count (based on the first row)
	public int getColumnCount(WebElement table) {
		List<WebElement> columns = table.findElements(By.xpath(".//thead/tr/th"));
		return columns.size();
	}

	// Get cell value by row and column index (1-based)
	public String getCellData(WebElement table, int rowIndex, int colIndex) {
		WebElement cell = table.findElement(By.xpath(".//tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"));
		return cell.getText().trim();
	}
	
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	
	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
	
	public String generateCurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");	
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}
	
	public void pageScroll(int horizontal, int vertical, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")", "");
	}
	
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
}
