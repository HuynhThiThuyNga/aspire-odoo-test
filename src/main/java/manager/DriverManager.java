package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver pdriver;
	
	public static void start() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		setDriver(driver);
	}
	
	public static void closeDriver() {
		pdriver.quit();
	}
	
	public static WebDriver getDriver() {
		return pdriver;
	}
	
	public static void setDriver(WebDriver driver) {
		pdriver = driver;
	}
	

}
