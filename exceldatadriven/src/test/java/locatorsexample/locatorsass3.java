package locatorsexample;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.driverutility;

public class locatorsass3 {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driverutility d= new driverutility();
		WebDriver driver= d.webDriver();
		String url="https://rahulshettyacademy.com/loginpagePractise/";
		String username="rahulshettyacademy";
		String password="learning";
		d.launchurl(driver, url);
		
		d.elementLocatorbyId(driver, "username").sendKeys(username);
		d.elementLocatorbyId(driver, "password").sendKeys(password);
		d.elementLocatorbycss(driver, "input[value='user']").click();
		d.explciitwaittbyid(driver,5,"div.modal-body");
		d.elementLocatorbyId(driver, "okayBtn").click();
		d.elementLocatorbyId(driver, "terms").click();
		d.elementLocatorbyId(driver, "signInBtn").click();
		d.explciitwaitt(driver, 10);
		String actual=driver.findElement(By.linkText("ProtoCommerce Home")).getText();
		String Expected="ProtoCommerce Home";
		Assert.assertEquals(actual, Expected);
		System.out.println(actual);
		webelementss(driver);
		
		
		
		
	}
	
	public static void webelementss(WebDriver driver) {
		List<WebElement> itemslist= driver.findElements(By.cssSelector("div.h-100"));
		for(WebElement e: itemslist) {
			e.findElement(By.cssSelector("button.btn-info")).click();
		}
		int count= itemslist.size();
		String te= driver.findElement(By.cssSelector("a.btn-primary")).getText();
		System.out.println(te);
		int rep= Integer.parseInt(te.replaceAll("[^0-9]", ""));	
		System.out.println(rep);
		Assert.assertEquals(rep, count);
		
		
	}

}
