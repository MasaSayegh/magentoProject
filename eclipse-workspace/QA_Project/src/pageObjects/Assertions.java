package pageObjects;

import org.openqa.selenium.By;

import junit.framework.Assert;
import support.constants;

public class Assertions  implements constants{

public void checkSuccessfulCheckOut() {
	String title="Thank you for your purchase!";
	Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText(), title);
	System.out.println("Assertion done");
	////*[@id="maincontent"]/div[1]/h1/span
}
}
