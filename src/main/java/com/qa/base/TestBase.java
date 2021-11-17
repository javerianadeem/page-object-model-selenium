package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties properties;
	
//	constructor
	public TestBase() {
	 try {
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream("E:/Softwares/pom/src/main/java/com" + "/qa/config/config.properties");
			properties.load(inputStream);
	} catch (IOException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
}
	
//	other methods
	public static void initialization() {
		String browserName = properties.getProperty("browser");
		if(browserName.equals("chrome")) {
//			System.setProperty(browserName, browserName);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
//			System.setProperty(browserName, browserName);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
	}
}
