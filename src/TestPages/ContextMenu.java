package TestPages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {
	
	static WebDriver driver;
	
	
   public ContextMenu()
   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	   ChromeOptions options = new ChromeOptions();
	   options.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
	   driver = new ChromeDriver(options);
	   driver.get("https://the-internet.herokuapp.com/context_menu");
	   driver.manage().window().maximize();
   }
	
	public static void main(String[] args) 
	{
		ContextMenu obj = new ContextMenu();
		obj.runTest();
		
	}

	
	public void runTest()
	{
		try {
			Actions action  = new Actions(driver);
			
			WebElement target_element = driver.findElement(By.xpath("//div[@id ='hot-spot']"));
			
			action.contextClick(target_element).perform();
			
			Alert alert = driver.switchTo().alert();
			
			String msg = alert.getText();
			
			//System.out.println("message is "+msg);
			
			if(msg.equalsIgnoreCase("You selected a context menu"))
			{
				alert.accept();
			}
			
		} catch (Exception e) 
		{
            captureScreenShot("ContextMenu");
			System.out.println("Test failed. Screenshot captured. "+e.getMessage());
		}
		finally {
			driver.quit();
		}
		
	}
	
	public static void captureScreenShot(String ScreenshotName)
	{
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(screenshot, new File("C:\\Users\\pujap\\eclipse-workspace\\SeleniumScript\\src\\ScreenShots\\"+ScreenshotName+".png"));
		} catch (Exception e) {
			System.out.println("Unabled to captured. "+e.getMessage());
		}
		
	}

	

}
