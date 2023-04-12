package saucedemo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class swaglap {
	public static String browser = "chrome";
	public static WebDriver driver;
	public static String URL = "https://www.saucedemo.com/";
	

	public void main(String[] args) throws IOException {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		
		//login the system...................
		WebElement username = driver.findElement(By.id("user-name"));  
		username.sendKeys("performance_glitch_user");
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");
		
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		
		 WebElement prizeOfFleeceJacket = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));//(Find path to prizeOfFleeceJacket)
         String Prize = prizeOfFleeceJacket.getText();
         System.out.println("3.Prize of Fleece Jacket is "+ Prize);//(Get prize of FleeceJacket)
		
	}
}
