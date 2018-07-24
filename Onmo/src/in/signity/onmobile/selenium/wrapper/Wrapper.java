package in.signity.onmobile.selenium.wrapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

public class Wrapper {

	public static String getElementText(WebDriver driver, By by) {
String test = findWebElement(driver, by).getText();
		return findWebElement(driver, by).getText();
	}

	public static String getElementText(WebDriver driver, String by) {

		return findWebElement(driver, by).getText();
	}

	public static boolean isElementEnabled(WebDriver driver, By by) {
		return findWebElement(driver, by).isEnabled();
	}

	public static boolean isElementEnabled(WebDriver driver, String by) {
		return findWebElement(driver, by).isEnabled();
	}

	public static boolean isElementDisplayed(WebDriver driver, By by) {
		return findWebElement(driver, by).isDisplayed();
	}

	public static boolean isElementDisplayed(WebDriver driver, String by) {
		return findWebElement(driver, by).isDisplayed();
	}

	public static boolean isElementSelected(WebDriver driver, By by) {
		return findWebElement(driver, by).isSelected();
	}

	public static String getElementAttribute(WebDriver driver, By by, String attr) {
		return findWebElement(driver, by).getAttribute(attr);
	}

	public static String getElementAttribute(WebDriver driver, String by, String attr) {
		String text = "";
		boolean flag = isElementDisplayed(driver, by);
		if (flag)
			text = findWebElement(driver, by).getAttribute(attr);
		else
			throw new NoSuchElementException(by);

		return text;
	}

	public static String getElementTagName(WebDriver driver, By by) {
		return findWebElement(driver, by).getTagName();
	}

	public static void clickElement(WebDriver driver, By by) {
		findWebElement(driver, by).click();

	}

	public static void clickElementAndWait(WebDriver driver, By by) {
		findWebElement(driver, by).click();
		Helper.holdon(2);
	}

	public static String clickElementAndGetNotification(WebDriver driver, By by) {
		clickElement(driver, by);
		String text = waitForElementAndReturnInnerText(driver, By.cssSelector(".ngn.ng-scope"));
		Helper.holdon(5);
		
		return text;

	}
	
	public static void clickElement(WebDriver driver, String by, boolean flag) {
		flag = isElementDisplayed(driver, by);
		if (flag)
			findWebElement(driver, by).click();
		else
			throw new NoSuchElementException(by);
		Helper.holdon(3);

	}

	public static void clickElementAndWait(WebDriver driver, String by) {
		clickElement(driver, by);
		Helper.holdon(2);
	}

	public static void clickElement(WebDriver driver, String by) {
		findWebElement(driver, by).click();

	}

	public static String clickElementAndGetNotification(WebDriver driver, String by) {
		clickElement(driver, by);
		String text = Wrapper.waitForElementAndReturnInnerText(driver, By.cssSelector(".ngn.ng-scope"), 180);
		return text;

	}

	public static void enterValueInInputBox(WebDriver driver, By by, String descTextToBeEntered) {
		clearField(driver, by);
		enterValue(driver, by, descTextToBeEntered);

	}

	public static void enterValue(WebDriver driver, By by, String descTextToBeEntered) {
		findWebElement(driver, by).sendKeys(descTextToBeEntered);

	}

	public static String getTextByAttributeValue(WebDriver driver, By by) {
		String test = findWebElement(driver, by).getAttribute("value").toString();
		return test;
	}

	public static void clearField(WebDriver driver, By by) {
		findWebElement(driver, by).clear();

	}

	public static void clearField(WebDriver driver, String by) {
		findWebElement(driver, by).clear();

	}

	public static WebElement findWebElement(WebDriver driver, By by) {

		return driver.findElement(by);
	}

	public static WebElement findWebElement(WebDriver driver, String by) {
		WebElement element = null;
		try {
			element = driver.findElement(By.cssSelector(by));
		} catch (NoSuchElementException e) {
			throw e;
		}
		return element;
	}

	public static List<WebElement> findWebElements(WebDriver driver, By by) {
		return driver.findElements(by);
	}

	public static List<WebElement> findWebElements(WebDriver driver, String by) {
		return driver.findElements(By.cssSelector(by));
	}

	public static void waitForElement(WebDriver driver, By by) {
		try {
			for (int second = 0;; second++) {
				if (second >= 180)
					throw new SkipException("timeout");

				if (isElementPresent(driver, by))
					break;
				else
					Helper.holdon(1);

			}

		} catch (NoSuchElementException e) {
			throw e;
		}

	}

	public static void waitForElementUntilGetText(WebDriver driver, By by) {
		try {
			for (int second = 0;; second++) {
				if (second >= 180)
					throw new SkipException("timeout");
				String text = getElementText(driver, by);
				if (!text.isEmpty())
					break;
				else
					Helper.holdon(1);

			}
		} catch (NoSuchElementException e) {
			throw e;
		}

	}

	public static void waitForPageActive(WebDriver driver, By by) {
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			for (int itration = 0;; itration++) {
				if (itration >= 180)
					throw new SkipException("Progress Bar still there After 3 mins wait");
				boolean isExist = isElementDisplayed(driver, by);				
				if (isExist)
					Helper.holdon(1);
				else
					break;
			}
		} catch (NoSuchElementException e) {

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void waitForPageActiveThenNotification(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			for (int itration = 0;; itration++) {
				if (itration >= 180)
					throw new SkipException("timeout");
				boolean isExist = isProgressSpinnerPresent(driver);				
				if (isExist)
					Helper.holdon(1);
				else
					break;
			}
		} catch (NoSuchElementException e) {

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Helper.holdon(5);
	}
	
	public static void waitForPageActive(WebDriver driver, boolean isLoadingExist) {
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			for (int itration = 0;; itration++) {
				if (itration >= 180)
					throw new SkipException("timeout");
				boolean isExist = isProgressSpinnerPresent(driver);
				isLoadingExist = isLoadingPresent(driver);
				if (isExist||isLoadingExist)
					Helper.holdon(1);
				else
					break;
			}
		} catch (NoSuchElementException e) {

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void waitForPageActive(WebDriver driver, By by, int attempts) {
		try {
			for (int i = 0; i < attempts; i++) {
				Helper.holdon(1);
				explicitWaitForElementToBeClickable(driver, by, 180);
			}
		} catch (NoSuchElementException e) {
			throw new SkipException("timeout");
		}

	}

	public static String waitForElementAndReturnInnerText(WebDriver driver, By by, int sec) {
		String text = "";
		explicitWaitForElementToBeClickable(driver, by, sec);
		if (isElementDisplayed(driver, by))
			text = driver.findElement(by).getText();

		return text;

	}	
	
	public static String waitForElementAndReturnInnerText(WebDriver driver, By by) {
		String text = "";
		explicitWaitForElementVisibility(driver, by, 180);
		if (isElementDisplayed(driver, by))
			text = driver.findElement(by).getText();

		return text;

	}	

	public static String waitForElementAndReturnInnerText(WebDriver driver, By by, String s, int sec) {
		String text = "";
		Wrapper.explicitWaitForTextToBePresentInElement(driver, by, s, sec);
		if (isElementDisplayed(driver, by))
			text = driver.findElement(by).getText();

		return text;

	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isProgressSpinnerPresent(WebDriver driver) {
		By by = By.id("label");
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean isLoadingPresent(WebDriver driver) {
		By by = By.cssSelector("div.loading");
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	

	public static void pressEnter(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);

		if (driver instanceof InternetExplorerDriver) {
			element.sendKeys(Keys.ENTER);
		} else {
			element.click();
		}
	}

	public static void deselectDropdown(WebDriver driver, By by) {
		Select selectObj = new Select(findWebElement(driver, by));
		selectObj.deselectAll();

	}

	public static List<WebElement> getDropdownOptions(WebDriver driver, By by) {
		List<WebElement> ar = null;
		Select selectObj = new Select(findWebElement(driver, by));
		ar = selectObj.getOptions();
		return ar;

	}

	public static String getDropdownTextOfSelectedItemByValueAtrribute(WebDriver driver, By by) {
		String textToRet = "";
		Select selectField = new Select(findWebElement(driver, by));
		textToRet = selectField.getFirstSelectedOption().getAttribute("value");
		return textToRet;
	}

	public static String getTextOfItemByDesireAtrribute(WebDriver driver, By by, String atr) {
		String textToRet = "";
		WebElement element = findWebElement(driver, by);
		textToRet = element.getAttribute(atr);
		return textToRet;
	}

	public static String getTextOfItemByDesireAtrribute(WebDriver driver, String by, String atr) {
		String textToRet = "";
		WebElement element = findWebElement(driver, by);
		textToRet = element.getAttribute(atr);
		return textToRet;
	}

	public static String getDropdownTextOfSelectedItem(WebDriver driver, By by) {
		String textToRet = "";
		Select selectField = new Select(findWebElement(driver, by));
		textToRet = selectField.getFirstSelectedOption().getText();
		return textToRet;
	}

	public static void selectDropdownByValue(WebDriver driver, By by, String selection) {
		Select selectField = new Select(findWebElement(driver, by));
		selectField.selectByValue(selection);

	}

	public static void selectDropdownByIndex(WebDriver driver, By by, int selectionIndex) {
		Select selectField = new Select(findWebElement(driver, by));
		selectField.selectByIndex(selectionIndex);
	}

	public static void selectDropdownByVisibleText(WebDriver driver, By by, String selection) {
		Select selectField = new Select(findWebElement(driver, by));
		selectField.selectByVisibleText(selection.trim());

	}

	public static String getImageLink(WebDriver driver, By by) {
		return findWebElement(driver, by).getAttribute("href");

	}

	public static String getImageSource(WebDriver driver, By by) {
		return findWebElement(driver, by).getAttribute("src");

	}

	public static String getImageSource(WebDriver driver, String by) {
		return findWebElement(driver, by).getAttribute("src");

	}
					 
	public static void explicitWaitForElementToBeClickable(WebDriver driver, By by, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	@SuppressWarnings("deprecation")
	public static void explicitWaitForTextToBePresentInElement(WebDriver driver, By by, String s, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.textToBePresentInElement(by, s));
	}

	public static void explicitWaitForInvisibilityOfElementLocated(WebDriver driver, By by, String s, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public static void explicitWaitForElementToBeSelected(WebDriver driver, By by, String s, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeSelected(by));
	}

	public static void explicitWaitForElementToBeClickable(WebDriver driver, String by, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(by)));
	}

	public static void explicitWaitForElementVisibility(WebDriver driver, By by, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static String getTextUsingAngularJS(WebDriver driver, String by) {
		String ajs = "return angular.element(document.getElementById('" + by + "')).scope()." + by + ";";
		String text = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		text = js.executeScript(ajs).toString();
		return text;
	}	

	public static void clickElementUsingJS(WebDriver driver, By by) {
		Wrapper.explicitWaitForElementToBeClickable(driver, by, 60);
		WebElement we = findWebElement(driver, by);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", we);
	}

	public static void waitForDeploy(WebDriver driver, String by, String error) {
		try {
			for (int itration = 0;; itration++) {
				if (Wrapper.isElementDisplayed(driver, by))
					Helper.holdon(1);
				else
					break;
				if (itration >= 600)
					throw new SkipException(error);
			}
		} catch (NoSuchElementException e) {

		}

	}

	public static void waitForLinkDeploy(WebDriver driver, String by) {
		for (int itration = 0;; itration++) {
			boolean flag = false;
			try {
				flag = isElementDisplayed(driver, by);
			} catch (NoSuchElementException e) {
				flag = false;
			}
			if (flag)
				break;
			else
				Helper.holdon(1);

			if (itration >= 35)
				throw new SkipException("Timeout in Link Deployment");			
		}

	}

	public static void waitForTopologyFailed(WebDriver driver, By by) {
		for (int itration = 0;; itration++) {

			boolean flag = false;
			try {
				flag = isElementDisplayed(driver, by);
			} catch (NoSuchElementException e) {
				flag = false;
			}
			if (flag)
				break;
			else
				Helper.holdon(1);

			if (itration >= 8)
				throw new SkipException("Timeout in Link Deployment");
		}

	}

	// public static ExpectedCondition<WebElement> visibilityOfElementLocated(
	// final By by) {
	//
	// return new ExpectedCondition<WebElement>() {
	//
	// @Override
	// public WebElement apply(WebDriver d) {
	//
	// WebElement element = d.findElement(by);
	//
	// if (element.isDisplayed()) {
	//
	// return element;
	//
	// }
	//
	// return null;
	//
	// }
	//
	// };
	//
	// }

}
