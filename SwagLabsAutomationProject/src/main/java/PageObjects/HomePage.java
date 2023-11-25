package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseTest;

public class HomePage extends BaseTest {
	WebDriver driver;
	
	// Constructor to initialize the WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void addItemToCart(String name) {
    	//adds item to card

    	driver.findElement(By.name(name)).click();
    	
    }
    
    public void clickOnSideBar() {
    	
    	driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }
    
    public void logOut() {
    	
    	//add explict wait to wait for logout button to be clickable then click on it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
    	driver.findElement(By.id("logout_sidebar_link")).click();
    	
    }

}
