package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public interface constants {
	 String BASE_URL = "https://magento.softwaretestingboard.com/";
	 String DRIVER_PATH = "drivers/chromedriver"; 
	public  WebDriver driver = new ChromeDriver();
}
