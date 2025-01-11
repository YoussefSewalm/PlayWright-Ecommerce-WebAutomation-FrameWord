package coreElements;

public class Texts extends ElementsBase{

	public Texts(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
    public String GetText() 
    {
    	return page.locator(StringLocator).textContent();
    }
    public double ConvertStringToDouble()
    {
    	String text = page.locator(StringLocator).textContent().substring(4);
    	double number = Double.parseDouble(text);
    	return number;
    }
    public String GetTextFromList()
    {
    	return page.locator(StringLocator).first().textContent();
    }

}
