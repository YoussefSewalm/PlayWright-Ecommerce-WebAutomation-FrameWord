package TestBase;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Page;

import Pages.PlayWrightFactory;

public class BaseTest {
	
	Page page;
	PlayWrightFactory playwrightfactory;
	Properties props;
	
	@BeforeClass(alwaysRun=true)
	public void StartSession()
	{
		playwrightfactory = new PlayWrightFactory();
		props = playwrightfactory.InitiateProperties();
		page = playwrightfactory.InitiatePlayWrightBrowser(props);
	}
	
	@AfterClass(alwaysRun=true)
	public void EndSession()
	{
		page.context().browser().close();
	}

}
