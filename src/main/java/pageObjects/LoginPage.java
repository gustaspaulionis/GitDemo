package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import academy.Base;

public class LoginPage extends Base {
	
	public WebDriver driver;
	
	By email = By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@type='password']");
	By loginBtn = By.xpath("//input[@type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}
	

}
