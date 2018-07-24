package in.signity.onmobile.selenium.wrapper;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class TestCase extends UseAsTestName_TestBase {
	int count = 0;

	@Retention(RetentionPolicy.RUNTIME)
	public @interface UseAsTestName {
		int idx() default 0;
	}

	public void setup(String browserVer, String baseURL, String apiURL) {
	}

	public void setup(String browserVer, String baseURL) {

	}

	public abstract void tearDown();

	

}
