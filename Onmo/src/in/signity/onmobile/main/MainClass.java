package in.signity.onmobile.main;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import org.testng.TestNG;
import com.beust.jcommander.internal.Lists;

import in.signity.onmobile.common.Common;

public class MainClass {

	public static void main(String[] args) {		
		TestNG testng = new TestNG();	
		PropertyConfigurator.configure(".\\build\\log4j.properties");
		String test = "TestOutPut"+Common.getCurrentDateTime();
		test = ".//" + test;
		testng.setOutputDirectory(test);
		List<String> suites = Lists.newArrayList();

		suites.add(".//testng.xml");// path to xml..
		testng.setTestSuites(suites);

		testng.run();

	}

}