package coreElements;
import java.time.Month;

import com.github.javafaker.Faker;

public class Utility extends ElementsBase{

	static Faker faker = new Faker();
	public Utility(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	public static void AddToCart(String ItemName)
	{
		page.locator("//p[contains(text(),'"+ItemName+"')]//parent::div/a").first().click();
	}
	public static void RemoveItemFromCart(String ProductName)
	{
		page.locator("//a[contains(text(),'"+ProductName+"')]//parent::h4//parent::td//following-sibling::td[@class='cart_delete']//a").click();
	}
	public static void ViewProduct(String ItemName)
	{
		page.locator("//p[contains(text(),'"+ItemName+"')]//parent::div//parent::div//parent::div[@class='product-image-wrapper']//div[@class='choose']").click();
	}
	public static double CalculateTotalPriceForItem(String ItemName)
	{
		String eachunitprice = page.locator("//a[contains(text(),'"+ItemName+"')]//parent::h4//parent::td//following-sibling::td[@class='cart_price']").textContent();
		eachunitprice= eachunitprice.substring(13);
		double UnitPrice = Double.parseDouble(eachunitprice);
		String unitquantity = page.locator("//a[contains(text(),'"+ItemName+"')]//parent::h4//parent::td//following-sibling::td[@class='cart_quantity']").textContent();
		double UnitQuantity = Double.parseDouble(unitquantity);
		double TotalItemPrice = UnitQuantity*UnitPrice;
		return TotalItemPrice;		
	}
	public static double CalculateTotalCartItemsPrice()
	{
		int numberofitems = page.locator("//p[@class='cart_total_price']").count();
		double total_price=0;
		for(int i=1;i<=numberofitems-1;i++)
		{
			String Eachunitprice = page.locator("(//td[@class='cart_price']//p)"+"["+i+"]").textContent().substring(4);
			String EachUnitQuantity = page.locator("(//td[@class='cart_quantity']//button)"+"["+i+"]").textContent();
			total_price += Double.parseDouble(Eachunitprice) * Double.parseDouble(EachUnitQuantity);
		}
		return total_price;
	}
	public static String GetItemQuantity(String ItemName)
	{
		String quantity = page.locator("//a[contains(text(),'"+ItemName+"')]//parent::h4//parent::td//following-sibling::td[@class='cart_quantity']").textContent();
		return quantity;
	}
	public static double GetTotalPriceForItem(String ItemName)
	{
		String unittotalprice = page.locator("//a[contains(text(),'"+ItemName+"')]//parent::h4//parent::td//following-sibling::td[@class='cart_total']").textContent();
		unittotalprice= unittotalprice.substring(13);
		double UnitTotalPrice = Double.parseDouble(unittotalprice);
		return UnitTotalPrice;
	}
	public static String GetNameFromCheckOutDetails(String Name)
	{
		String name = page.locator("//ul[@class='address item box']//li[contains(text(),'"+Name+"')]").textContent();
		return name;
	}
	public static String GetCompanyNameFromCheckOutDetails(String Company)
	{
		String company = page.locator("//ul[@class='address item box']//li[contains(text(),'"+Company+"')]").textContent();
		return company;
	}
	public static String GetFirstAddressFromCheckOutDetails(String Address1)
	{
		String address1= page.locator("//ul[@class='address item box']//li[contains(text(),'"+Address1+"')]").first().textContent();
		return address1;
	}
	public static String GetSecondAddressFromCheckOutDetails(String Address2)
	{
		String address2 = page.locator("//ul[@class='address item box']//li[contains(text(),'"+Address2+"')]").nth(1).textContent();
		return address2;
	}
	public static String GetRandomFirstAddressFromCheckOutDetails(String Address1)
	{
		String address1= page.locator("//ul[@class='address item box']//li[contains(text(),'"+Address1+"')]").textContent();
		return address1;
	}
	public static String GetRandomSecondAddressFromCheckOutDetails(String Address2)
	{
		String address2 = page.locator("//ul[@class='address item box']//li[contains(text(),'"+Address2+"')]").textContent();
		return address2;
	}
	public static String GetZipCodeFromCheckOutDetails(String ZipCode)
	{
		String zipcode = page.locator("//ul[@class='address item box']//li[contains(text(),'"+ZipCode+"')]").textContent();
		return zipcode;
	}
	public static String GetPhoneNumberFromCheckOutDetails(String PhoneNumber)
	{
		String phonenumber = page.locator("//ul[@class='address item box']//li[contains(text(),'"+PhoneNumber+"')]").textContent();
		return phonenumber;
	}
	public static void FillPaymentDetails(String NameOnCard,String CardNumber,String CVC,String EXP_Month,String EXP_Year)
	{
		page.locator("input.form-control:below(:text('Name on Card'))").first().fill(NameOnCard);
		page.locator("input.form-control:below(:text('Card Number'))").first().fill(CardNumber);
		page.locator("input.form-control:below(:text('CVC'))").first().fill(CVC);
		page.locator("input.form-control:below(:text('Expiration'))").first().fill(EXP_Month);
		page.locator("input[name='expiry_year']").fill(EXP_Year);
	}
	public static String GetRandomRegisterName()
	{
		return faker.name().firstName();
	}
	public static String GetRandomEmailAddress()
	{
		return faker.internet().emailAddress();
	}
	public static String GetRandomSignUpName()
	{
		return faker.name().firstName();
	}
	public static String GetRandomPassword()
	{
		return faker.internet().password();
	}
	public static String GetRandomDayOfBirth()
	{
		return String.valueOf(faker.number().numberBetween(1, 30));
	}
	public static String GetRandomMonthOfBirth()
	{
		return Month.of(faker.number().numberBetween(1, 12)).name();
	}
	public static String GetRandomYearOfBirth()
	{
		return String.valueOf(faker.number().numberBetween(1900, 2021));
	}
	public static String GetRandomSignUpFirstName()
	{
		return faker.name().firstName();
	}
	public static String GetRandomSignUpLastName()
	{
		return faker.name().lastName();
	}
	public static String GetRandomCompanyName()
	{
		return faker.company().toString();
	}
	public static String GetRandomFirstAddress()
	{
		return faker.address().fullAddress();
	}
	public static String GetRandomSecondAddress()
	{
		return faker.address().fullAddress();
	}
	public static String GetRandomCountryName()
	{
		return faker.country().name();
	}
	public static String GetRandomStateName()
	{
		return faker.country().capital();
	}
	public static String GetRandomCityName()
	{
		return faker.country().capital();
	}
	public static String GetRandomZipCode()
	{
		return faker.number().digits(5);
	}
	public static String GetRandomMobileNumber()
	{
		return faker.phoneNumber().phoneNumber();
	}
	public static String GetRandomCreditName()
	{
		return faker.name().toString();
	}
	public static String GetRandomCreditNumber()
	{
		return faker.finance().creditCard();
	}
	public static String GetRandomCVC()
	{
		return faker.number().digits(3);
	}
	public static String GetRandomExpirationYear()
	{
		return String.valueOf(faker.number().numberBetween(1990, 2021));
	}
	public static String GetRandomExpirationMonth()
	{
		return String.valueOf(faker.number().numberBetween(1, 12));
	}
	
}
