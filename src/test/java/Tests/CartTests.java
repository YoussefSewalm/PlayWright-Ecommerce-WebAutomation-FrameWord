package Tests;

import static JsonDataDriven.JsonData.getJsonData;
import static Pages.P0_HomePage.*;
import static Pages.P4_AllProductsPage.*;
import static Pages.P5_ProductDetailsPage.*;
import static Pages.P6_CartPage.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.BaseTest;
import coreElements.Utility;

public class CartTests extends BaseTest{
	
	@BeforeMethod(alwaysRun=true)
	public void NavigateToProductsPage()
	{
		ProductsPage.Click();
	}
	@DataProvider
	public Object[][] PurchasedItems() throws IOException
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//java//resources//JsonData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(2) }   } ;
	}
	@Test(dataProvider="PurchasedItems",dependsOnMethods= {"CheckingRemoveItemsFromCart"}, groups={"Smoke"})
	public void CheckingItemsPrices(HashMap<String,String> input)
	{
	    Utility.ViewProduct(input.get("FirstItem"));
	    Assert.assertTrue(VerifyProductName.GetText().contains(input.get("FirstItem")));
	    ProductQuantity.Type(input.get("FirstItemQuantity"));
	    AddToCart.Click();
	    ContinueShopping.Click();
	    ProductsPage.Click();
	    Utility.ViewProduct(input.get("SecondItem"));
	    Assert.assertTrue(VerifyProductName.GetText().contains(input.get("SecondItem")));
	    ProductQuantity.Type(input.get("SecondItemQuantity"));
	    AddToCart.Click();
	    ContinueShopping.Click();
	    CartPage.Click();
	    Assert.assertTrue(Utility.GetItemQuantity(input.get("FirstItem")).contains( input.get("FirstItemQuantity")));
	    Assert.assertTrue(Utility.GetItemQuantity(input.get("SecondItem")).contains( input.get("SecondItemQuantity")));
        Assert.assertEquals(Utility.GetTotalPriceForItem(input.get("FirstItem")), Utility.CalculateTotalPriceForItem(input.get("FirstItem")));
        Assert.assertEquals(Utility.GetTotalPriceForItem(input.get("SecondItem")), Utility.CalculateTotalPriceForItem(input.get("SecondItem")));
        ProceedToCheckOut.Click(); 
	}
	
	@DataProvider
	public Object[][] ItemDetails() throws IOException
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//java//resources//JsonData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(2) }   } ;
	}
	@Test(dataProvider="ItemDetails",  groups={"Smoke"})
	public void CheckingRemoveItemsFromCart(HashMap<String,String> input)
	{
	    Utility.ViewProduct(input.get("FirstItem"));
	    Assert.assertTrue(VerifyProductName.GetText().contains(input.get("FirstItem")));
	    ProductQuantity.Type(input.get("FirstItemQuantity"));
	    AddToCart.Click();
	    ContinueShopping.Click();
	    CartPage.Click();
	    Assert.assertTrue(Utility.GetItemQuantity(input.get("FirstItem")).contains( input.get("FirstItemQuantity")));
        Assert.assertEquals(Utility.GetTotalPriceForItem(input.get("FirstItem")), Utility.CalculateTotalPriceForItem(input.get("FirstItem")));
        Utility.RemoveItemFromCart(input.get("FirstItem"));
        Assert.assertTrue(VerifyEmptyCart.GetText().contains(input.get("EmptyCartMessage")));
	}

}
