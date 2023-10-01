package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	// creating constructors

	WebDriver ldriver;

	public SearchCustomerPage(WebDriver rdriver) {

			ldriver = rdriver;

			PageFactory.initElements(rdriver, this);
		}

	public boolean SearchCustomerByEmail(String expectedEmail) {
		return false;
	}
	public void ClickOnSearchButton() {
	}
	public void EnterClass(String string) {
	}

	// Finding all the elements on the webpage

}
