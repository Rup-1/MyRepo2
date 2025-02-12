package locatorsexample;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import utilities.driverutility;

public class Locatorsassignment {

	public static void main(String[] args) throws InterruptedException {
		
		driverutility d= new driverutility();
		WebDriver driver= d.webDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		d.launchurl(driver, "https://rahulshettyacademy.com/angularpractice/");
		d.elementLocatorbyname(driver, "name").sendKeys("usernma");
		d.elementLocatorbyname(driver, "email").sendKeys("usernma@gmail.com");
		d.elementLocatorbyId(driver, "exampleInputPassword1").sendKeys("pwd");
		d.selectcheckbox(driver,  "exampleCheck1");
		d.selectdropdwon(driver, "exampleFormControlSelect1");
		d.selectcheckbox(driver, "inlineRadio1");
		Thread.sleep(3000);
		WebElement datee= driver.findElement(By.name("bday"));
	//	datee.click();
		datee.sendKeys("01/01/2024");
		d.elementLocatorbycss(driver, "input[type='submit']").click();
		String message= d.elementLocatorbyclassname(driver, "alert-success").get
		System.out.println(message);
		String[] m= message.split("\n");
		System.out.println("2nd line is "+ m[1]);
		String expected="Success! The Form has been submitted successfully!.";
		Assert.assertEquals(m[1], expected);
		
		
		
		
		

	}
	
	

}
