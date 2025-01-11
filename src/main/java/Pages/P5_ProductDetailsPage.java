package Pages;
import static Locators.L5_ProductDetailsPage.*;
import coreElements.*;

public class P5_ProductDetailsPage {
	
	//Buttons
	public static Buttons AddToCart = new Buttons(AddToCartFromProductDetailsButton);
	
	//Texts
	public static Texts VerifyProductName = new Texts(VerifyProductNameText);
	public static Texts VerifyProductPrice = new Texts(VerifyProductPriceText);
	
	//FormFields
	public static FormFields ProductQuantity = new FormFields(ProductQuantityFormFields);

}
