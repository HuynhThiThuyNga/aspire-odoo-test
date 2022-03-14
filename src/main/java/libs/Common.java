package libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import manager.DriverManager;

public class Common {
	WebDriver driver;
	
	public Common() {
		this.driver = DriverManager.getDriver();
	}
	
	public void waitElement(WebElement element) {
		implicitWait(2000);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void implicitWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
