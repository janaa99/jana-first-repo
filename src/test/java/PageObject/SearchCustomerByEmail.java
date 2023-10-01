package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByEmail {

	WebDriver ldriver;
	// create constructor

	public SearchCustomerByEmail (WebDriver rdriver) 
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
// Finding all the elements on the webpage
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement emailtextbox;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchbutton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement searchresult;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']/tbody/tr")
	List <WebElement> tablerows;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']/tbody/tr[1]/td[2]")
	List <WebElement> tablecolumns;
	
	////// action methods to search emails ////
	
	public void EnterEmail(String EmailID) {
		emailtextbox.sendKeys(EmailID);
	}
	
	public void ClickOnSearchButton() {
		searchbutton.click();
	}
	
	public boolean SearchCustomerByEmail(String email) throws InterruptedException {
		boolean found = false;
		int totalrows = tablerows.size();
		int totalcolumns = tablecolumns.size();
		
		System.out.println(totalrows);
		System.out.println(totalcolumns);
		
		for (int i = 1; i <= totalrows; i++) {
		//	JavaScriptUtil.scrollIntoView(emailtextbox, ldriver);
			
			Thread.sleep(2000);
			WebElement webemail = ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"));
			
			String ActualEmail = webemail.getText();
			
			if (ActualEmail.equals(email)) {
				found = true;break;
			}
			
		}
		return found;
		
		
	}
	


}