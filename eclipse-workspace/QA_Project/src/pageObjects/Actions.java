package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import support.constants;

public class Actions implements constants {

	public void openMagnto() {
		driver.manage().window().maximize();
		driver.get(BASE_URL);

	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void closeBrowser() {
		driver.close();
	}

	// search shirt
	public void typeInSearchInputField(String productName) {
		driver.findElement(By.id("search")).sendKeys(productName + Keys.ENTER);

	}

	// click on random product
	public void clickOnProduct(String productName) {
		driver.findElement(By.linkText(productName)).click();
	}

	public void selectProductByIndex(int index) {
		// driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/strong/a")).click();
		// WebElement dropdown =
		// driver.findElement(By.cssSelector("#maincontent > div.columns >
		// div.column.main > div.search.results >
		// div.products.wrapper.grid.products-grid > ol > li:nth-child(3) > div > a >
		// span > span > img")).click();
		// Select dropdownElements = new Select(dropdown);
		// dropdownElements.selectByIndex(index);
//      dropdownElements.selectByValue("position");
//		dropdownElements.selectByVisibleText("Price");
		List<WebElement> products = driver.findElements(By.cssSelector(".product-item a.product-item-link"));
		products.get(index).click();
	}

	public void selectProductSize(String size) {
		try {
			// Select size if available
			if (size != null && !size.isEmpty()) {
				// System.out.println("size " + size);
				String xxpath = "//div[@class='swatch-option text' and @option-label='" + size + "']";
				WebElement sizeOption = driver.findElement(By.xpath(xxpath));
				// driver.findElement(By.id("option-label-size-143-item-169"));
				//
				sizeOption.click();
				// System.out.println("size option found for: " + size);
			}
		} catch (NoSuchElementException e) {
			System.out.println("No size option found for: " + size);
		}

	}

	public void selectProductColor(String color) {
		try {
			// Select color if available
			if (color != null && !color.isEmpty()) {
				WebElement colorOption = driver.findElement(By.id("option-label-color-93-item-52"));
				// driver.findElement(By.xpath("//div[@id='option-label-color-93']//div[@option-label='"
				// + color + "']"));
				colorOption.click();
				// System.out.println("color option found for: " + color);
			}
		} catch (NoSuchElementException e) {
			System.out.println("No color option found for: " + color);

		}
	}

	public void clickAddToCart() {
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
		// System.out.println("add to cart id ok");
	}

	public void clickShoppingCart() {
		driver.findElement(By.className("showcart")).click();
		;
	}

	public void clickCheckoutProceed() {
		try {
			driver.findElement(By.cssSelector(".action.primary.checkout")).click();
			// System.out.println("Clicked on Proceed to Checkout");
		} catch (Exception e) {
			System.out.println("Checkout button not found: " + e.getMessage());
		}
	}

	// random email
	private String generateRandomEmail() {
		String unique = java.util.UUID.randomUUID().toString().substring(0, 6);
		return "test_" + unique + "@gmail.com";
	}

	// order form
	public void insertEmail() {
		String email = generateRandomEmail();
		driver.findElement(By.id("customer-email")).sendKeys(email);

		//
	}
	/*
	 * public void insertPassword() {
	 * driver.findElement(By.id("customer-password")).sendKeys(); }
	 */

	public void insertName(String firstName, String lastName) {
		// first name
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		// Last name
		driver.findElement(By.name("lastname")).sendKeys(lastName);
	}

	public void insertAddress(String address, String city) {
		// Country
		driver.findElement(By.name("country_id")).sendKeys("Palestinian Territories");
		// street Address
		driver.findElement(By.name("street[0]")).sendKeys(address);
		// city
		driver.findElement(By.name("city")).sendKeys(city);

		driver.findElement(By.name("postcode")).sendKeys("00970");
		driver.findElement(By.name("telephone")).sendKeys("0599000000");
		// driver.findElement(By.name("ko_unique_5")).click();
		// System.out.println("address done");

	}

	public void clickNext() {
		// System.out.println("before click next");
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		// System.out.println("click next");

	}

	public void clickPlaceOrder() {
		driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
	}

	public void getOrderNumber() {
		// WebElement orderNumber =
		// driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/span"));
		// System.out.println("Order Number is :"+ orderNumber);
		WebElement orderNumber = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/span"));
		System.out.println("Order Number is: " + orderNumber.getText());
	}

}
