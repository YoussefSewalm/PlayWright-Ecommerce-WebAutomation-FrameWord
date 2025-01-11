package coreElements;

public class FormFields extends ElementsBase {

	public FormFields(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
    public void Type(String Information) 
    {
    	page.fill(StringLocator,Information);
    }
}
