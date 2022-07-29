package com.qa.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qa.pageLayer.DashboardPage;
import com.qa.pageLayer.LoginPage;
import com.qa.pageLayer.TradingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	
	public LoginPage login;
	public DashboardPage dash;
	public TradingPage trade;
	
	@BeforeClass
	public void start()
	{
		logger = Logger.getLogger("Automation testing framework");
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("Framework execution started");
	}
	
	@AfterClass
	public void stop()
	{
		logger.info("Framework execution Stopped");
	}
	
	@BeforeMethod
	public void setUp()
	{
		String br = "chrome";              
		
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome launches");
		}
		else if (br.equalsIgnoreCase("firefox"))	
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else 
		{
			System.out.println("Please provide proper browser name from chrome, firefox, edge");
		}
		
		driver.get("https://www.apps.dalalstreet.ai/login");
		logger.info("url launches");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		logger.info("maximized browser provided proper waits");
		
		
		 login = new LoginPage();
		login.enterEmailAddress("amarwaghmare573@gmail.com");
		login.enterPassword("Test@1234");
		login.clickOnLogin();
		logger.info("logged in");
		
		//object creation
		
		dash = new DashboardPage();
		trade = new TradingPage();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("browser closed");
	}
}
