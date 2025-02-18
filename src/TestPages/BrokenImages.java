package TestPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenImages {

	static WebDriver driver;
	
	public BrokenImages()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
		 ChromeOptions option = new ChromeOptions();
		 option.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		  driver= new ChromeDriver(option);
		  
	}
	public static void main(String[] args) 
	{
		BrokenImages obj = new BrokenImages(); 
		obj.runTest();
	}
	
	public void runTest()
	{
		try {
			driver.get("https://the-internet.herokuapp.com/broken_images");
		       
		    driver.manage().window().maximize();
		    
		  List<WebElement>  image_list =  driver.findElements(By.tagName("img"));
		  
		for (WebElement image  : image_list) 
		{
			String imageURL = image.getAttribute("src");
			
			//Thread.sleep(Duration.ofSeconds(30));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Long naturalWidth = (Long) js.executeScript("return arguments[0].naturalWidth", image);
			
			if(naturalWidth == 0)
			 {
                System.out.println("Broken image found: " + imageURL);
            } else {
                System.out.println("Image loaded successfully: " + imageURL);
            }
		}
		  
		} catch (Exception e) {
			 System.out.println("Error while checking image:" + e.getMessage());
		}
		finally {
			driver.quit();
		}
		
	}
}
