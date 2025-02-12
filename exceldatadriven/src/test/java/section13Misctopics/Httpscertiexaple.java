package section13Misctopics;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Httpscertiexaple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions opt= new ChromeOptions();
		opt.setAcceptInsecureCerts(true); //will accept untrusted browsers and open them
		//to set proxy. create a obj of proxy class and set it as a capability
		Proxy p= new Proxy();
		p.setHttpProxy("ip:332");
		opt.setCapability("proxy", p);
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://expired.badsl.com/");
	}

}
