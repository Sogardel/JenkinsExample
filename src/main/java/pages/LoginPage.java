package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	private WebDriver driver;
	private By usernameField = By.cssSelector("input[id='log']");
	private By passwordField = By.cssSelector("input[id='password']");
	private By submitButton = By.cssSelector("input[class='submit_button']");
	
	public By errorLoginMessage = By.cssSelector("div[class*=sc_infobox_style_error]");
	public By sucessLoginMessage = By.cssSelector("div[class*=sc_infobox_style_success]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void setUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	
	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public LoggedUser clickSubmitButton() {
		driver.findElement(submitButton).click();
		return new LoggedUser(driver);
	}

}
