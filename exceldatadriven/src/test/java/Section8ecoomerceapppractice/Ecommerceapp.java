package Section8ecoomerceapppractice;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

public class Ecommerceapp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String[] veggie= {"Carrot","Beans","Potato"};
		WebDriver driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Ecommerceapp e= new Ecommerceapp();
		e.addItemsToCart(driver,veggie);
		e.checkOut(driver);
		
		System.out.println("testing git2 ");

	}
	
	public void addItemsToCart(WebDriver driver, String[] veggies) {

		List<WebElement> products = driver.findElements(By.className("product"));
		for (int i = 0; i < products.size(); i++) {
			String[] pname = products.get(i).getText().split("-");
			String name = pname[0].trim();
			List<String> veggielist = Arrays.asList(veggies);
			int j = 0;
			if (veggielist.contains(name)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == veggielist.size()) {
					break;
				}
			}
		}
	}
	
	public void checkOut(WebDriver driver) throws Exception {
		
			driver.findElement(By.cssSelector("img[alt='Cart']")).click();
			driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
			explicitWaitMethod(driver,"input[class='promoCode']");
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
			driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("abc");
			driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
			//explicitWaitMethod(driver,"span[class='promoInfo']");
			fluentwait(driver,"span[class='promoInfo']");
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
			String text= driver.findElement(By.cssSelector("span[class='promoInfo']")).getText();
			System.out.println(text);
	}
	
	public void explicitWaitMethod(WebDriver driver, String locatorvalue) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorvalue)));
	}
	
	public void fluentwait(WebDriver driver,String locatorvalue) {
		Wait<WebDriver> ww= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));//.ignoring(NoSuchElementException.class);
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorvalue)));
		
		

}

}
