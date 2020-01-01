package tripAdvisorTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import genericMethods.BaseClass;
import genericMethods.Constants;
import objectRepository.Amazon_OR;
import objectRepository.TripAdvisor_OR;

public class RatingTest extends BaseClass {
	
	@Test
	public void ratingTest() throws Throwable {
		
		driver.get(Constants.url3);
		TripAdvisor_OR trip = PageFactory.initElements(driver, TripAdvisor_OR.class);

		trip.RatingSelection();
		
	}

}
