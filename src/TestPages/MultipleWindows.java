package TestPages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

public class MultipleWindows 
{
   static WebDriver driver;
   
   public MultipleWindows()
   {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\pujap\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\\\Users\\\\pujap\\\\Downloads\\\\chrome-win64\\\\chrome-win64\\\\chrome.exe");
		driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
   }
   
	public static void main(String[] args) 
	{
		MultipleWindows obj = new MultipleWindows();
		obj.runTest();		
	}
	
	public static void runTest()
	{
		try {
			
			
	   		
			   String current_window = driver.getWindowHandle();
			
				WebElement button = driver.findElement(By.xpath("//div[@class='example']//a"));
				button.click();
				
			Set<String> new_window = 	driver.getWindowHandles();
			
			for (String window : new_window) 
			{
				if(!window.equals(current_window))
				{
					driver.switchTo().window(window);
					break;
				}
			}
			driver.getTitle();
			
			 // Perform actions on the new window
	        System.out.println("Title of the new window: " + driver.getTitle());

	        // Close the new window
	        driver.close();

	        // Switch back to the main window
	        driver.switchTo().window(current_window);

	        // Perform actions on the main window if needed
	        System.out.println("Title of the main window: " + driver.getTitle());

		} catch (Exception e)
		{
			System.out.println("error while testing: "+ e.getMessage());
		}
		finally {
			  // Close the browser
	        driver.quit();
			
		}
	}

}
