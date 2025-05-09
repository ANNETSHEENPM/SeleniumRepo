package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public void waitElements(WebDriver driver, WebElement element, String attribute, String attributeValue, int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public void waitForAlert(WebDriver driver) {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait2.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait3.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean waitForTextInElement(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait4.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
}
