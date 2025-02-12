package section10Ajaxandiframes;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignementwindowhandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> wind= driver.getWindowHandles();
		Iterator<String> i= wind.iterator();
		String parentid= i.next();
		String childid=i.next();
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.className("example")).getText());
		driver.switchTo().window(parentid);
		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
	}
	
	

}
