package Tests;

import static JsonDataDriven.JsonData.getJsonData;
import static Pages.P0_HomePage.*;
import static Pages.P4_AllProductsPage.*;
import static Pages.P5_ProductDetailsPage.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.BaseTest;
import coreElements.Utility;

public class AddingItemsToCart extends BaseTest{
	
	@BeforeMethod(alwaysRun=true)
	public void NavigateToHomePage()
	{
		HomePage.Click();
	}
	
	@DataProvider
	public Object[][] ItemsAddedToCart() throws IOException
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//java//resources//JsonData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(2) }   } ;
	}
	@Test(dataProvider="ItemsAddedToCart",  groups={"Smoke"})
	public void AddItemsToCart(HashMap<String,String> input)
	{
		ProductsPage.Click();
		Utility.AddToCart(input.get("FirstItem"));
		Assert.assertTrue(VerifyProductAdded.GetText().contains(input.get("AddedSuccessfullyMessage")));
		ContinueShopping.Click();
		Utility.AddToCart(input.get("SecondItem"));
		Assert.assertTrue(VerifyProductAdded.GetText().contains(input.get("AddedSuccessfullyMessage")));
		ContinueShopping.Click();
	}
	
	@DataProvider
	public Object[][] ProductDetails() throws IOException
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//java//resources//JsonData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(2) }   } ;
	}
	@Test(dataProvider="ProductDetails",  groups={"Smoke"})
	public void CheckingProductDetails(HashMap<String,String> input)
	{
		ProductsPage.Click();
		Utility.AddToCart(input.get("FirstItem"));
		Assert.assertTrue(VerifyProductAdded.GetText().contains(input.get("AddedSuccessfullyMessage")));
		ContinueShopping.Click();
	    Utility.ViewProduct(input.get("FirstItem"));
	    Assert.assertTrue(VerifyProductName.GetText().contains(input.get("FirstItem")));
	}
	@Test(dataProvider="ProductDetails",  groups={"Smoke"})
	public void CheckingSearchFunctionality(HashMap<String,String> input)
	{
		ProductsPage.Click();
		SearchProduct.Type(input.get("SearchProduct"));
		Search.Click();
		Assert.assertTrue(ProductNames.GetTextFromList().contains(input.get("SearchProduct")));
	}


}
