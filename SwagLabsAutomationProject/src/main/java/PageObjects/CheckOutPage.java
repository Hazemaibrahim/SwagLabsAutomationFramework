package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseTest;

public class CheckOutPage extends BaseTest {
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void goToCheckoutPage() {
		
		driver.findElement(By.id("checkout")).click();
	}
	
	public void enterFirstName(String firstName) {
		
		driver.findElement(By.id("first-name")).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		
		driver.findElement(By.id("last-name")).sendKeys(lastName);
	}
	
	public void enterPostalCode(String postalCode) {
		
		driver.findElement(By.name("postalCode")).sendKeys(postalCode);
	}
	
	public void clickContinue() {
		
		driver.findElement(By.id("continue")).click();
	}
	
	public void clickOnFinish() {
		
		//click on finish button to purchase the product
		// Scroll to the end of the page
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
		
		driver.findElement(By.id("finish")).click();

	}
	public void returnToHomePage() {
		
		driver.findElement(By.name("back-to-products")).click();
	}
	

}
