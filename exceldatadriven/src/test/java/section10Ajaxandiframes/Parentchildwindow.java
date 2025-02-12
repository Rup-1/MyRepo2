package section10Ajaxandiframes;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parentchildwindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		//driver will not have knowledge about child tab /window opened. we need to explicitly mention child url
		//getwindowhandles method will give list of all opened windows/tabs and gives id of that(parentid, child1id, chiild2id etc)
		Set<String> windws= driver.getWindowHandles();
		Iterator<String>  i= windws.iterator();
		String parentid= i.next();
		String chiildid= i.next();
		driver.switchTo().window(chiildid);  //use iterator to go to eac windowid until child window id  and pass that id to swithc to that window
		System.out.println(driver.findElement(By.className("inner-box")).getText());
		Thread.sleep(4000);
		String text= driver.findElement(By.cssSelector(".im-para.red")).getText();
		String email =text.split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(email);
		
		
		
		

	}

}
