package com.qa.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.pages.BasePage;
import com.qa.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static Properties prop;
	public WebDriver driver;
	public Page page;
	public String strAbsolutepath = new File("").getAbsolutePath();

	public BaseTest() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(
					strAbsolutepath + "\\src\\main\\java\\com\\qa\\config\\config.properties");

			prop.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void setuptest() {

		if (prop.getProperty("browser").equals("chrome")) {

			ChromeOptions opt = new ChromeOptions();
			
			opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

			
	//l		opt.addArguments("window-size=1400,800");

		//	opt.addArguments("--headless");

			WebDriverManager.chromedriver().version("2.40").setup();

			driver = new ChromeDriver(opt);
			/*
			 * WebDriverManager.chromedriver().version("2.40").setup(); driver = new
			 * ChromeDriver();
			 */
		} else if (prop.getProperty("browser").equals("ff")) {

			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("url"));

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		page = new BasePage(driver);

	}

	@AfterTest()
	public void teardown() {
		//driver.quit();
	}

}
