package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericMethods.BaseClass;
import genericMethods.CommonFunctions;
import genericMethods.Constants;

public class Flipkart_OR {

	@FindBy(xpath="//input[@name='q']")
	private WebElement flipkart_SearchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement flipkart_SearchButton;
	
	@FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK']")
	private WebElement flipkart_iphonePriceText;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	private WebElement flipkart_popup;
	
	
	
public WebElement getIphonePrice_Flipkart() {
	CommonFunctions.waitforElement(flipkart_popup);
	flipkart_popup.click();
	CommonFunctions.waitforElement(flipkart_SearchBox);

	        flipkart_SearchBox.sendKeys(Constants.productName);
	    	CommonFunctions.waitforElement(flipkart_SearchButton);

	        flipkart_SearchButton.click();
	    	CommonFunctions.waitforElement(flipkart_iphonePriceText);

		     return flipkart_iphonePriceText;
		
		
		
	}
	
	
	
	
}
