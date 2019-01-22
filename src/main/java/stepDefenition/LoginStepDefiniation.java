package stepDefenition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class LoginStepDefiniation {
	
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
	public void User_enters_username_and_password() throws Throwable {
	    fire.findElement(By.name("username")).sendKeys("Pranav1992");
	    fire.findElement(By.name("password")).sendKeys("Ecd#0000");
	    
	}

	@Then("^Click on Login BTN$")
	public void Click_on_Login_BTN() throws Throwable {
	   WebElement btn = fire.findElement(By.xpath(".//*[@value='Login']"));
	   // btn.click();
	   JavascriptExecutor js = (JavascriptExecutor)fire;
	   js.executeScript("arguments[0].click();", btn);
	}

	@Then("^User is on home page$")
	public void User_is_on_home_page() throws Throwable {
		Thread.sleep(3000);
	    String expectedTitle = "CRMPRO";
	    String currentTitle = fire.getTitle();
		System.out.println("After login Page title:- " + currentTitle);
		
		Assert.assertEquals(expectedTitle, currentTitle);
	}
	
	@Then("^Close the browser$")
	public void Close_the_browser() throws Throwable {
		fire.quit();
	}
	
	// New contact
	@Given("^User is already logged in$")
	public void User_is_already_logged_in() throws Throwable {
		System.out.println("");
		System.out.println("********************************** Test New Contact **********************************");
	 
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium_Jars\\geckodriver.exe");
		fire = new FirefoxDriver();
		fire.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fire.get("https://www.freecrm.com/index.html");
	}
	
	@Then("^Login with \"(.*)\" and \"(.*)\"$")
	public void Login_with_username_and_password(String username, String password) throws Throwable {
	    fire.findElement(By.name("username")).sendKeys(username);
	    fire.findElement(By.name("password")).sendKeys(password);
	    WebElement btn = fire.findElement(By.xpath(".//*[@value='Login']"));
		// btn.click();
		JavascriptExecutor js = (JavascriptExecutor)fire;
		js.executeScript("arguments[0].click();", btn);
	    
	}
	
	@When("^Title of home page is CRMPRO$")
	public void Title_of_home_page_is_CRMPRO() throws Throwable {
		Thread.sleep(3000);
		String expectedTitle = "CRMPRO";
		String currentTitle = fire.getTitle();
		System.out.println("Login Page title:- " + currentTitle);
		
		Assert.assertEquals(expectedTitle, currentTitle);
	}
	
	@Then("^User Hovers on Contacts and click on New Contact$")
	public void User_Hovers_on_Contacts_and_click_on_New_Contact() throws Throwable {
		List<WebElement> frameSize = fire.findElements(By.tagName("frame"));
		System.out.println("Number of Frames:- " + frameSize.size());
		
		fire.switchTo().frame(1);
		Thread.sleep(3000);
		WebElement contactmenu = fire.findElement(By.linkText("CONTACTS"));
		Actions action = new Actions(fire);
	    action.moveToElement(contactmenu).build().perform();
		WebElement newcontact = fire.findElement(By.linkText("New Contact"));
		newcontact.click();
	}

	@Then("^Enter Contact information$")
	public void Enter_Contact_information() throws Throwable {
		fire.findElement(By.name("title")).sendKeys("Mr.");
		fire.findElement(By.name("first_name")).sendKeys("Test1");
		fire.findElement(By.name("surname")).sendKeys("QA");
	}

	@Then("^click on Save$")
	public void click_on_Save() throws Throwable {
		fire.findElement(By.xpath(".//*[@value='Save']")).click();
	}

	@Then("^Hover on Contacts and select Full Search Form$")
	public void Hover_on_Contacts_and_select_Full_Search_Form() throws Throwable {
		//fire.switchTo().frame(1);
		
		fire.findElement(By.xpath(".//*[@title='Contacts']")).click();
	}

	@Then("^Contact must be displayed on the table$")
	public void Contact_must_be_displayed_on_the_table() throws Throwable {
		List<WebElement> result = fire.findElements(By.partialLinkText("Test1 QA"));
		Assert.assertTrue(result.size()>0);
	}


}
