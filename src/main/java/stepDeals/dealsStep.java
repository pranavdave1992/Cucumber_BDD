package stepDeals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class dealsStep {
WebDriver fire;
	
	@Given("^User is already on login page$")
	public void user_already_on_login_page(){
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium_Jars\\geckodriver.exe");
		fire = new FirefoxDriver();
		fire.get("https://www.freecrm.com/index.html");
	}
	
	@When("^title of log in page is Free CRM$")
	public void title_of_log_in_page_is_Free_CRM() throws Throwable {
		
		String expectedTitle = "#1 Free CRM software in the cloud for sales and service";
		
		String currentTitle = fire.getTitle();
		System.out.println("Login Page title:- " + currentTitle);
		
		Assert.assertEquals(expectedTitle, currentTitle);
	}

	@Then("^User enters username and password$")
	public void User_enters_username_and_password(DataTable credentials){
		
		for(Map<String, String> data : credentials.asMaps(String.class, String.class)) {
			fire.findElement(By.name("username")).sendKeys(data.get("username"));
			fire.findElement(By.name("password")).sendKeys(data.get("password"));
		}
		
	}

	@Then("^Click on Login BTN$")
	public void Click_on_Login_BTN(){
	   WebElement btn = fire.findElement(By.xpath(".//*[@value='Login']"));
	   // btn.click();
	   JavascriptExecutor js = (JavascriptExecutor)fire;
	   js.executeScript("arguments[0].click();", btn);
	}

	@Then("^User is on home page$")
	public void User_is_on_home_page() throws InterruptedException{
		Thread.sleep(5000);
	    String expectedTitle = "CRMPRO";
	    String currentTitle = fire.getTitle();
		System.out.println("After login Page title:- " + currentTitle);
		
		Assert.assertEquals(expectedTitle, currentTitle);
	}
	
	@Then("^User moves to new deal page$")
	public void User_moves_to_new_deal_page() throws InterruptedException {
		fire.switchTo().frame(1);
		Thread.sleep(1000);
		
		WebElement contactmenu = fire.findElement(By.linkText("DEALS"));
		Actions action = new Actions(fire);
	    action.moveToElement(contactmenu).build().perform();
		WebElement newdeal = fire.findElement(By.linkText("New Deal"));
		newdeal.click();
	}
	
	@Then("^User enters deal details$")
	public void user_enters_deal_details(DataTable deals) {
		for(Map<String, String> data : deals.asMaps(String.class, String.class)) {
			fire.findElement(By.name("title")).sendKeys(data.get("title"));
			fire.findElement(By.name("amount")).sendKeys(data.get("amount"));
			fire.findElement(By.name("probability")).sendKeys(data.get("probability"));
			fire.findElement(By.name("commission")).sendKeys(data.get("commission"));
			
			fire.findElement(By.xpath(".//input[@value='Save']")).click();
			
			WebElement contactmenu = fire.findElement(By.linkText("DEALS"));
			Actions action = new Actions(fire);
		    action.moveToElement(contactmenu).build().perform();
			WebElement newdeal = fire.findElement(By.linkText("New Deal"));
			newdeal.click();
		}
	}
	
	@Then("^Close the browser$")
	public void Close_the_browser() throws Throwable {
		fire.quit();
	}
}
