package in.signity.onmobile.selenium.web;

public enum Browsers {
	
	FIREFOX  ("firefox"), 
	IEXPLORER ("internet explorer"),
	CHROME ("chrome");
	
	private String value;

	Browsers(String value) {
		this.setValue(value);
	
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
