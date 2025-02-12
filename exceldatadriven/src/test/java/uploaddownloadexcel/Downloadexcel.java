package uploaddownloadexcel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Downloadexcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		//download
		driver.findElement(By.id("downloadButton")).click();
		
		//edit excel
		//upload excel
		WebElement d= driver.findElement(By.id("fileinput"));
		d.sendKeys("C:\\Users\\harsha\\Downloads\\download.xlsx");
		By toastlocator= By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		//wait for success message , verify and wait to disappear
		WebDriverWait wt= new WebDriverWait(driver,Duration.ofSeconds(10) );
		wt.until(ExpectedConditions.visibilityOfElementLocated(toastlocator));
		//confirm succsess message
		String txt= driver.findElement(toastlocator).getText();
		Assert.assertEquals("Updated Excel Data Successfully.", txt);
		System.out.println(txt);
		//wait until message gone adn verify UI table
		wt.until(ExpectedConditions.invisibilityOfElementLocated(toastlocator));
		
		
		
	
		
		
		
		
		

	}

}
