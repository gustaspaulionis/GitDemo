package stepDefinition;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import org.junit.runner.RunWith;

import academy.Base;

@RunWith(Cucumber.class)
public class stepDefinition extends Base {

	@Given("^Initialize the browser$")
	public void initialize_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("^Navigate to the \"([^\"]*)\"$")
	public void navigate_to_the(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(arg1);
	}

	@Given("^Click on the Login button$")
	public void click_on_the_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HomePage hp = new HomePage(driver);
		LoginPage lp = hp.getLogin();
	}

	@When("^Enter (.+) and (.+) and click Login button$")
    public void enter_and_and_click_login_button(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginBtn().click();
	}


	 @And("^Close browsers$")
	    public void close_browsers() throws Throwable {
	        driver.close();
	    }
}