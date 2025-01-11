package Locators;

public class L4_AllProductsPage {
	
	//Texts
	public static String VerifyAllProductsPageText = "div[class='features_items']>h2";
	public static String VerifyProductAddedText = "//div[@class='modal-header']//h4";
	public static String ProductNamesText = "//div[@class='single-products']//descendant::p";
	
	//Links
       public static String ViewCartLink = "//div[@class='modal-body']//descendant::a";

	//Buttons
       public static String ContinueShoppingButton = "//div[@class='modal-content']//descendant::button";
       public static String SearchButton = "//section[@id='advertisement']//div//button";
    
	//FormFields
       public static String SearchProductFormField = "//section[@id='advertisement']//div//input";
}
