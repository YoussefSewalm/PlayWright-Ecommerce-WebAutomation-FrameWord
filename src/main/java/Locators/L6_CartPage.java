package Locators;

public class L6_CartPage {
	
	//Texts
	public static String EachUnitPriceText = "//a[contains(text(),'Blue Top')]//parent::h4//parent::td//following-sibling::td[@class='cart_price']";
	public static String ItemQuantityText = "//a[contains(text(),'Blue Top')]//parent::h4//parent::td//following-sibling::td[@class='cart_quantity']";
	public static String ItemTotalPriceText = "//a[contains(text(),'Blue Top')]//parent::h4//parent::td//following-sibling::td[@class='cart_total']";
	public static String VerifyEmptyCartText = "p[class='text-center']>b";
	
	//Links
	public static String RemoveItemFromCartLink = "//a[contains(text(),'Blue Top')]//parent::h4//parent::td//following-sibling::td[@class='cart_delete']//a";
	public static String ProceedToCheckOutLink = "a[class='btn btn-default check_out']";
	public static String RegisterOrLoginFromCheckOutLink = "//div[@class='modal-content']//div[@class='modal-body']//descendant::a";	
}
