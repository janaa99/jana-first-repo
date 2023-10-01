package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//interview question: What is page object model and have you used it before?

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbutton;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutbutton;

	public void enterEmail(String emailID) {

		email.clear();
		email.sendKeys(emailID);

	}

	public void enterPassword(String pwd) {

		password.clear();
		password.sendKeys(pwd);

	}
	
	public void clicklogin() {

		loginbutton.click();

	}
	
	public void clicklogout() {

		logoutbutton.click();

	}

}
