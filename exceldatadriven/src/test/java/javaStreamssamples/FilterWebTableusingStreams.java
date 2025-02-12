package javaStreamssamples;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterWebTableusingStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//search for a item and verify search results matches the items searched for 
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String input="ch";
		driver.findElement(By.id("search-field")).sendKeys(input);
		
		List<WebElement> actuallist= driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
	List<WebElement> itemlist= 	actuallist.stream().filter(s->s.getText().contains("ch")).collect(Collectors.toList());
	System.out.println("actu list"+ itemlist);
		Assert.assertEquals(actuallist.size(), itemlist.size());
		

	}

}
