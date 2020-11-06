package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestCopy {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname
    	DesiredCapabilities capabilities = null;
    	
    	
    	
    	 if(System.getProperty("BROWSER") != null &&
                 System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
    		 capabilities = DesiredCapabilities.firefox();
    		 System.setProperty("webdriver.gecko.driver","C:\\Users\\kulkarni.s\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
    		 driver = new FirefoxDriver(capabilities);
    	 }else {
    		 	System.setProperty("webdriver.ie.driver","C:\\Users\\kulkarni.s\\IEDriverServer.exe");
    		 	capabilities = DesiredCapabilities.internetExplorer();
    		 	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    		 	capabilities.setCapability("requireWindowFocus", true);
    		 	driver= new InternetExplorerDriver(capabilities);  
    	 }
    	 
		driver.manage().window().maximize();  
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    	/*String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://18.224.67.85:4444/wd/hub";
        System.out.println("Complete URl"+completeUrl);
        dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);*/
    	
    	
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }



}
