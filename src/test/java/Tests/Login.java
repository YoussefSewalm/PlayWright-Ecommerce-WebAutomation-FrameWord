package Tests;

import static Pages.P0_HomePage.*;
import static Pages.P1_AccountPage.*;
import static JsonDataDriven.JsonData.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.BaseTest;

public class Login extends BaseTest{
	
	@BeforeMethod(alwaysRun=true)
	public void NavigateToHomePage()
	{
		HomePage.Click();
	}
	@DataProvider
	public Object[][] getValidLoginData() throws IOException
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//java//resources//JsonData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(0) }   } ;
	}
	@Test(dataProvider="getValidLoginData",  groups={"Smoke"})
	public void ValidLogin(HashMap<String,String> input)
	{
		LoginSignUp.Click();
		LoginEmail.Type(input.get("LoginEmail"));
		LoginPassword.Type(input.get("LoginPassword"));
		Login.Click();
		Assert.assertTrue(VerifyLoggedIn.GetText().contains("Logged in as"));
	}
	@DataProvider
	public Object[][] getInValidLoginData() throws IOException
	{
	    String jsonFilePath = System.getProperty("user.dir") + "//src//test//java//resources//JsonData.json";
	    List<HashMap<String,String>> data = getJsonData(jsonFilePath);
	    return new Object[][] {   { data.get(1) }   } ;
	}
	@Test(dataProvider="getInValidLoginData",  groups={"Regression"})
	public void InValidLogin(HashMap<String,String> input)
	{
		LoginSignUp.Click();
		LoginEmail.Type(input.get("LoginEmail"));
		LoginPassword.Type(input.get("LoginPassword"));
		Login.Click();
		Assert.assertTrue(VerifyLoginFail.GetText().contains("incorrect"));
	}

}
