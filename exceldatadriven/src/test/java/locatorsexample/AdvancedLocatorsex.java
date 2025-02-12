package locatorsexample;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utilities.driverutility;

public class AdvancedLocatorsex {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		driverutility d= new driverutility();
		WebDriver driver= d.webDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		d.launchurl(driver,"https://rahulshettyacademy.com/locatorspractice/");
		String username="user1";
		AdvancedLocatorsex sd= new AdvancedLocatorsex();
		String validPass=	sd.resetpwd(driver);
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys(validPass);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[value='agreeTerms']")).click();
		driver.findElement(By.className("submit")).click();
	if(driver.findElement(By.className("logout-btn")).isDisplayed()){
			Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
			System.out.println("login successful");
			Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+ username+ ",");
			driver.findElement(By.xpath("//button[text()='Log Out']")).click();
			driver.close();
			
		}
		else 
		{
		 if(driver.findElement(By.cssSelector("p.error")).isDisplayed()) {
			 String error= driver.findElement(By.cssSelector("p.error")).getText();
			 System.out.println(error);
				String temppass= "";
				if(error.equalsIgnoreCase("* Incorrect username or password")) {
							temppass=	sd.resetpwd(driver);	

							driver.findElement(By.className("go-to-login-btn")).click();
							driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("user");
							driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(temppass); //regualr exp
							//driver.findElement(By.cssSelector("input#chkboxOne")).click();
						//	driver.findElement(By.cssSelector("input[value='agreeTerms']")).click();
							driver.findElement(By.cssSelector("button[type='submit']")).click();
							//driver.findElement(By.)
				}	
		 }
		}
		
	}
	
	public String resetpwd(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("user1");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("user1@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String passwrd= driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println("reset pwd text"+ passwrd);
		String[] ar= passwrd.split("'");
		System.out.println("array is "+ar[1]);
		String pqd= ar[1];
		return pqd;
	}

}
