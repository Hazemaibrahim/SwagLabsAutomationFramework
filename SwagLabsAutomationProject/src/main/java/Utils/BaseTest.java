package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	
	@BeforeClass
    public void setUpTest() {
    	
    	//setup Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        //navigates to the webPage 
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        
        //implicit wait for 10 seconds to wait for elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }
	
	
	@AfterClass
	public void tearDown() {
		
        //close session
		driver.close();
		driver.quit();
	}

}
