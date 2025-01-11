package coreElements;

public class DropMenu extends ElementsBase {

	public DropMenu(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
    public void Select(String Choice) 
    {
    	int size_1 = page.locator(StringLocator).count();
    	for(int i=0;i<size_1;i++)
    	{
    		String CheckChoice = page.locator(StringLocator).nth(i).textContent();
    		if(CheckChoice==Choice)
    		{
    			page.locator(StringLocator).nth(i).click();
    			break;
    		}
    	}
    }
    public void Hover()
    {
    	page.hover(StringLocator);
    }
}
