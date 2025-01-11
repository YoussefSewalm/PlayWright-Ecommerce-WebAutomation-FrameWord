package coreElements;


import com.microsoft.playwright.Page;


public class ElementsBase {
	
	static Page page;
	String StringLocator;
	
	public static void setDriver(Page page1) 
	{
          page=page1;		
	}
	
    public ElementsBase(String locator)  //Constructor
    {
    	StringLocator=locator;
    }
    	

}
