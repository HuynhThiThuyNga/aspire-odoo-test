package tests;

import org.testng.annotations.Test;

import data.DataMapper;
import data.InjectData;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ManufacturingPage;

public class TestDemo{
	@InjectData(json = "./data/test-Demo.json")
	@Test(enabled = true)
	public void testDemo1() {
		LoginPage loginPage = new LoginPage();
		loginPage.openOdooPage(DataMapper.mapData("baseUrl")).loginAccount();
		HomePage homePage = new HomePage();
		homePage.openInventoryFeature();
		InventoryPage inventoryPage = new InventoryPage();
		inventoryPage.openProductsItems().createNewProduct().updateQuantity().clickApplicationIcon();
		homePage.openManufatoringFeature();
		ManufacturingPage manufacturingPage = new ManufacturingPage();
		manufacturingPage.createNewOrder().clickConfirmBtn().clickMarkAsDoneBtn().verifyInformationCorrect();
	}

}
