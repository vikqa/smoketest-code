package in.signity.onmobile.utilities;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import in.signity.onmobile.common.Common;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
	int count = 0;

	public synchronized void generateReport(List<XmlSuite> xmlSuites,
			List<ISuite> suites, String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator
				+ "Automation_Report.html", true);
		extent.loadConfig(new File(".\\extent-config.xml"));
		extent.addSystemInfo("Selenium Version", "2.52.0");
		extent.addSystemInfo("Created By", "vikas manhas");

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				count = result.size();
				ITestContext context = r.getTestContext();
				String con = context.getName();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS, con);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL, con);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP, con);
			}
		}

		extent.flush();
		extent.close();

	}

	private void buildTestNodes(IResultMap tests, LogStatus status, String con) {

		ExtentTest test;

		for (ITestResult result : tests.getAllResults()) {
			test = extent.startTest(result.getMethod().getMethodName(), result
					.getMethod().getDescription());

			test.setStartedTime(getTime(result.getStartMillis()));
			test.setEndedTime(getTime(result.getEndMillis()));

			for (String group : result.getMethod().getGroups())
				test.assignAuthor(group);
			test.assignCategory(con);
			List<String> list = Arrays.asList(ReportLog.error.split("~"));
			for(String l :list){
				if(!l.isEmpty()){
					String[] logE = Common.stringSepratedByParcentage(l);
					if(logE[1].equals("pass")){
						test.log(LogStatus.PASS, logE[0],"Step Pass");
					}else if(logE[0].equals("fail")){
						test.log(LogStatus.FAIL, logE[0],"Step Fail");
					}else if(logE[0].equals("skip")){
						test.log(LogStatus.SKIP, logE[0]);
					}
					
				}
			}

			String path = result.getAttribute("imagePath").toString();
			// if(!path.isEmpty()){
			String image = test.addScreenCapture(path);
			if (result.getStatus() == ITestResult.FAILURE) {

				test.log(status, image, result.getThrowable());
			} else if (result.getStatus() == ITestResult.SKIP) {
				test.log(status, "Test skipped ");

			} else {
				test.log(status, image, "Test passed ");
			}

			// }else{
			// if (result.getStatus() == ITestResult.FAILURE) {
			// test.log(status, result.getThrowable());
			// } else if (result.getStatus() == ITestResult.SKIP) {
			// test.log(status, "Test skipped " + result.getThrowable());
			//
			// } else {
			// test.log(status, "Test passed ");
			// }
			// }

			extent.endTest(test);

		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}
