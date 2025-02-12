package locatorsexample;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utilities.driverutility;

public class HandlingJavaAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driverutility d= new driverutility();
		WebDriver driver= d.webDriver();
		d.launchurl(driver, "https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		String text="test";
		d.elementLocatorbyId(driver, "name").sendKeys(text);
		d.elementLocatorbyId(driver, "alertbtn").click();
		
		//switch from driver browser to alert
		String message= driver.switchTo().alert().getText();
		String expected= "Hello "+ text +", share this practice page and share your knowledge";
		Assert.assertEquals(message, expected);
		driver.switchTo().alert().accept();
		d.elementLocatorbyId(driver, "name").sendKeys(text);
		d.elementLocatorbyId(driver, "confirmbtn").click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		
		

	}

}
