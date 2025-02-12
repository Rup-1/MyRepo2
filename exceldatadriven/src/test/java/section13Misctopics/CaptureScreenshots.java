package section13Misctopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		//we are casting takesscreeshot to driver 
		TakesScreenshot scshot= (TakesScreenshot)driver;
		//to take screenshot use gescreenshtoas and store it in a file(outputtype.file)
		File f= scshot.getScreenshotAs(OutputType.FILE);
		// to place the file in our local/any desired folder
		File targetloc= new File("C:\\Users\\harsha\\Desktop\\sc1.png");
		FileUtils.copyFile(f,targetloc);

	}

}
