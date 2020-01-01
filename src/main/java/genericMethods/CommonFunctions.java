package genericMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	
	public static void waitforElement(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(BaseClass.driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	

	public static void clickBubbble(WebElement element, WebElement target) {
		
       Actions act=new Actions(BaseClass.driver);
		
		for(int i=0;i<=100;i=i+5) {
		
			act.moveToElement(element, i, 5).perform();
			if(target.getText().contains("Excellent")) {
				act.click().perform();
				break;
				
			}
		
		
		}
	}
	
	
	public static void clickBubbble2(WebElement element, WebElement target) {
		
	       Actions act=new Actions(BaseClass.driver);
			
			for(int i=0;i<=100;i++) {
				scrollToElement(element);
				act.moveToElement(element, i++, 3).perform();
				if(target.getText().contains("Excellent")) {
					act.click().perform();
					break;
					
				}
			
			
			}
		}
	
	public static void scrollToElement(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)BaseClass.driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	
	public static void selectByindex(WebElement element,int index) {
		
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
public static  boolean searchBox1(WebElement element) {
		
		try
		{
			return element.isDisplayed();
			
			
		}catch(Exception e) {
			return false;
		}
	}
}
