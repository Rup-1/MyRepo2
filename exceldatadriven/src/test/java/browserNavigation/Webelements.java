package browserNavigation;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Webelements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			Webelements e= new Webelements();
//			e.staticdropdwn(driver);
//			e.dyanmicdropdown(driver);
		//	e.checkboxselection(driver);
		//	e.countcheckbox(driver);
			e.radiobuttonex(driver);
	}
	
	public void staticdropdwn(WebDriver driver) {
		//static dropdown. it has mostly select tag in html
		//create a object for "select" selenium class and pass webelement of that dropdown
		WebElement ex= driver.findElement(By.id("dropdown-class-example"));
		Select dropdwn= new Select(ex);
		dropdwn.selectByIndex(1);
		System.out.println("selected option is "+dropdwn.getFirstSelectedOption().getText());
		dropdwn.selectByVisibleText("Option3");
		dropdwn.selectByValue("option2");
	}
	
	public void countcheckbox(WebDriver driver) {
		//identify csss path such that, all options are identified with this locator
		List<WebElement> opt= driver.findElements(By.cssSelector("div[id='checkbox-example'] input[name*='checkBoxOption']"));
		System.out.println("total options are "+ opt.size());
		for(WebElement eachoption: opt) {
			System.out.println("options are"+ eachoption.getTagName());
			
		}
		
	}
	
	public void dyanmicdropdown(WebDriver driver) throws InterruptedException {

		// dynamic dropdown
		driver.findElement(By.id("autocomplete")).sendKeys("in");
		Thread.sleep(2000);
		/*
		 * WebElement options= driver.findElement(By.
		 * xpath("//ul[@id='ui-id-1'] //li[@class='ui-menu-item'] //div[text()='India']"
		 * )); System.out.println(options.getText()); options.click();
		 */
		List<WebElement> op = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		for (WebElement w : op) {
			if (w.getText().equalsIgnoreCase("India")) {
				System.out.println(w.getText());
				w.click();
				break;
			}

		}
	}
	
	public void checkboxselection(WebDriver driver) {
		WebElement checkbx= driver.findElement(By.cssSelector("input[name='checkBoxOption1']"));
		checkbx.click();
		if(checkbx.isSelected())
		{
			System.out.println("checkbox selected");
			checkbx.click();
			System.out.println("checkbox is now unselected");
		}
	}
	
	public void radiobuttonex(WebDriver driver) {
		WebElement radiobtn= driver.findElement(By.cssSelector("input[value='radio1']"));
		radiobtn.click();
		//System.out.println(radiobtn.getText()+"is selected");
		System.out.println(radiobtn.isSelected());
		String namee= radiobtn.getAttribute("value");
		System.out.println("label selected is"+ namee);
		Boolean val=radiobtn.isSelected();
		//assert.assertTrue(val);
		WebElement radiobtn1= driver.findElement(By.xpath("//input[@value='radio3']"));
		radiobtn1.click();
		System.out.println("radio1"+ radiobtn.isSelected());
		System.out.println("rdaio3"+ radiobtn1.isSelected());
		List<WebElement> btncount= driver.findElements(By.cssSelector("input[class='radioButton']"));
		System.out.println(btncount.size());
	}
	
	
}
 
		
		
		
	

