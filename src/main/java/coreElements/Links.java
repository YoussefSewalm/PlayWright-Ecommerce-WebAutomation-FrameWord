package coreElements;

import java.nio.file.Paths;

import com.microsoft.playwright.Download;

public class Links extends ElementsBase {

	public Links(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
    public void Click() 
    {
    	//page.waitForCondition(() -> page.locator(StringLocator).isEnabled());
    	page.click(StringLocator);
    }
    public void DownloadAndSaveFile()
    {
    	Download download = page.waitForDownload(()->{
            
            //WRITE CALLBACK FUNCTION BODY (ACTION TO START DOWNLOADING THE FILE, ex: Click download)
            page.locator(StringLocator).click();
       });
    	download.saveAs(Paths.get("Invoices.zip"));
    }
}
