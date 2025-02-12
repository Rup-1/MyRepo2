package Section11examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Section11ass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Section11ass1 sec= new Section11ass1();
		String text= sec.gettextofcheckox(driver);
		sec.selectdropdonw(driver, text);
		String message= sec.handlealert(driver, text);
		String value= sec.pullsubstring(driver, message);
		Assert.assertEquals(value, text);
		System.out.println("actual is "+value);
		
	}
		public String gettextofcheckox(WebDriver driver) {
			driver.findElement(By.id("checkBoxOption3")).click();
			String text="";
			if(driver.findElement(By.id("checkBoxOption3")).isSelected()) {
				text=driver.findElement(By.id("checkBoxOption3")).getAttribute("value");
			}
			return text;
		}
		
		public void selectdropdonw(WebDriver driver, String val) {
			Select s= new Select(driver.findElement(By.id("dropdown-class-example")));
			s.selectByValue(val);
			
		}
		public String handlealert(WebDriver driver, String val) {
			driver.findElement(By.id("name")).sendKeys(val);
			driver.findElement(By.id("alertbtn")).click();
			String alertmessage= driver.switchTo().alert().getText();
			return alertmessage;
			
		}
		
		public String pullsubstring(WebDriver driver, String strtext) {
			return strtext.split(",")[0].split(" ")[1];
		}
}
