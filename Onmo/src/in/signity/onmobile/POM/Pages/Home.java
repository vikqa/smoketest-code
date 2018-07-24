
package in.signity.onmobile.POM.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import in.signity.onmobile.POM.OR.HomeOTPOR;
import in.signity.onmobile.selenium.wrapper.Helper;
import in.signity.onmobile.selenium.wrapper.Wrapper;
import in.signity.onmobile.utilities.ReportLog;


	public class Home {
		private WebDriver driver;
		final static Logger logger = Logger.getLogger(Home.class);
		public Home(WebDriver driver) {
			this.driver = driver;		
			Helper.waitForBrowserToLoad(driver);
			Wrapper.explicitWaitForElementToBeClickable(driver,
					 HomeOTPOR.OTP_POPUP_CLOSE, 120);
	}
		
		public void verifyHomepageOTP(){
			boolean flag = Wrapper.isElementDisplayed(driver, HomeOTPOR.OTP_POPUP_CLOSE);
			try{
				Assert.assertEquals(flag, true);
				ReportLog.addToReportLog("", LogStatus.PASS);
			}catch(Throwable e){
				ReportLog.addToReportLog("", LogStatus.FAIL);
				throw new IllegalArgumentException("");
			}
		}
	

	}
	
