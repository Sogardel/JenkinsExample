package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoggedUser {
	
	private By usernameDisplay = By.className("user_name");
	private By accountSettingsLink = By.linkText("Settings");
	
	WebDriver driver;
	
	public LoggedUser(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public String readUserName() {
		
		return driver.findElement(usernameDisplay).getText();
		
	}
	
	public boolean checkPresenceOFSettingsPopUp() {
		WebElement userNameDisplay = driver.findElement(usernameDisplay);
		Actions action = new Actions(driver);
		action.moveToElement(userNameDisplay).perform();
		return driver.findElement(accountSettingsLink).isDisplayed();
		
	}
	
}
