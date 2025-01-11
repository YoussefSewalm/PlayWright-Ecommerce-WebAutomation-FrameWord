package Tests;

import static JsonDataDriven.JsonData.getJsonData;
import static Pages.P0_HomePage.*;
import static Pages.P1_AccountPage.*;
import static Pages.P2_SignUpPage.*;
import static Pages.P3_AccountCreated.*;
import static Pages.P4_AllProductsPage.*;
import static Pages.P5_ProductDetailsPage.*;
import static Pages.P6_CartPage.*;
import static Pages.P7_CheckOutPage.*;
import static Pages.P8_PaymentPage.*;
import static Pages.P9_OrderPlaced.*;
import static coreElements.Utility.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import TestBase.BaseTest;
import coreElements.Utility;

public class PurchaseTests extends BaseTest{
	
	String RandomSignUpName = GetRandomSignUpName();
	String RandomSignUpFirstName = GetRandomSignUpFirstName();
	String RandomCompanyName = GetRandomCompanyName();
	String RandomFirstAddress = GetRandomFirstAddress();
	String RandomSecondAddress = GetRandomSecondAddress();
	String RandomZipCode = GetRandomZipCode();
	String RandomMobileNumber = GetRandomMobileNumber();

	
	@DataProvider
	public Object[][] PurchasedItems() throws IOException
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//java//resources//JsonData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(2) }   } ;
	}
	@Test(dataProvider="PurchasedItems",  groups={"Regression"} )
	public void FullPurchaseProcessAlreadyLogin(HashMap<String,String> input)
	{
		LoginSignUp.Click();
		LoginEmail.Type(input.get("LoginEmail"));
		LoginPassword.Type(input.get("LoginPassword"));
		Login.Click();
		Assert.assertTrue(VerifyLoggedIn.GetText().contains("Logged in as"));
		ProductsPage.Click();
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
        ProceedToCheckOut.Click();
        Assert.assertEquals(VerifyAllProductsPrice.ConvertStringToDouble(),Utility.CalculateTotalCartItemsPrice());
        Assert.assertTrue(Utility.GetNameFromCheckOutDetails(input.get("Name")).contains(input.get("Name")));
        Assert.assertTrue(Utility.GetCompanyNameFromCheckOutDetails(input.get("Company")).contains(input.get("Company")));
        Assert.assertTrue(Utility.GetFirstAddressFromCheckOutDetails(input.get("Address_1")).contains(input.get("Address_1")));
        Assert.assertTrue(Utility.GetSecondAddressFromCheckOutDetails(input.get("Address_2")).contains(input.get("Address_2")));
        Assert.assertTrue(Utility.GetZipCodeFromCheckOutDetails(input.get("ZipCode")).contains(input.get("ZipCode")));
        Assert.assertTrue(Utility.GetPhoneNumberFromCheckOutDetails(input.get("MobileNumber")).contains(input.get("MobileNumber")));
        PlaceOrder.Click();
        Assert.assertTrue(VerifyPaymentPage.GetText().contains("Payment"));
        Utility.FillPaymentDetails(GetRandomCreditName(), GetRandomCreditNumber(), GetRandomCVC(), 
        		GetRandomExpirationMonth(), 
        		GetRandomExpirationYear()
        		);
        
        PayAndConfirmOrder.Click();
        Assert.assertTrue(VerifyOrderPlaced.GetText().contains("Placed!"));
        DownloadInVoice.DownloadAndSaveFile();
        LogOut.Click();
	}
	
	@Test(dataProvider="PurchasedItems",  groups={"Regression"})
	public void FullPurchaseProcessNotLoggedIn(HashMap<String,String> input)
	{
		ProductsPage.Click();
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
        ProceedToCheckOut.Click();
        RegisterOrLoginFromCheckOut.Click();
		LoginSignUp.Click();
		LoginEmail.Type(input.get("LoginEmail"));
		LoginPassword.Type(input.get("LoginPassword"));
		Login.Click();
		Assert.assertTrue(VerifyLoggedIn.GetText().contains("Logged in as"));
		CartPage.Click();
		ProceedToCheckOut.Click();
        Assert.assertEquals(VerifyAllProductsPrice.ConvertStringToDouble(),Utility.CalculateTotalCartItemsPrice());
        Assert.assertTrue(Utility.GetNameFromCheckOutDetails(input.get("Name")).contains(input.get("Name")));
        Assert.assertTrue(Utility.GetCompanyNameFromCheckOutDetails(input.get("Company")).contains(input.get("Company")));
        Assert.assertTrue(Utility.GetFirstAddressFromCheckOutDetails(input.get("Address_1")).contains(input.get("Address_1")));
        Assert.assertTrue(Utility.GetSecondAddressFromCheckOutDetails(input.get("Address_2")).contains(input.get("Address_2")));
        Assert.assertTrue(Utility.GetZipCodeFromCheckOutDetails(input.get("ZipCode")).contains(input.get("ZipCode")));
        Assert.assertTrue(Utility.GetPhoneNumberFromCheckOutDetails(input.get("MobileNumber")).contains(input.get("MobileNumber")));
        PlaceOrder.Click();
        Assert.assertTrue(VerifyPaymentPage.GetText().contains("Payment"));
        Utility.FillPaymentDetails(GetRandomCreditName(), GetRandomCreditNumber(), GetRandomCVC(), 
        		GetRandomExpirationMonth(), 
        		GetRandomExpirationYear()
        		);
        
        PayAndConfirmOrder.Click();
        Assert.assertTrue(VerifyOrderPlaced.GetText().contains("Placed!"));
        DownloadInVoice.DownloadAndSaveFile();
        LogOut.Click();
	}
	
	
	@DataProvider
	public Object[][] PurchasedItems_Reg() throws IOException
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//java//resources//JsonData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(3) }   } ;
	}
	
	@Test(dataProvider="PurchasedItems_Reg",  groups={"Regression"})
	public void FullPurchaseProcessNotRegistered(HashMap<String,String> input)
	{
		ProductsPage.Click();
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
        ProceedToCheckOut.Click();
        RegisterOrLoginFromCheckOut.Click();
		LoginSignUp.Click();
		RegisterName.Type(GetRandomRegisterName());
		RegisterEmail.Type(GetRandomEmailAddress());
		SignUp.Click();
		Male.Check();
		SignUpName.Type(RandomSignUpName);
		SignUpPassword.Type(GetRandomPassword());
		Days.Select(GetRandomDayOfBirth());
		Months.Select(GetRandomMonthOfBirth());
		Years.Select(GetRandomYearOfBirth());
		NewsLetter.Check();
		SpecialOffers.Check();
		SignUpFirstName.Type(RandomSignUpFirstName);
		SignUpLastName.Type(GetRandomSignUpLastName());
		SignUpCompany.Type(RandomCompanyName);
		SignUpFirstAddress.Type(RandomFirstAddress);
		SignUpSecondAddress.Type(RandomSecondAddress);
		Countries.Select(GetRandomCountryName());
		SignUpState.Type(GetRandomStateName());
		SignUpCity.Type(GetRandomCityName());
		SignUpZipCode.Type(RandomZipCode);
		SignUpMobileNumber.Type(RandomMobileNumber);
		CreateAccount.Click();
		Assert.assertTrue(VerifyAccountCreated.GetText().contains("Account Created!"));
		CartPage.Click();
		ProceedToCheckOut.Click();
        Assert.assertEquals(VerifyAllProductsPrice.ConvertStringToDouble(),Utility.CalculateTotalCartItemsPrice());
        Assert.assertEquals(VerifyAllProductsPrice.ConvertStringToDouble(),Utility.CalculateTotalCartItemsPrice());
        Assert.assertTrue(Utility.GetNameFromCheckOutDetails(RandomSignUpFirstName).contains(RandomSignUpFirstName));
        Assert.assertTrue(Utility.GetCompanyNameFromCheckOutDetails(RandomCompanyName).contains(RandomCompanyName));
        Assert.assertTrue(Utility.GetRandomFirstAddressFromCheckOutDetails(RandomFirstAddress).contains(RandomFirstAddress));
        Assert.assertTrue(Utility.GetRandomSecondAddressFromCheckOutDetails(RandomSecondAddress).contains(RandomSecondAddress));
        Assert.assertTrue(Utility.GetZipCodeFromCheckOutDetails(RandomZipCode).contains(RandomZipCode));
        Assert.assertTrue(Utility.GetPhoneNumberFromCheckOutDetails(RandomMobileNumber).contains(RandomMobileNumber));
        PlaceOrder.Click();
        Assert.assertTrue(VerifyPaymentPage.GetText().contains("Payment"));
        Utility.FillPaymentDetails(GetRandomCreditName(), GetRandomCreditNumber(), GetRandomCVC(), 
        		GetRandomExpirationMonth(), 
        		GetRandomExpirationYear()
        		);
        
        PayAndConfirmOrder.Click();
        Assert.assertTrue(VerifyOrderPlaced.GetText().contains("Placed!"));
        DownloadInVoice.DownloadAndSaveFile();
        DeleteAccount.Click();
	}
	

}
