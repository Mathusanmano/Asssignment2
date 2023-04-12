package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sauceDemoAssignment {
	
	public  static WebDriver driver; 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Access & Login the SauceDemo page
		  WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();//through Chrome driver 
	        driver.manage().window().maximize();//(Maximize the window)
	        driver.get("https://www.saucedemo.com");//(Go through site's URL)
	        
	        
	        WebElement username = driver.findElement(By.id("user-name"));  
			username.sendKeys("performance_glitch_user");
			
			WebElement Password = driver.findElement(By.id("password"));
			Password.sendKeys("secret_sauce");
			
			WebElement loginbutton = driver.findElement(By.id("login-button"));
			loginbutton.click();
			
			
			//check the prize product 
          WebElement SaucelabsFleeceJacket = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[2]/div[2]/div"));
          String Prize = SaucelabsFleeceJacket.getText();
          try {
			Assert.assertEquals(Prize, "$49.99");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
          System.out.println("Prize of FleeceJacket is" + Prize);
          System.out.println();
          
          
          //Add the Cards for 2 items
          WebElement addcard1 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
          addcard1.click();
          String newaddcard1 = (driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"))).getText();
          
          WebElement addcard2 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
          addcard2.click();
          String newaddcard2 = driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).getText();
          
         
          //Click the card icon on the top
          WebElement topicon = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
          topicon.click();
          
          //Verify the the selected items are in the cart
          String Mycard01 =(driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"))).getText();
          
          String Mycard02 = (driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div"))).getText();
          
          try {
        	  Assert.assertEquals(newaddcard1, Mycard01);
        	  Assert.assertEquals(newaddcard2, Mycard02);
        	  
          }catch (Exception e) {//TODO:handle exception}
        	  
       Thread.sleep(2000);
        	 
       
       //Click the Checkout button
        WebElement Checkoutbutton = driver.findElement(By.id("checkout"));
        Checkoutbutton.click();
        
        //Provide the FirstName,LastName & Zipcode
        WebElement FirstName = driver.findElement(By.id("first-name"));
        FirstName.sendKeys("Mathusan");
        
        WebElement LastNmae = driver.findElement(By.id("last-name"));
        LastNmae.sendKeys("Manoharan");
        
        WebElement Zipcode = driver.findElement(By.id("postal-code"));
        Zipcode.sendKeys("10");
        
        //Click the continue Button
        WebElement Continuebutton = driver.findElement(By.id("continue"));
        Continuebutton.click();
        
        //Click the Finish Button
        WebElement Finishbutton = driver.findElement(By.id("finish"));
        Finishbutton.click();
        
        
        }
	}
	

}
