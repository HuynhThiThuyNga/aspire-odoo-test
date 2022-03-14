package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import data.DataMapper;
import libs.Common;
import manager.DriverManager;

public class LoginPage {
	WebDriver driver;
	@FindBy(css = "input#login")
	private static WebElement inputEmail;
	
	@FindBy(css = "input#password")
	private static WebElement inputPassword;
	
	@FindBy(css = "button[type='submit']")
	private static WebElement btnLogIn;
	
	public LoginPage() {
		this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
	}

	public LoginPage openOdooPage(String baseUrl) {
		driver.manage().window().maximize();
		driver.get(baseUrl);
		return this;
	}
	
	public LoginPage loginAccount() {
		new Common().waitElement(inputEmail);
		inputEmail.sendKeys(DataMapper.mapData("userName"));
		
		inputPassword.sendKeys(DataMapper.mapData("passWord"));
		
		btnLogIn.click();
		return this;
	}
}
