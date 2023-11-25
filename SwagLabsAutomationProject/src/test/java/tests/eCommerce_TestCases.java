package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utils.BaseTest;

public class eCommerce_TestCases extends BaseTest {

	@Test(priority=1)
	public void validLogin() throws InterruptedException {
		
		//create a new instance of loginPage class
		LoginPage loginPage=new LoginPage(driver);
		
		//enter valid credentials and login
		loginPage.typeUserName("standard_user");
		loginPage.typePassword("secret_sauce");
		loginPage.clickLoginButton();
		
		//wait for 500ms for the homePage to load
		Thread.sleep(500);
    	
    	//wait till the next webPage loads and element to be clickable
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
	}
	
	@Test(priority=6)
	public void invalidLoginTest() throws InterruptedException {
		//login with valid userName and inValid password
		
		LoginPage loginPage =new LoginPage(driver);
		
		loginPage.typeUserName("standard_user");
		loginPage.typePassword("12345");
		loginPage.clickLoginButton();
		Thread.sleep(500);
		
		/*creates variable for errorMessage that appears after failed login and verify that actual error message
		 * matches expected one and finally print the errorMessage
		 */
		String errorMessage=driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
		System.out.println(errorMessage);
	}
	
	@Test(priority=5)
	public void logoutTest() {
		
		HomePage homePage= new HomePage(driver);
		
		//click on side bar and click in logOut
		homePage.clickOnSideBar();
		homePage.logOut();
	
	}
	
	@Test(priority=2)
	public void addProductToCartTest() throws InterruptedException {
		
		HomePage homePage =new HomePage(driver);
		
		//add backpack to cart
		homePage.addItemToCart("add-to-cart-sauce-labs-backpack");
		
		CartPage cartPage=new CartPage(driver);
		
		//clicks on cart icon and then click on continue shopping to add more products to cart
		cartPage.clickOnCartIcon();
		Thread.sleep(500);
	 	//explicit wait till the next webPage loads and checkout element is clickable
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        
		cartPage.continueShopping();
		Thread.sleep(500);
		
		//add another item(onesie)
		homePage.addItemToCart("add-to-cart-sauce-labs-onesie");
		
		//heads again to cart page to view products after adding another product
		cartPage.clickOnCartIcon();
		Thread.sleep(500);

	}
	
	@Test(priority=4)
	public void verifyCheckoutErrorOnMissingInfo() throws InterruptedException {
		
		CheckOutPage checkOutPage=new CheckOutPage(driver);
	    CartPage cartPage=new CartPage(driver);
		
		//clicks on cart icon to head to cartPage
		cartPage.clickOnCartIcon();
		Thread.sleep(500);
		
		//go to checkout page and dont add all the required info(firstName,lastName,postalCode)
		checkOutPage.goToCheckoutPage();
		Thread.sleep(500);
		checkOutPage.clickContinue();
		Thread.sleep(500);

		
		/*verifies that proceeding to last process of products purchase without giving all required
		info generates and error and validates the error*/
		String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		Assert.assertEquals(errorMessage, "Error: First Name is required");
		System.out.println(errorMessage);	
	}
	
	
	@Test(priority=3)
	public void completeProductPurchase() throws InterruptedException{
		
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		
		//go to checkout page and add required details and then finish products purchase
		checkOutPage.goToCheckoutPage();
		Thread.sleep(500);
		checkOutPage.enterFirstName("Hazem");
		checkOutPage.enterLastName("Ahmed");
		checkOutPage.enterPostalCode("00000");
		Thread.sleep(500);
		checkOutPage.clickContinue();
		checkOutPage.clickOnFinish();
		Thread.sleep(500);

		//verify that a thank you message appears after finishing the purchase process and prints the message on console
		String confirmationMessage=driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		Assert.assertEquals(confirmationMessage, "Thank you for your order!");
		System.out.println(confirmationMessage);
		
		//return to the homePage
		checkOutPage.returnToHomePage();
		Thread.sleep(500);
	}
	

}
