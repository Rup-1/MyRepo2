package section13Misctopics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import java.io.IOException;
import java.net.*;
import java.util.List;    

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1. get urls of all links using selenium
		//2. use java methods to call these url's and to check ststus
		//3. if status code>400, it is brokenlink
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> we= driver.findElements(By.cssSelector("li[class='gf-li'] a"));//gives url present in href attribuet
		System.out.println(we.size());
		SoftAssert a= new SoftAssert();
		for(WebElement w: we){
			String uu= w.getAttribute("href");
			//2. java methods (OpenConnection method in url class
			URL u= new URL(uu);
		HttpURLConnection con= (HttpURLConnection) u.openConnection();
		con.setRequestMethod("HEAD"); 
		con.connect();
		int respcode= con.getResponseCode();
		System.out.println(w.getText() +","+ respcode);
		a.assertTrue(respcode< 400, "failed="+ w.getText() +","+ respcode);
		}
		a.assertAll();
	}

}
