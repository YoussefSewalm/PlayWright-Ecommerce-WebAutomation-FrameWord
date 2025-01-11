package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page.ScreenshotOptions;

import coreElements.ElementsBase;


public class PlayWrightFactory {
	
	Browser browser;
	BrowserContext context;
	Properties config_properties;
	public static Page page;

	public Page InitiatePlayWrightBrowser(Properties configprops)
	{
        Playwright playwright = Playwright.create();
        
        switch(configprops.getProperty("Browser").toLowerCase()) 
        {
        case "chrome":
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
            		.setChannel(configprops.getProperty("Browser").toLowerCase())
            		.setHeadless(Boolean.parseBoolean(configprops.getProperty("Headless"))));
            break;
        case "firefox":
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
            		.setHeadless(Boolean.parseBoolean(configprops.getProperty("Headless"))));
            break;
        case "chromium":
        	browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        			.setHeadless(Boolean.parseBoolean(configprops.getProperty("Headless"))));
        	break;
        case "safari":
        	browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
        			.setHeadless(Boolean.parseBoolean(configprops.getProperty("Headless"))));
        	break;
        default:
        	break;
        }
        
        context = browser.newContext();
        page = context.newPage();
        page.navigate(configprops.getProperty("Url"));
        ElementsBase.setDriver(page);
        return page;
	}

	public Properties InitiateProperties()
	{
		try {
			FileInputStream Config_File = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/Config.properties");
			config_properties = new Properties();
			try {
				config_properties.load(Config_File);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	}
		 return config_properties;
	}

}
