package Dropdownlearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
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
       
       //Click the workspace
       WebElement workspace = driver.findElement(By.id("testing"));
       workspace.click();
       test1.pass("workspace");
       
      
      //Click the dropdown 
       WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[3]/app-menu/div/footer/a"));
       dropdown.click();
       test1.pass("dropdown");
       
       //1.select the Mango using visible text
     try {WebElement Fruits = driver.findElement(By.id("fruits"));
          Fruits.click();
          Select myfruits =new Select(Fruits);
          myfruits.selectByVisibleText("Mango");
          test1.pass("select the apple using visible text");
          } catch (Exception e) {
		test1.fail("select the apple using visible text");
	}
       
     //4.Select India using value & print the select value
     try {
    	 WebElement country = driver.findElement(By.id("country"));
    	 country.click();
    	 Select mycountry =new Select(country);
    	 mycountry.selectByVisibleText("India");
    	 test1.pass("Select India using value & print the select value");
    	 
    	 WebElement selectmycountry = mycountry.getFirstSelectedOption();
    	 System.out.println(selectmycountry.getText());
     }catch (Exception e) {
		test1.fail("Select India using value & print the select value ");
	}  
     
     //2.Select your super heros
    try {  WebElement superheros = driver.findElement(By.id("superheros"));
    //superheros.click();
    Select myheros = new Select(superheros);
    boolean multi = myheros.isMultiple();
    System.out.println("is Multiple"+ multi);
    myheros.selectByIndex(0);
    myheros.selectByIndex(1);  
    myheros.selectByValue("bt");
    List<WebElement> allheros = myheros.getAllSelectedOptions();
    test1.pass("Select your super heros");
    }catch (Exception e) {
		test1.fail("Select your super heros");
	} 
     
     //3.Select the last programming language and print all the options IS IMPORTANT
    WebElement programinglanguage = driver.findElement(By.id("lang"));
   // programinglanguage.click();
    Select lastlanguage = new Select(programinglanguage); 
    List<WebElement>lastlanguage5 = lastlanguage.getOptions();
 // System.out.println(lastlanguage5.size());
    lastlanguage.selectByIndex(lastlanguage5.size()-1);
    for (WebElement mathu : lastlanguage5) {
		System.out.println(mathu.getText());
		
	}
    
    
    
    
    
    //Calling flush writes everything to the file 
		extent.flush();  
       
	}

}
