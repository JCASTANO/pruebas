package com.pruebas.ft.driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

	private static final String FOLDER_DRIVERS = "drivers/";
	private static final String CHROMEDRIVER_EXE = "chromedriver.exe";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	public enum DriverType {
		INTERNET_EXPLORER, 
		FIREFOX, 
		CHROME
	}
	
	private static Driver drivers;
	
	private Driver() {
		
	}
	
	public static Driver getInstance() {
		if (drivers == null) {
			drivers = new Driver();
		}
		return drivers;
	}

	public WebDriver getWebDriver(DriverType driverType) {
		
		WebDriver driver = null;
		DesiredCapabilities capabilities = null;
		switch (driverType) {
		case FIREFOX:
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new FirefoxDriver(capabilities);
			break;
		case INTERNET_EXPLORER:
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(capabilities);
			break;
		case CHROME:
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty(WEBDRIVER_CHROME_DRIVER,getPathDriver(CHROMEDRIVER_EXE));
			driver = new ChromeDriver(capabilities);
			break;
		}
		return driver;
	}
	
	private String getPathDriver(String driver) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(FOLDER_DRIVERS+driver).getFile());
		return file.getAbsolutePath();
	}
}
