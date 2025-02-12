package utilities;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class driverutility {
	
	public WebDriver webDriver() {
		
		WebDriver driver= new ChromeDriver();	
		return driver;
	}
	
	public void launchurl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public WebElement elementLocatorbyId(WebDriver driver, String locator) {
		return driver.findElement(By.id(locator));
		
		
	}
	
	public WebElement elementLocatorbyname(WebDriver driver, String locator) {
		return driver.findElement(By.name(locator));
	}
	
	public WebElement elementLocatorbyclassname(WebDriver driver, String locator) {
		return driver.findElement(By.className(locator));
	}
	public WebElement elementLocatorbycss(WebDriver driver, String locator) {
		return driver.findElement(By.cssSelector(locator));
	}
	
	public void selectcheckbox(WebDriver driver, String locator) {
		elementLocatorbyId(driver,locator).click();
		
		
	}
	
	public void selectdropdwon(WebDriver driver, String locator) {
		
		WebElement e= elementLocatorbyId(driver,locator);
		Select s= new Select(e);
		s.selectByVisibleText("Female");
		
	}
	
public void selectdropdwon(WebDriver driver, String locator, String value) {
		
		WebElement e= elementLocatorbycss(driver,locator);
		Select s= new Select(e);
		s.selectByVisibleText(value);
		
	}

public void explciitwaitt(WebDriver driver, int time) {
	WebDriverWait  w= new WebDriverWait(driver, Duration.ofSeconds(time));
	w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ProtoCommerce Home")));
	
}

public void explciitwaittbyid(WebDriver driver, int time, String locator) {
	WebDriverWait  w= new WebDriverWait(driver, Duration.ofSeconds(time));
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
	
}
}

