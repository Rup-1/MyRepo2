package Section11examples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderDate {

	public static void main(String[] args) {

		String syear = "2025";
		String smonth = "November";
		String sday = "20";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("button.react-date-picker__calendar-button")).click();
		driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();
		List<WebElement> year = driver.findElements(By.cssSelector("button.react-calendar__tile"));
		for (WebElement w : year) {
			String ss= w.getText();
			if (ss.matches(syear)) {
				w.click();
				List<WebElement> month = driver.findElements(By.cssSelector("button.react-calendar__year-view__months__month"));
				for (WebElement m : month) {
					if (m.getText().equalsIgnoreCase(smonth)) {
						m.click();
						List<WebElement> day = driver
								.findElements(By.cssSelector("button.react-calendar__month-view__days__day"));
						for (WebElement d : day) {
							if (d.getText().matches(sday)) {
								d.click();
								break;	
							}
							
						}
						break;
					}
				}
				break;
			}
		}
		String selectedate= driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']//input[@name='date']")).getAttribute("value");
		System.out.println(selectedate);
	}
}
