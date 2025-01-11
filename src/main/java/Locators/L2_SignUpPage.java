package Locators;

public class L2_SignUpPage {
	
	//Texts
	public static String VerifySignUpPageText = "(//div[@class='login-form']//h2[@class='title text-center']//b)[1]";
	
	//Links
    

	//Buttons
	public static String CreateAccountButton = "text='Create Account'";
	
	//FormFields
    public static String SignUpNameFormField = "#name";
    public static String SignUpPasswordFormField = "#password";
    public static String SignUpFirstNameFormField = "#first_name";
    public static String SignUpLastNameFormField = "#last_name";
    public static String SignUpCompanyFormField = "#company";
    public static String SignUpFirstAddressFormField = "#address1";
    public static String SignUpSecondAddressFormField = "#address2";
    public static String SignUpStateFormField = "#state";
    public static String SignUpCityFormField = "#city";
    public static String SignUpZipCodeFormField = "#zipcode";
    public static String SignUpMobileNumberFormField = "#mobile_number";

	
	//DropMenu
    public static String DaysDropMenu = "//select[@id='days']//option";
    public static String MonthsDropMenu = "//select[@id='months']//option";
    public static String YearsDropMenu = "//select[@id='years']//option";
    public static String CountriesDropMenu = "//select[@id='country']//option";
	
	//CheckBox
	public static String MaleCheckBox = "#id_gender1";
	public static String FemaleCheckBox = "#id_gender2";
	public static String NewsLetterCheckBox = "#newsletter";
	public static String SpecialOffersCheckBox = "#optin";
	

}
