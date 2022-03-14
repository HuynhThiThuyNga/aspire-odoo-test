package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import libs.Common;
import manager.DriverManager;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//a[starts-with(@id,'result_app_')]//*[@class='o_caption' and contains(text(),'Inventory')]")
	private static WebElement tabInventory;
	
	@FindBy(xpath = "//a[starts-with(@id,'result_app_')]//*[@class='o_caption' and contains(text(),'Manufacturing')]")
	private static WebElement tabManufatoring;

	public HomePage() {
		this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
	}
	
	public HomePage openInventoryFeature() {
		new Common().waitElement(tabInventory);
		tabInventory.click();
		return this;
	}
	
	public HomePage openManufatoringFeature() {
		new Common().waitElement(tabManufatoring);
		tabManufatoring.click();
		return this;
	}
	
}
