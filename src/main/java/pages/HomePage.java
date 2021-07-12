package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	private By shopLink = By.linkText("BOOKS");
	private By eventsLink = By.linkText("EVENTS");


	private By loginLink = By.linkText("Login");
	
	public By linkComingSoon = By.linkText("COMING SOON");
	
	public By searchIcon = By.cssSelector("button[class*='search_submit']");
	
	public By searchField = By.className("search_field");
	
	
	public By copywrightLink = By.linkText("KeyTraining");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		}
	
	public LoginPage navigateToLogin() {
		driver.findElement(loginLink).click();
		return new LoginPage(driver);
	}
	
	
}
