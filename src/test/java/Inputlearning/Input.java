package Inputlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Input {
	public  static WebDriver driver;
	public static void main(String[] args) {
		
		
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
	        
	        WebElement input = driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[1]/app-menu/div/footer/a"));
	        input.click();
	        test1.pass("click input");
	        
	        //Enter your full name 
	        try {
	        	WebElement Fullname = driver.findElement(By.id("fullName"));
	        	boolean value = Fullname.isDisplayed();
	        	Fullname.sendKeys("Mathusan Manoharan");
	        	test1.pass("Right Full Name");
			} catch (Exception e) {
				test1.fail("Right Full Name");
			}
	        
	        //Append a text and press keyboard tab
	        try {
	        	WebElement Appendtext = driver.findElement(By.id("join")); 
	        	boolean value = Appendtext.isDisplayed();
	        	Appendtext.sendKeys("Person",Keys.TAB);
	        	test1.pass("Appendtext text");
	        }catch (Exception e) {
				test1.fail("Appendtext text");
			}
	       
	        //what is inside the text box
	        try { WebElement textbox = driver.findElement(By.id("getMe")); 
	             boolean value = textbox.isDisplayed();
	             textbox.getAttribute("value");
	             System.out.println(value);
	             test1.pass("Inside the textbox");
	        
	        } catch (Exception e) {
				test1.fail("Inside the textbox");
			}
	        
	        //clear the text
	        try { WebElement cleartext = driver.findElement(By.id("clearMe")); 
	        boolean value = cleartext.isDisplayed();
	        cleartext.clear();
	        test1.pass("clear the text");
	        }catch (Exception e) {
				test1.fail("clear the text");
			}
	        
	        //Confirm the edit field is disabled 
	        WebElement Disabledbox = driver.findElement(By.id("noEdit"));
	        boolean value1 = Disabledbox.isEnabled();
	        System.out.println(value1);
	        test1.pass("Disabledbox");
	       
	        //Confirm Button Readonly
	        WebElement ReadonlyButton = driver.findElement(By.id("dontwrite"));
	        String Button1 = ReadonlyButton.getAttribute("value");
	        System.out.println(Button1);
	        test1.pass("Confirm button Read only");
	       
	        
	        // Another method Confirm the edit field is disabled
	        boolean value2 = driver.findElement(By.id("noEdit")).isEnabled();
	        System.out.println(value2);
	        test1.pass("disabled1");
	        
	        // Another method Confirm Button Readonly
	        String Button2 = driver.findElement(By.id("dontwrite")).getAttribute("value");
	        System.out.println(Button2);
	        test1.pass("Read only 2");
	        
	        //click quite browser
	        driver.quit();
	        test1.pass("quite browser");
	        
	        
	        //Calling flush writes everything to the file 
			extent.flush();
	}

}
