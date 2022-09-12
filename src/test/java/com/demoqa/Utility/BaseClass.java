package com.demoqa.Utility;

import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (BaseClass.getProperty("browser")) { // change driver to any driver below

			case "firefox":

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "chrome":

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "safari":

				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;

			case "headless":

				break;

			}

		}
		
		PageInitializer.initialize();
		return driver;
	}

	// quit browser
	public static void teardown() {
		if (driver != null) {
			driver.close();
			driver = null;
		}

	}


	public static Properties configfile;

	static {

		try {
			String path = Constants.config_filePath;

			FileInputStream input = new FileInputStream(path);

			configfile = new Properties();
			configfile.load(input); // now path value is storing in configfile.

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String keyName) {

		return configfile.getProperty(keyName);
	}

}
