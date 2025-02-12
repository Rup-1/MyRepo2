package Section11examples;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.driverutility;

public class LinkCountonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driverutility d= new driverutility();
		WebDriver driver= d.webDriver();
		d.launchurl(driver, "https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		//count of links on the page
		List<WebElement> we= driver.findElements(By.tagName("a"));
		System.out.println(we.size());
		//count of links in footer section
		WebElement footer= driver.findElement(By.id("gf-BIG")); //limiting webdriver scope to footer secton
		List<WebElement> s= footer.findElements(By.tagName("a"));
		System.out.println(s.size());
		//count of links in footer section first column
		WebElement footer1stsection= driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));//limiting webdriver scope to footer 1stsecton
		List<WebElement> sec1= footer1stsection.findElements(By.tagName("a"));
		System.out.println(sec1.size());
		//open each link in seaprate tab and get text of that url to confirm link is opened
		for(WebElement ee:sec1) {
			Actions a= new Actions(driver);
			a.moveToElement(ee).keyDown(Keys.CONTROL).click().build().perform();
		}
		Set<String> id= driver.getWindowHandles();
		Iterator<String> i= id.iterator();
		String parentid= i.next();
		while(i.hasNext()) {
			
			driver.switchTo().window(i.next());
			System.out.println(driver.getTitle());
			
		}
	}

}
