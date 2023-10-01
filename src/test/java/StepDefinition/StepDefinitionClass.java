package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerByEmail;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionClass extends BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public SearchCustomerByEmail scbe;

	public AddNewCustomerPage ancp;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("setup executed");
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// allocating memory to LoginPage
		lp = new LoginPage(driver);

		// allocating memory to AddNewCustomerPage
		ancp = new AddNewCustomerPage(driver);

		// allocating memory to SearchCustomerByEmail
		scbe = new SearchCustomerByEmail(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String passwordAdd) {

		lp.enterEmail(emailAdd);
		lp.enterPassword(passwordAdd);

	}

	@When("click on Login")
	public void click_on_login() {

		lp.clicklogin();
	}
////// LoginFeature ///////

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true); // pass

		} else {
			Assert.assertTrue(false); // fail
		}

	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {

		lp.clicklogin();

	}

	@Then("close browser")
	public void close_browser() {

		driver.close();
		driver.quit();

	}
	/////// Add New Customer ///////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {

		String ActualTitle = ancp.GetPageTitle();
		String ExpectedTitle = "Dashboard / nopCommerce administration";

		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {

		ancp.ClickOnCustomerMenu();

	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {

		ancp.ClickOnMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {

		ancp.ClickOnAddNew();

	}

	@Then("User can view and Add new customer page")
	public void user_can_view_and_add_new_customer_page() {
		// this is the verification/checkpoint, verify the NEW page title

		String ExpectedTitle = "Add a new customer / nopCommerce administration";
		String ActualTitle = ancp.GetPageTitle();

		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@When("User enetr customer info")
	public void user_enetr_customer_info() throws InterruptedException {

		Thread.sleep(1000);

		ancp.EnterEmail("ahsanur913@gmail.com");
		// ancp.EnterEmail(generateEmailId() + "@gmail.com");
		Thread.sleep(1000);
		ancp.EnterPassword("Test123");
		Thread.sleep(1000);
		ancp.EnterFirstName("Ahsan");
		Thread.sleep(1000);
		ancp.EnterLastName("Rahman");
		Thread.sleep(1000);
		ancp.EnterDOB("6/12/1947");
		Thread.sleep(1000);
		ancp.CompanyName("PnT");
		Thread.sleep(1000);
		ancp.EnterGender("Male");
		Thread.sleep(1000);
	}

	@When("click on Save button")
	public void click_on_save_button() {

		ancp.SaveButton();

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String ExpectedConfirmMessage) {

		String text = driver.findElement(By.tagName("Body")).getText();

		if (text.contains(ExpectedConfirmMessage)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	/////// Search customer by email ////

	@When("Enter customer Email")
	public void enter_customer_email() {
		scbe.EnterEmail("CVAUM@gmail.com");

	}

	@When("click on search button")
	public void click_on_search_button() {
		scbe.ClickOnSearchButton();

	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {
		String ExpectedEmail = "CVAUM@gmail.com";
		Assert.assertTrue(scbe.SearchCustomerByEmail(ExpectedEmail));
	}

	@After
	public void teardown(Scenario sc) throws IOException {
		if (sc.isFailed() == true) {
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(f, new File(
					"C:\\Users\\tasee\\OneDrive\\Desktop\\SE_JAVA_CLASS\\CucumberFramework\\Screenshot\\failedscreenshot.png"));
		}

		System.out.println("teardown executed");

		driver.quit();
	}

}
