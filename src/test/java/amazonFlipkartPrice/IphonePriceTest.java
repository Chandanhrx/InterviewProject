package amazonFlipkartPrice;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import genericMethods.BaseClass;
import genericMethods.Constants;
import objectRepository.Amazon_OR;
import objectRepository.Flipkart_OR;

public class IphonePriceTest extends BaseClass {

	@Test
	public void iphonePriceCompareTest() {

		driver.get(Constants.url);

		Amazon_OR amazon = PageFactory.initElements(driver, Amazon_OR.class);
		double iphone_AmazonPrice = Double.valueOf(amazon.getIphonePrice_amazon().getText().replaceAll("[^0-9]", ""));
		driver.navigate().to(Constants.url2);

		Flipkart_OR flipkart = PageFactory.initElements(driver, Flipkart_OR.class);
		double iphone_FlipkartPrice = Double
				.valueOf(flipkart.getIphonePrice_Flipkart().getText().replaceAll("[^0-9]", ""));

		
		  if(iphone_AmazonPrice>iphone_FlipkartPrice) {
		  System.out.println("Iphone price on amazon is higher as : " +iphone_AmazonPrice); }
		  else {
		  System.out.println("Iphone price on Flipkart is higher as : "+iphone_FlipkartPrice); }
		  
		 

	}

}
