package TestPages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrag {

	static WebDriver driver;
	
	public DragAndDrag()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
		 ChromeOptions option = new ChromeOptions();
		 option.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		  driver= new ChromeDriver(option);
		
	}
	public static void main(String[] args) {
	       
		DragAndDrag obj = new DragAndDrag();
		obj.runTest();
	      
	}
	
	public static void runTest()
	{
		  driver.get("https://the-internet.herokuapp.com/drag_and_drop");
	       
	       driver.manage().window().maximize();
	       
		 try
	       {
				WebElement from_element = driver.findElement(By.xpath("//div[@id ='column-a']"));
				   
				WebElement target_element = driver.findElement(By.xpath("//div[@id ='column-b']"));
				   
				Actions action = new Actions(driver);
				   
				action.dragAndDrop(from_element, target_element).perform(); 
					       
	       }
	       catch (Exception e) 
	       {
	    	   // If test fails, capture a screenshot
	            captureScreenshot("DragndDrop_Failure_Screenshot");
	            System.out.println("Test failed. Screenshot captured.");
		   }
	       finally 
	       {
	    	   driver.quit();
		   } 
	}
	
	public static void captureScreenshot(String testName)
	{
		try {
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(screenShot, new File("C:\\Users\\pujap\\eclipse-workspace\\SeleniumScript\\src\\ScreenShots\\"+testName+".png"));
			
		} catch (Exception e) {
			System.out.println("Unable to captured."+e.getMessage());
		}
	}

}
