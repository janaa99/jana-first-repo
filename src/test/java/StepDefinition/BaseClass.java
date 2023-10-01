package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerByEmail;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public SearchCustomerByEmail scbe;

	public AddNewCustomerPage ancp;

	public String generateEmailID() {
		return (RandomStringUtils.randomAlphabetic(5));
	}

}
