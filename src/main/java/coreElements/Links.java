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
    	page.click(StringLocator);
    }
    public void DownloadAndSaveFile()
    {
    	Download download = page.waitForDownload(()->{
            page.locator(StringLocator).click();
       });
    	download.saveAs(Paths.get("Invoices.zip"));
    }
}
