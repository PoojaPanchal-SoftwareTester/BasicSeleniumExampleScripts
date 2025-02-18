package TestPages;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JqueryMenu {
   static  WebDriver driver;
   
   public JqueryMenu()
   {
	   System.setProperty("webdrvier.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	   ChromeOptions options = new ChromeOptions();
	   options.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
	   driver = new ChromeDriver(options);
	   driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
	   driver.manage().window().maximize();
	   
   }
   
	public static void main(String[] args) 
	{
		JqueryMenu obj = new JqueryMenu();
		obj.runTest();
	}
	
	public static void runTest()
	{
		try {
			
			Actions action = new Actions(driver);
			
			boolean enabled_menu_visibility = driver.findElement(By.xpath("//ul[@id='menu']//li[@id='ui-id-3']")).isDisplayed();
			
			if(enabled_menu_visibility)
			{
				WebElement enabled_menu = driver.findElement(By.xpath("//ul[@id='menu']//li[@id='ui-id-3']"));
				action.moveToElement(enabled_menu).perform();
				
				
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-front']//li[@id='ui-id-4']")));
				
				boolean download_submenu_visibility =  driver.findElement(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-front']//li[@id='ui-id-4']")).isDisplayed();
				if(download_submenu_visibility)
				{
					//System.out.println("innn");
					WebElement download_submenu = driver.findElement(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-front']//li[@id='ui-id-4']"));
					action.moveToElement(download_submenu).perform();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-front']//li[@id='ui-id-7']")));
					
					boolean excel_submenu_visibility =  driver.findElement(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-front']//li[@id='ui-id-7']")).isDisplayed();
					
					if(excel_submenu_visibility)
					{
						WebElement excel_submenu = driver.findElement(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-front']//li[@id='ui-id-7']"));
						excel_submenu.click();
					}
				}
				
				
			}
			
			
		} catch (Exception e) 
		{
			captureScreenShot("JqueryMenu");
			System.out.println("Error while testing "+e.getMessage());
		}
		finally {
			driver.quit();
		}
	}
	
	public static void captureScreenShot(String imageName)
	{
		try
		{
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("C:\\Users\\pujap\\eclipse-workspace\\SeleniumScript\\src\\ScreenShots\\"+imageName+".png"));
		}
		catch(Exception e)
		{
			System.out.println("Unable to captured "+e.getMessage());
		}
		
	}
	
	

}
