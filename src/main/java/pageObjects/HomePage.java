package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import academy.Base;

public class HomePage extends Base {
	
	public WebDriver driver;
	
	private By login = By.xpath("//nav[@class='pull-right']//li[4]");
	private By title = By.xpath("//div[@class='text-center']/h2");
	private By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {
		driver.findElement(login).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
		
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
}
