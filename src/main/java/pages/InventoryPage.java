package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import data.DataMapper;
import libs.Common;
import manager.DriverManager;

public class InventoryPage {
	WebDriver driver;
	@FindBy(xpath = "//a[starts-with(@id,'result_app_')]//*[@class='o_caption' and contains(text(),'Inventory')]")
	private static WebElement tabInventory;
	
	@FindBy(css = "[title='Products']")
	private static WebElement tabmenuProducts;
	
	@FindBy(css = "[data-menu-xmlid*='menu_product_variant_config_stock']")
	private static WebElement tabitemsProducts;
	
	@FindBy(css = "[class*='button-new']")
	private static WebElement btnCreateProduct;
	
	@FindBy(css = "[name='name']")
	private static WebElement inputProductName;
	
	@FindBy(css = "[class*='button_save']")
	private static WebElement btnSave;
	
	@FindBy(css = "button[name='action_update_quantity_on_hand']")
	private static WebElement btnUpdateQuantity;
	
	@FindBy(css = "[class*='o_list_button_add']")
	private static WebElement btnCreateQuantity;
	
	@FindBy(css = "[name='inventory_quantity']")
	private static WebElement inputQuantity;
	
	@FindBy(css = "[class*='o_menu_toggle']")
	private static WebElement iconApplication;

	public InventoryPage() {
		this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
	}
	
	public InventoryPage openProductsItems() {
		new Common().waitElement(tabmenuProducts);
		tabmenuProducts.click();
		tabitemsProducts.click();
		return this;
	}
	
	public InventoryPage clickCreateProductBtn() {
		new Common().waitElement(btnCreateProduct);
		btnCreateProduct.click();
		return this;
	}
	
	public InventoryPage fillProductName() {
		new Common().waitElement(inputProductName);
		String name = DataMapper.mapData("productName") + System.currentTimeMillis();
		inputProductName.sendKeys(name);
		DataMapper.updateData("productName", name);
		return this;
	}
	
	public InventoryPage clickSaveBtn() {
		new Common().waitElement(btnSave);
		btnSave.click();
		return this;
	}
	
	public InventoryPage createNewProduct() {
		clickCreateProductBtn();
		fillProductName();
		clickSaveBtn();
		return this;
	}
	
	public InventoryPage clickUpdateQuantityBtn() {
		new Common().implicitWait(1000);
		new Common().waitElement(btnUpdateQuantity);
		btnUpdateQuantity.click();
		return this;
	}
	
	public InventoryPage clickCreateQuantityBtn() {
		new Common().waitElement(btnCreateQuantity);
		btnCreateQuantity.click();
		return this;
	}
	
	public InventoryPage fillQuantityNum() {
		new Common().waitElement(inputQuantity);
		new Common().implicitWait(1000);
		inputQuantity.click();
		inputQuantity.clear();
		inputQuantity.sendKeys(DataMapper.mapData("quantity"));
		inputQuantity.sendKeys(Keys.ENTER);
		return this;
	}
	
	public InventoryPage updateQuantity() {
		clickUpdateQuantityBtn();
		clickCreateQuantityBtn();
		fillQuantityNum();
		clickSaveBtn();
		return this;
	}
	
	public InventoryPage clickApplicationIcon() {
		new Common().waitElement(iconApplication);
		iconApplication.click();
		return this;
	}
}
