package coreElements;

public class Buttons extends ElementsBase{

	public Buttons(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
    public void Click() 
    {
    	page.click(StringLocator);
    }

}
