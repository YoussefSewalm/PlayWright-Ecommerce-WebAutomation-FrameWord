package Pages;
import static Locators.L6_CartPage.*;
import coreElements.*;

public class P6_CartPage {
	
	//Texts
	public static Texts EachUnitPrice = new Texts(EachUnitPriceText);
	public static Texts ItemQuantity = new Texts(ItemQuantityText);
	public static Texts ItemTotalPrice = new Texts(ItemTotalPriceText);
	public static Texts VerifyEmptyCart = new Texts(VerifyEmptyCartText);
	
	//Links
	public static Links RemoveItemFromCart = new Links(RemoveItemFromCartLink);
	public static Links ProceedToCheckOut = new Links(ProceedToCheckOutLink);
	public static Links RegisterOrLoginFromCheckOut = new Links(RegisterOrLoginFromCheckOutLink);
	

}
