package coreElements;

public class FormFields extends ElementsBase {

	public FormFields(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
    public void Type(String Information) 
    {
    	//page.waitForCondition(() -> page.locator(StringLocator).isEnabled());
    	page.fill(StringLocator,Information);
    }
}
