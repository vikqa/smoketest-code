package in.signity.onmobile.POM.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import in.signity.onmobile.POM.Pages.Home;
import in.signity.onmobile.selenium.web.BrowserDriver;
import in.signity.onmobile.selenium.wrapper.TestCase;


public class HomeTests<logout> extends TestCase {
	final static Logger logger = Logger.getLogger(HomeTests.class);
	private WebDriver driver;
	private Home _home;

	@Parameters({ "browserVer", "baseURL" })
	@BeforeClass
	public void setup(String browserVer, String baseURL) {

		driver = BrowserDriver.launchBrowser(browserVer);
		driver.navigate().to(baseURL);
		_home = new Home(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
