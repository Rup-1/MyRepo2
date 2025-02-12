package section12Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> rows= driver.findElements(By.xpath("//table[@name='courses']//tr"));
		System.out.println("rows="+ rows.size());
		List<WebElement> columns= driver.findElements(By.xpath("//table[@name='courses']//tr//th"));
		System.out.println("columns="+ columns.size());
		List<WebElement> tes= driver.findElements(By.xpath("//table[@name='courses']//tr[3]//td"));
		for (WebElement e: tes) {
			System.out.println(e.getText());
		}
		

	}

}
