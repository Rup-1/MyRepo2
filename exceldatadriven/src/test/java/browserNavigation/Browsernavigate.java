package browserNavigation;

import org.openqa.selenium.WebDriver;

import utilities.driverutility;

public class Browsernavigate extends driverutility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driverutility d= new driverutility();
		WebDriver driver= d.webDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.facebook.com"); // go(navigate) to this url 
		driver.navigate().back(); //takes back to 1st url-google
		driver.navigate().forward(); // takes forward again to facebook
		
		
	}

}
