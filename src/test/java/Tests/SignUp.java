package Tests;

import static Pages.P0_HomePage.*;
import static Pages.P1_AccountPage.*;
import static Pages.P2_SignUpPage.*;
import static Pages.P3_AccountCreated.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static coreElements.Utility.*;
import TestBase.BaseTest;

public class SignUp extends BaseTest {
	
	String RandomEmailAddress = GetRandomEmailAddress();
	String RandomRegisterName = GetRandomRegisterName();
	String RandomSignUpName = GetRandomSignUpName();
	String RandomPassword = GetRandomPassword();

	
	@BeforeMethod(alwaysRun=true)
	public void NavigateToHomePage()
	{
		HomePage.Click();
	}

	@Test( groups={"Smoke"} )
	public void ValidSignUpThenDelete()
	{
		LoginSignUp.Click();
		RegisterName.Type(RandomRegisterName);
		RegisterEmail.Type(RandomEmailAddress);
		SignUp.Click();
		Male.Check();
		SignUpName.Type(RandomSignUpName);
		SignUpPassword.Type(RandomPassword);
		Days.Select(GetRandomDayOfBirth());
		Months.Select(GetRandomMonthOfBirth());
		Years.Select(GetRandomYearOfBirth());
		NewsLetter.Check();
		SpecialOffers.Check();
		SignUpFirstName.Type(GetRandomSignUpFirstName());
		SignUpLastName.Type(GetRandomSignUpLastName());
		SignUpCompany.Type(GetRandomCompanyName());
		SignUpFirstAddress.Type(GetRandomFirstAddress());
		SignUpSecondAddress.Type(GetRandomSecondAddress());
		Countries.Select(GetRandomCountryName());
		SignUpState.Type(GetRandomStateName());
		SignUpCity.Type(GetRandomCityName());
		SignUpZipCode.Type(GetRandomZipCode());
		SignUpMobileNumber.Type(GetRandomMobileNumber());
		CreateAccount.Click();
		Assert.assertTrue(VerifyAccountCreated.GetText().contains("Account Created!"));
		ContinueToHomePage.Click();
		Assert.assertTrue(VerifyLoggedIn.GetText().contains("Logged in as"));
		DeleteAccount.Click();
	}
	@Test( groups={"Regression"} )
	public void InvalidRegisterUsingAlreadyRegisteredEmail()
	{
		LoginSignUp.Click();
		RegisterName.Type(RandomRegisterName);
		RegisterEmail.Type("w4rior44300@gmail.com");
		SignUp.Click();
		Assert.assertTrue(VerifyRegisterationFail.GetText().contains("exist"));
	}
	

}
