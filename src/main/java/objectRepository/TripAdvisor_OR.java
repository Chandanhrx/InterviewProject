package objectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import genericMethods.BaseClass;
import genericMethods.CommonFunctions;
import genericMethods.Constants;

public class TripAdvisor_OR {

	@FindBy(xpath="(//input[@type='search'])[2]")
	private WebElement trip_searchBox;
	
	@FindBy(xpath="//span[text()='Search']/..")
	private WebElement trip_searchBox1;
	
	@FindBy(xpath="//input[@id='mainSearch']")
	private WebElement trip_mainSearch;
	
	
	
			@FindBy(xpath="(//button[@type='submit'])[1]")
			private WebElement trip_searchButton2;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement trip_searchButton;
	
	@FindBy(xpath="(//div[@class='result-title'])[1]")
	private WebElement trip_searchResult;
	
	@FindBy(xpath="//a[text()='Write a review']")
	private WebElement trip_WriteReview;
	
	@FindBy(xpath="//span[@id='bubble_rating']")
	private WebElement trip_bubbleImage;
	
	@FindBy(xpath="//em[@id='overallRatingFlagText']")
	private WebElement trip_Excellent;
	
	@FindBy(xpath="//div[@id='ratingFlag']")
	private WebElement trip_average;
	
	@FindBy(xpath="//input[@name='ReviewTitle']")
	private WebElement titleOfyour_Review;
	
	@FindBy(xpath="//textarea[@id='ReviewText']")
	private WebElement your_Review;
	
	@FindBy(xpath="//div[text()='Hotel Ratings']")
	private WebElement Hotel_ratings;
	
	@FindBy(xpath="(//label[@class='visuallyHidden'])[3]/following-sibling::span")
	private WebElement Service_rating;
	
	@FindBy(xpath="(//label[@class='visuallyHidden'])[4]/following-sibling::span")
	private WebElement Clean_rating;
	
	@FindBy(xpath="(//label[@class='visuallyHidden'])[5]/following-sibling::span")
	private WebElement Sleep_Quality;
	
	@FindBy(xpath="//input[@id='noFraud']")
	private WebElement checkBox;
	
	@FindBy(xpath="//div[@id='SUBMIT']")
	private WebElement submit_review;
	
	
	@FindBy(xpath="(//div[@class='detailsRatings']/following-sibling::div)[1]")
	private WebElement HotelRating_Excellent;
	
	@FindBy(xpath="(//div[@class='detailsRatings']/following-sibling::div)[2]")
	private WebElement CleanRating_Excellent;
	
	@FindBy(xpath="(//div[@class='detailsRatings']/following-sibling::div)[3]")
	private WebElement SleepRating_Excellent;
	
	@FindBy(xpath="//div[@data-category='Business']")
	private WebElement Business_Btn;
	
	@FindBy(xpath="//select[@id='trip_date_month_year']")
	private WebElement SelectDropDown;
	
	
	public void RatingSelection() throws Throwable {	
		if(CommonFunctions.searchBox1(trip_searchBox1)) {
			CommonFunctions.waitforElement(trip_searchBox1);

			trip_searchBox1.click();
			CommonFunctions.waitforElement(trip_mainSearch);
			trip_mainSearch.click();
			trip_mainSearch.sendKeys(Constants.trip_searchText);
			CommonFunctions.waitforElement(trip_searchButton2);

			trip_searchButton2.click();
		}
		else {	
		CommonFunctions.waitforElement(trip_searchBox);
		trip_searchBox.click();
		trip_searchBox.sendKeys(Constants.trip_searchText);
		CommonFunctions.waitforElement(trip_searchButton);

		trip_searchButton.click();
		
		}
		
		CommonFunctions.waitforElement(trip_searchResult);

		trip_searchResult.click();
		
		Set<String> set_windowId=BaseClass.driver.getWindowHandles();
		Iterator<String> iterator=set_windowId.iterator();
		String ParentWindow=iterator.next();
		String ChildWindow=iterator.next();

		BaseClass.driver.switchTo().window(ChildWindow);
        Thread.sleep(3000);
		trip_WriteReview.click();
	
		
		Set<String> set_windowId1=BaseClass.driver.getWindowHandles();
		Iterator<String> iterator1=set_windowId1.iterator();
		
		while(iterator1.hasNext()) {
			
			
			BaseClass.driver.switchTo().window(iterator1.next());
			String getTitle=BaseClass.driver.getTitle();
			if(getTitle.contains("Write a review ")) {
				break;
			}

			
		}
		
		CommonFunctions.waitforElement(trip_bubbleImage);
		CommonFunctions.clickBubbble(trip_bubbleImage, trip_Excellent);
		titleOfyour_Review.sendKeys(Constants.title_Review);
		your_Review.sendKeys(Constants.yourReview_txt);
		
		Business_Btn.click();
		CommonFunctions.selectByindex(SelectDropDown, Constants.index);
		
		if(CommonFunctions.searchBox1(Hotel_ratings)) {
			CommonFunctions.waitforElement(Service_rating);

			CommonFunctions.clickBubbble2(Service_rating, HotelRating_Excellent);
			CommonFunctions.waitforElement(Clean_rating);

			
			  CommonFunctions.clickBubbble2(Clean_rating, CleanRating_Excellent);
			  CommonFunctions.waitforElement(Sleep_Quality);
			 

			CommonFunctions.clickBubbble2(Sleep_Quality, SleepRating_Excellent);

			
		}
		
		checkBox.click();
		submit_review.click();
		
	}
	
	
	
}
