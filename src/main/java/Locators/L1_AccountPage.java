package Locators;

public class L1_AccountPage {
	
	//Texts
	public static String VerifyAccountLoginPageText = "div[class='login-form']>h2";
	public static String VerifyLoginFailText = "//form[@action='/login']//p";
	public static String VerifyRegistrationFailText = "//form[@action='/signup']//p";

	//Buttons
	public static String SignUpButton = "//form[@action='/signup']//button[@type='submit']";
	public static String LoginButton = "//form[@action='/login']//button[@type='submit']";
	
	//FormFields
        public static String LoginEmailFormField = "//form[@action='/login']//input[@type='email']";
        public static String LoginPasswordFormField = "//form[@action='/login']//input[@type='password']";
        public static String RegisterNameFormField = "//form[@action='/signup']//input[@type='text']";
        public static String RegisterEmailFormField = "//form[@action='/signup']//input[@type='email']";
}
