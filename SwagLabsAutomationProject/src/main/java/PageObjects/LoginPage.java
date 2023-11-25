package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseTest;

public class LoginPage extends BaseTest {
	
	WebDriver driver;
	
	// Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
   public void typeUserName(String name) {
    	
    	driver.findElement(By.id("user-name")).sendKeys(name);
    }
    
    public void typePassword(String password) {
    	
    	driver.findElement(By.id("password")).sendKeys(password);
    }
    
    public void clickLoginButton() {
    	
    	//login to the account
    	driver.findElement(By.id("login-button")).click();

    	

    }

}
