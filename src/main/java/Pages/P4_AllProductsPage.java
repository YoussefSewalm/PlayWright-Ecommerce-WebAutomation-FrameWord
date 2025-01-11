package Pages;
import static Locators.L4_AllProductsPage.*;
import coreElements.*;

public class P4_AllProductsPage {
	
	//Texts
	public static Texts VerifyAllProductsPage = new Texts(VerifyAllProductsPageText);
	public static Texts VerifyProductAdded = new Texts(VerifyProductAddedText);
	public static Texts ProductNames = new Texts(ProductNamesText);
	//Links
	public static Links ViewCart = new Links(ViewCartLink);
	
	//Buttons
	public static Buttons ContinueShopping = new Buttons(ContinueShoppingButton);
	public static Buttons Search = new Buttons(SearchButton);
	
	//FormFields
	public static FormFields SearchProduct = new FormFields(SearchProductFormField);
	
}
