package in.signity.onmobile.selenium.web;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;

public class BrowserDriver {

	public static WebDriver driver;
	
	final static Logger logger = Logger.getLogger(BrowserDriver.class);

	public static WebDriver launchBrowser(String browserType) {

		try {

			if (browserType.equals(Browsers.FIREFOX.getValue())) {
				driver = launchFirefox();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else if (browserType.equals(Browsers.IEXPLORER.getValue())) {
				driver = launchIE();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			} else if (browserType.equals(Browsers.CHROME.getValue())) {
				driver = launchChrome();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			} else {
				throw new SkipException("driver does not started");
			}

			driver.manage().window().maximize();
			logger.info(browserType + " driver ready for testing");

		} catch (Exception ex) {
			logger.info(browserType + " driver does not started"  , ex);
			throw new SkipException("driver does not started");

		}
		return driver;
	}

	private static WebDriver launchFirefox() {
		WebDriver driver = new FirefoxDriver();	
		return driver;
	}

	private static WebDriver launchChrome() {
		WebDriver driver = null;
		File file = new File(".\\seleniumDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		return driver;

	}

	private static WebDriver launchIE() {
		WebDriver driver = null;
		File file = new File(".\\seleniumDriver\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(capabilities);
		return driver;
	}

}
