package Pages;

import static Locators.L2_SignUpPage.*;

import coreElements.*;

public class P2_SignUpPage {
	
    //Texts
    public static Texts VerifySignUpPage = new Texts(VerifySignUpPageText);

	//Links


	//Buttons
	public static Buttons CreateAccount = new Buttons(CreateAccountButton);

	
	//FormFields
    public static FormFields SignUpName = new FormFields(SignUpNameFormField);
    public static FormFields SignUpPassword = new FormFields(SignUpPasswordFormField);
    public static FormFields SignUpFirstName = new FormFields(SignUpFirstNameFormField);
    public static FormFields SignUpLastName = new FormFields(SignUpLastNameFormField);
    public static FormFields SignUpCompany = new FormFields(SignUpCompanyFormField);
    public static FormFields SignUpFirstAddress = new FormFields(SignUpFirstAddressFormField);
    public static FormFields SignUpSecondAddress = new FormFields(SignUpSecondAddressFormField);
    public static FormFields SignUpState = new FormFields(SignUpStateFormField);
    public static FormFields SignUpCity = new FormFields(SignUpCityFormField);
    public static FormFields SignUpZipCode = new FormFields(SignUpZipCodeFormField);
    public static FormFields SignUpMobileNumber = new FormFields(SignUpMobileNumberFormField);

	//DropMenu
    public static DropMenu Days = new DropMenu(DaysDropMenu);
    public static DropMenu Months = new DropMenu(MonthsDropMenu);
    public static DropMenu Years = new DropMenu(YearsDropMenu);
    public static DropMenu Countries = new DropMenu(CountriesDropMenu);
    
    
    //Checkbox
    public static Checkbox Male = new Checkbox(MaleCheckBox);
    public static Checkbox Female = new Checkbox(FemaleCheckBox);
    public static Checkbox NewsLetter = new Checkbox(NewsLetterCheckBox);
    public static Checkbox SpecialOffers = new Checkbox(SpecialOffersCheckBox);



}
