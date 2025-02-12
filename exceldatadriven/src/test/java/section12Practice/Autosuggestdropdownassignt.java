package section12Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Autosuggestdropdownassignt {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("in");
		Thread.sleep(2000);
		List<WebElement> we= driver.findElements(By.xpath("//ul[@id='ui-id-1']//li//div"));
		for(WebElement x:we) {
			Actions a= new Actions(driver);
			a.moveToElement(x).build().perform();
			if(x.getText().equalsIgnoreCase("India")) {
				Thread.sleep(2000);
				x.click();
				break;
				
			}
		}
	}

}
