package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import pages.HomePage;



public class BaseTest {
	
	WebDriver driver;
	public HomePage homePage;

	@Parameters({"url"})
	@BeforeClass
	public void setup(String url) throws IOException {
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new FirefoxDriver();
		//maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);	
		driver.get(url);

		
		homePage = new HomePage(driver);
		
		
	}
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			TakesScreenshot poza = (TakesScreenshot)driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			
			try {
				Files.move(picture, new File("screenshots/" + result.getName() + ".png"));
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	

}
