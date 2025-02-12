package javaStreamssamples;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GetPriceforinput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get price for one fruit based on input(Chocolate). go to each page and search for the item until found
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> val;
		do {
		List<WebElement> we= driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
		//find element Chocolate and get price for it
		//first find chocolate
		 val= we.stream().filter(s->s.getText().contains("Chocolate")).map(s->getprice(s)).collect(Collectors.toList());
		val.forEach(a->System.out.println(a));
		if(val.size()<1) {
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}while(val.size()<1);
	}

	private static String getprice(WebElement s) {
		// TODO Auto-generated method stub
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
	}

}
