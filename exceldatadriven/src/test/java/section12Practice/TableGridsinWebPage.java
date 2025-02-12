package section12Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableGridsinWebPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int sum=0;
		//get number of rows present in table
		int rows= driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody//tr")).size();
		for(int i=1; i<=rows;i++) {
		//write xpth to go to each row 4th column
		String num= driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody//tr["+i+"]//td[4]")).getText();
		sum=sum+Integer.parseInt(num);
		}
		System.out.println(sum);
		String actual= driver.findElement(By.className("totalAmount")).getText();
		int a= Integer.parseInt(actual.split(":")[1].trim());
		System.out.println(a);
		Assert.assertEquals(sum, a);
		
	}

}
