package main;

//import org.junit.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;
import support.LoggerHelper;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.chrome.ChromeDriver;
@Listeners(support.extentReportClass.class)
public class testCase {
	WebDriver driver;
	Actions action = new Actions();
	Assertions assertion = new Assertions();
	String size = "XXL";
	String color = "Gray";
	String firstName = "Name test1";
	String lastName = "LastNametest";
	String street = "street";
	String city = "nablus";

	@BeforeSuite
	public void myBeforeTest() {
		// driver = new ChromeDriver();
		// 1
		action.openMagnto();

	}

	@Test(description = "Checkout Test Case")
	public void myTest() throws InterruptedException {
		// driver.get("https://magento.softwaretestingboard.com/");
		// driver.findElement(By.id("Seacrh"));
		// Thread.sleep(1000);
		// 2
		action.typeInSearchInputField("shirt");
		LoggerHelper.log(Status.INFO, "Searched for shirt");
		// 3
		Thread.sleep(1000);
		action.selectProductByIndex(2);
		LoggerHelper.log(Status.INFO, "Product index 2 selected");
		// 4
		Thread.sleep(2000);
		action.selectProductSize(size);
		LoggerHelper.log(Status.INFO, "Product size selected: " + size);
		Thread.sleep(100);
		action.selectProductColor(color);
		LoggerHelper.log(Status.INFO, "Product color selected: " + color);
		// 5
		Thread.sleep(1000);
		action.clickAddToCart();
		LoggerHelper.log(Status.INFO, "Product added to cart");
		// 6
		Thread.sleep(3000);
		action.clickShoppingCart();
		LoggerHelper.log(Status.INFO, "Opened shopping cart");
		// 7
		Thread.sleep(2000);
		action.clickCheckoutProceed();
		LoggerHelper.log(Status.INFO, "Proceeded to checkout");
		Thread.sleep(3000);
		// 8 fill in all the required fields. email random
		action.insertEmail();
		LoggerHelper.log(Status.INFO, "Inserted random email");
		Thread.sleep(2000);
		action.insertName(firstName, lastName);
		LoggerHelper.log(Status.INFO, "Inserted name: " + firstName + " " + lastName);
		Thread.sleep(3000);
		action.insertAddress(street, city);
		LoggerHelper.log(Status.INFO, "Inserted address");
		Thread.sleep(3000);
		action.clickNext();
		Thread.sleep(3000);
		// 9 complete checkout
		action.clickPlaceOrder();
		LoggerHelper.log(Status.INFO, "Placed the order");
		// 10 print order number
		Thread.sleep(4000);
		action.getOrderNumber();
		LoggerHelper.log(Status.INFO, "Fetched the order number");
		Thread.sleep(4000);
		assertion.checkSuccessfulCheckOut();
		LoggerHelper.log(Status.INFO, "Checked successful checkout");

	}

	@AfterSuite
	public void myAfterTest() {
		// 11 close browser
		action.closeBrowser();

	}

}
