package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import data.DataMapper;
import libs.Common;
import manager.DriverManager;

public class ManufacturingPage {

	WebDriver driver;
	@FindBy(css = "[class*='o_list_button_add']")
	private static WebElement btnCreate;
	
	@FindBy(css = "[name='product_id'] input[type='text']")
	private static WebElement inputProduct;
	
	@FindBy(css = "[class*='button_save']")
	private static WebElement btnSave;
	
	@FindBy(css = "[name='action_confirm']")
	private static WebElement btnConfirm;
	
	@FindBy(css = "button[name='button_mark_done']:not([class*='invisible'])")
	private static WebElement btnMarkAsDone;
	
	@FindBy(xpath = "//*[@class='modal-dialog']//*[text()='Ok']")
	private static WebElement btnOk;
	
	@FindBy(css = "[class*='modal-dialog'] button[name='process']")
	private static WebElement btnApply;
	
	@FindBy(xpath = "//a[@name='product_id']")
	private static WebElement lblProduct;
	
	public ManufacturingPage() {
		this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
	}
	
	public ManufacturingPage clickCreateBtn() {
		new Common().waitElement(btnCreate);
		btnCreate.click();
		return this;
	}
	
	public ManufacturingPage fillProduct() {
		new Common().waitElement(inputProduct);
		inputProduct.sendKeys(DataMapper.mapData("productName"));
		inputProduct.sendKeys(Keys.ENTER);
		return this;
	}
	
	public ManufacturingPage clickSaveBtn() {
		new Common().waitElement(btnSave);
		btnSave.click();
		return this;
	}
	
	public ManufacturingPage clickConfirmBtn() {
		new Common().waitElement(btnConfirm);
		btnConfirm.click();
		return this;
	}
	
	public ManufacturingPage clickMarkAsDoneBtn() {
		new Common().waitElement(btnMarkAsDone);
		btnMarkAsDone.click();
		new Common().implicitWait(1000);
		if (btnOk.isDisplayed()) {
			btnOk.click();
		}
		new Common().waitElement(btnApply);
		if (btnApply.isDisplayed()) {
			btnApply.click();
		}
		return this;
	}
	
	public ManufacturingPage createNewOrder() {
		clickCreateBtn();
		fillProduct();
		clickSaveBtn();
		return this;
	}
	
	public ManufacturingPage verifyInformationCorrect() {
		new Common().waitElement(lblProduct);
		String actual = lblProduct.getText();
		String expected = DataMapper.mapData("productName");
		Assert.assertEquals(actual, expected,
				"Verify that product is correct. Actual: [" + actual + "] - Expected: [" + expected + "]");
		return this;
	}
	
}
