package com.hospitality.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	
		public TestBase() throws IOException
		{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\GitBookingClap\\bookingclap\\TestBookingClap\\src\\main"
					+ "\\java\\com\\hospitality\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
			driver=new ChromeDriver();

		}else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver","D://geckodriver.exe");

			driver=new FirefoxDriver();

		}

		// Initializing EventFiringWebDriver using Firefox WebDriver instance
				  e_driver = new EventFiringWebDriver(driver);

				// Now create object of EventListerHandler to register it with EventFiringWebDriver
				// eventListener = new WebEventListener();

				//e_driver.register(eventListener);
				//driver= e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}

