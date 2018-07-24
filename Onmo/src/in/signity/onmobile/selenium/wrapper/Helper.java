package in.signity.onmobile.selenium.wrapper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import in.signity.onmobile.selenium.web.Browsers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;




@SuppressWarnings("deprecation")
public class Helper {

	public Proxy proxy;

	public static String currentWindowHandle(WebDriver webdriver) {
		return webdriver.getWindowHandle();

	}

	public static void holdon(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	 public static Set<String> allExistingWindowHandles(WebDriver webdriver) {
	 return webdriver.getWindowHandles();
	
	 }

	public static ArrayList<String> ArrayListWindowHandles(WebDriver webdriver) {
		ArrayList<String> windows = new ArrayList<String>(webdriver.getWindowHandles());
		return windows;

	}

	public static String pageSource(WebDriver webdriver) {
		return webdriver.getPageSource();
	}

	public static String getPageTitle(WebDriver webdriver) {
		return webdriver.getTitle();
	}

	public static String getUrl(WebDriver webdriver) {
		return webdriver.getCurrentUrl();
	}

	public static WebDriver getCurrentWebDriver(WebDriver webdriver) {
		return webdriver;
	}	

	public static void waitForBrowserToLoad(WebDriver driver) {
		String state = null;
		String oldstate = null;
		try {
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = cap.getBrowserName().toLowerCase();
			if (browserName.equals(Browsers.IEXPLORER.getValue()))
				Thread.sleep(5000);

			state = ((JavascriptExecutor) driver).executeScript("return document.readyState;").toString();

			if (state.equals("complete"))
				return;
			else {
				for (int second = 0;; second++) {
					if (second >= 180)
						Assert.fail("timeout");
					oldstate = state;
					state = ((JavascriptExecutor) driver).executeScript("return document.readyState;").toString();
					if (state.equals("complete"))
						return;
					if (state.equals(oldstate))

						if (((second == 120) || (second == 160))
								&& (state.equals("interactive") || state.equals("loading"))) {
							driver.navigate().refresh();
						}
					Thread.sleep(2000);

				}

			}

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	

	// public static void takeAScreenShotOfTheApp() throws AWTException,
	// IOException {
	// Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	// Rectangle screenBounds = new Rectangle(0, 0, screenDim.width,
	// screenDim.height);
	//
	// Robot robot = new Robot();
	// BufferedImage image = robot.createScreenCapture(screenBounds);
	//
	// File screenshotFile = new File("image" + System.currentTimeMillis()
	// + ".png");
	// ImageIO.write(image, "png", screenshotFile);
	// }

	public static boolean verifyTextPresent(String value, WebDriver driver) {
		boolean textFound = driver.getPageSource().contains(value);
		if (textFound) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void closeBrowserTab(WebDriver driver) {
		driver.close();
		
	}

	public static void waitInSeconds(long waitValue, WebDriver webdriver) throws InterruptedException {
		webdriver.wait(waitValue);
	}

	public static void cancelAlert() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {

			e.printStackTrace();
		}
	}

	public static void switchToNewWindowJS(WebDriver webdriver, String URL) {
		webdriver.getWindowHandle();
		((JavascriptExecutor) webdriver).executeScript("window.open('" + URL + "')");
		Set<String> Windows = webdriver.getWindowHandles();
		String newTab = Windows.iterator().next();		
		webdriver.switchTo().window(newTab);
	}

	public static void switchToNewWindow(WebDriver webdriver,String window) {		
		webdriver.switchTo().window(window);
	}

	public static void reSizeFireFoxBrowser(int width, int height, WebDriver webdriver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) webdriver;
		scriptExecutor.executeScript("window.resizeTo(1024,768);"); // For Now
																	// Hard
																	// Coded
																	// Debug
																	// Purpose
		Thread.sleep(5000L);
	}

	public static void scrollEndOfPage(long scrollRange, WebDriver webdriver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) webdriver;
		scriptExecutor.executeScript("scrollTo(0,3000)");
		// ((JavascriptExecutor)webdriver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
		
	}

	public static void scrollMiddleOfPage(long scrollRange, WebDriver webdriver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) webdriver;
		scriptExecutor.executeScript("scrollTo(0,250)");
		// scriptExecutor.executeScript("scroll(0,250);");
		// scriptExecutor.executeScript("scrollTo(0,250)");
		// executeScript("scroll(0,250);");executeScript("scroll(0,250);");
		// ((JavascriptExecutor)webdriver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
	}

	public static void scrollBeginningOfPage(long scrollRange, WebDriver webdriver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) webdriver;
		scriptExecutor.executeScript("scrollTo(0,0)");
		// ((JavascriptExecutor)webdriver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
	}

	public static void scrollEndOfPage(WebDriver webdriver) throws InterruptedException {
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) webdriver;
		scriptExecutor.executeScript("scrollTo(0,3000)");
		// ((JavascriptExecutor)webdriver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
		
	}

	public static void scrollToTopOfPage(WebDriver webdriver) throws InterruptedException {
		// webdriver.findElement(By.id("shell")).sendKeys(Keys.HOME);
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) webdriver;
		scriptExecutor.executeScript("scrollTo(0,0)");
		// ((JavascriptExecutor)webdriver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
	}

	public static void scrollPageDown(WebDriver webdriver) throws InterruptedException {
		// webdriver.findElement(By.id("shell")).sendKeys(Keys.PAGE_DOWN);
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) webdriver;
		scriptExecutor.executeScript("scrollTo(0,750)");
		// ((JavascriptExecutor)webdriver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
		
	}

	public static void scrollPageUp(WebDriver webdriver) throws InterruptedException {
		// webdriver.findElement(By.id("shell")).sendKeys(Keys.PAGE_DOWN);
		JavascriptExecutor scriptExecutor = (JavascriptExecutor) webdriver;
		scriptExecutor.executeScript("scrollTo(0,250)");
		// ((JavascriptExecutor)webdriver).executeScript("scrollTo(0,scrollRange)");
		Thread.sleep(5000L);
		
	}

	public static void clearCookies(String refCookie, WebDriver webdriver) {
		if (refCookie.length() > 2) {
			webdriver.manage().deleteCookieNamed(refCookie);
		} else {
			webdriver.manage().deleteAllCookies();
		}
	}

	public static void clearAllCookies(WebDriver webdriver) {
		webdriver.manage().deleteAllCookies();
	}

}
