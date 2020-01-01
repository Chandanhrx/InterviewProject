package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericMethods.CommonFunctions;
import genericMethods.Constants;

public class Amazon_OR {

	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement amazon_searchBox;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement amazon_searchButton;
	
	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	private WebElement amazon_iphonePriceText;
	
	
	
	public WebElement getIphonePrice_amazon() {
    	CommonFunctions.waitforElement(amazon_searchBox);

		amazon_searchBox.sendKeys(Constants.productName);
    	CommonFunctions.waitforElement(amazon_searchButton);

		amazon_searchButton.click();
    	CommonFunctions.waitforElement(amazon_iphonePriceText);

		return amazon_iphonePriceText;
		
		
		
	}
	
	
	
	
}
