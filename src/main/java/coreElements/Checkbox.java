package coreElements;

public class Checkbox extends ElementsBase{

	public Checkbox(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
    public void Check() 
    {
    	page.click(StringLocator);
    }
}
