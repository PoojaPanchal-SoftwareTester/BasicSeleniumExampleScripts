package TestPages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {

		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
		 ChromeOptions option = new ChromeOptions();
		 option.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		  driver= new ChromeDriver(option);
		  driver.get("https://the-internet.herokuapp.com/upload");
	       
	       driver.manage().window().maximize();
	       
	       driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\pujap\\OneDrive\\Desktop\\1.jpeg");
	       
	       driver.findElement(By.xpath("//input[@id='file-submit']")).submit();
	       
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	       String result= wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3"))).getText();
	       
	  
	     
	     if(result.equalsIgnoreCase("File Uploaded!"))
	     {
	    	System.out.print("Image Successfully Uploaded") ;
	    	
	     }
	     else
	     {
	    	 System.out.print("Image is not Successfully Uploaded") ;
	     }
	     
	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(screenshotFile , new File("C:\\Users\\pujap\\eclipse-workspace\\SeleniumScript\\src\\ScreenShots\\FileSuccessfullyUpload.png"));
	     
	          
	     driver.quit();
	}

}
