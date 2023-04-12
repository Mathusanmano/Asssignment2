package Inputlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extentReport {

	public  static WebDriver driver; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub.
    
      //Create the ExtentReports and Attached reporters
      ExtentReports extent = new ExtentReports();
      ExtentHtmlReporter htmlreporter =new ExtentHtmlReporter(".\\src\\test\\resources\\extentreport.html");
      extent.attachReporter(htmlreporter);
      
      //Create a toggle for the given test,adds all log events under it 
      ExtentTest test1 = extent.createTest("sauceDemoAssignment","this is first test");
      
      
    //Access & Login the SauceDemo page
	  WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//through Chrome driver 
        driver.manage().window().maximize();//(Maximize the window)
       
        test1.log(Status.INFO,"Starting testcase");
        driver.get("https://www.saucedemo.com");//(Go through site's URL)
        test1.pass("Navigated to Saucedemo.com");
        
        WebElement username = driver.findElement(By.id("user-name"));  
		username.sendKeys("performance_glitch_user");
		test1.pass("Entered username in usernamebox ");
		
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");
		test1.pass("Entered password in passworbox");
		
		
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		test1.pass("login the page");
		test1.info("Test Completed");
		
		//Calling flush writes everything to the file 
		extent.flush();
	}

}
