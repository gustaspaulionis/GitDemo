package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import academy.Base;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LandingPage extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() {
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String userType) throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("HomePage url is opened");
		HomePage hp = new HomePage(driver);
		LoginPage lp = hp.getLogin();
		// LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		log.info(userType);
		Assert.assertTrue(false);
		//lp.getLoginBtn().click();
	}
	
	@Test
	public void titleCheck() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		HomePage hp = new HomePage(driver);
		Assert.assertEquals(hp.getTitle().getText(), "FEATURED COURSES");
		log.info("Validated a text message");
	}
	
	@Test
	public void navBarCheck() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.getNavBar().isDisplayed()); 
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		data[0][0] = "Login1";
		data[0][1] = "Password1";
		data[0][2] = "Restricted user";
		data[1][0] = "Login2";
		data[1][1] = "Password2";
		data[1][2] = "Non-restricted user";
		
		return data;
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
