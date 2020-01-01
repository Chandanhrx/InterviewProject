
package genericMethods;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	public static WebDriver driver;
	@BeforeClass
	public void configBc(){
		 //launch Browser
		if(Constants.browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
		driver = new ChromeDriver();
		}else if(Constants.browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "./Resources/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		}else{
			driver = new FirefoxDriver();
		}
		
		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}
	
	
  
	
	@AfterClass
	public void configAc(){
		driver.close();
		driver.quit();
	}
}
