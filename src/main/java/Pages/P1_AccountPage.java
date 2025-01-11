package Pages;

import static Locators.L1_AccountPage.*;

import coreElements.*;

public class P1_AccountPage {
	
	    //Texts
	    public static Texts VerifyAccountLoginPage = new Texts(VerifyAccountLoginPageText);
	    public static Texts VerifyLoginFail = new Texts(VerifyLoginFailText);
	    public static Texts VerifyRegisterationFail = new Texts(VerifyRegistrationFailText);

		//Links

		//Buttons
		public static Buttons SignUp = new Buttons(SignUpButton);
		public static Buttons Login = new Buttons(LoginButton);
		
		//FormFields
        public static FormFields LoginEmail = new FormFields(LoginEmailFormField);
        public static FormFields LoginPassword = new FormFields(LoginPasswordFormField);
        public static FormFields RegisterName = new FormFields(RegisterNameFormField);
        public static FormFields RegisterEmail = new FormFields(RegisterEmailFormField);

		//DropMenu

		
}
