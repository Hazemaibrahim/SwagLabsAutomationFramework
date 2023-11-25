package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.BaseTest;

public class CartPage extends BaseTest {

	WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver=driver;
	}

	public void clickOnCartIcon() {
		//head to the CartPage by clicking on the cart icon

		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

	}
	
	public void continueShopping() {
		//resume shopping and add other products to cart
		
		driver.findElement(By.name("continue-shopping")).click();
	}

}
