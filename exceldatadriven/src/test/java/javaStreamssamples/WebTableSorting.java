package javaStreamssamples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//sort veggie names using javastreams and compare with orig list of veggies sorted on UI
		// click sort on UI and get sorted list from ui. also get regular list from UI- sort it using javastreams and compare both lists
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		WebElement pages= driver.findElement(By.id("page-menu"));
		Select ss= new Select(pages);
		ss.selectByValue("20");
		
		List<WebElement> we= driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
		//orig  list
			List<String> origlist= we.stream().map(s->s.getText()).collect(Collectors.toList());
			//sort it
			List<String> sortedlist= origlist.stream().sorted().collect(Collectors.toList());
		
		//get sorted list from uI
		driver.findElement(By.xpath("//thead//tr//th[1]")).click();
		ArrayList<String> sortedlistfromui= new ArrayList<String>();
		List<WebElement> www= driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
		List<String> sortdlistonUi= www.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//compare both lists
		System.out.println(sortedlist);
		Assert.assertTrue(sortdlistonUi.equals(sortedlist),"sort matched");
		
		
	}

}
