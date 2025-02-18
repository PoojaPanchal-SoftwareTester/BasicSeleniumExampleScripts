package TestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyPress {
	 static WebDriver driver;
	   
	   public KeyPress()
	   {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\pujap\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\\\Users\\\\pujap\\\\Downloads\\\\chrome-win64\\\\chrome-win64\\\\chrome.exe");
			driver = new ChromeDriver(options);
			driver.get("https://the-internet.herokuapp.com/key_presses");
			driver.manage().window().maximize();
	   }
	   
	public static void main(String[] args) 
	{
		KeyPress obj = new KeyPress(); 
		obj.runTest();
	}
	
	public static void runTest()
	{
		try
		{
			WebElement input_box = driver.findElement(By.xpath("//input[@id='target']"));
			//input_box.sendKeys("selenium");
			//input_box.sendKeys(Keys.BACK_SPACE);
			
		    // Create an Actions object
	        Actions actions = new Actions(driver);

	        
	        actions.keyDown(input_box, Keys.SHIFT)
	        .sendKeys("selenium")
	        .keyUp(input_box,  Keys.SHIFT)
	        .perform();
	        
	    
		}
		catch(Exception e)
		{
			System.out.println("Error while testing "+e.getMessage());
		}
	}
	

}
