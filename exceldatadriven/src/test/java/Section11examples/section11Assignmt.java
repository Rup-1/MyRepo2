package Section11examples;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.driverutility;

public class section11Assignmt {
//public static String driver;
	driverutility d= new driverutility();
	WebDriver driver= d.webDriver();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		section11Assignmt sec= new section11Assignmt();
		sec.selectcheckboxandgetlabel(.driver);
		
	}
	
	public void selectcheckboxandgetlabel(WebDriver driver) {
			WebElement chekcbox= d.elementLocatorbyId(driver,"checkBoxOption3" );
		
		
	}

}
