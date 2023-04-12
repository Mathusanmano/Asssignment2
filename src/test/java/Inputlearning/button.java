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

public class button {
	public  static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create the ExtentReports and Attached reporters
	      ExtentReports extent = new ExtentReports();
	      ExtentHtmlReporter htmlreporter =new ExtentHtmlReporter(".\\src\\test\\resources\\extentreport.html");
	      extent.attachReporter(htmlreporter);
	      
	      //Create a toggle for the given test,adds all log events under it 
	      ExtentTest test1 = extent.createTest("letcodeinbutton page","this is first test");
	      
	    //Access & Login the letcodein page
		  WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();//through Chrome driver 
	        driver.manage().window().maximize();//(Maximize the window)
	       
	        test1.log(Status.INFO,"Starting testcase");
	        driver.get("https://letcode.in/");//(Go through site's URL)
	        test1.pass("Navigated to letcode.in");
	        
	        WebElement workspace = driver.findElement(By.id("testing"));
	        workspace.click();
	        test1.pass("workspace");
	        
	        WebElement input = driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[2]/app-menu/div/footer/a"));
	        input.click();
	        test1.pass("click button");
	        
	      //Calling flush writes everything to the file 
			extent.flush();
	}

}
