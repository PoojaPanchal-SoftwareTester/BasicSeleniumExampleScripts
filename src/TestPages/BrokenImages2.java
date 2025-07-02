package TestPages;

import java.lang.classfile.instruction.ConstantInstruction.ArgumentConstantInstruction;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenImages2 {

	public static WebDriver driver;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		driver= new ChromeDriver(option);
		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		for (WebElement image : images) 
		{
			String imageUrl = image.getAttribute("src");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			long naturalwidth = (long)js.executeScript("return arguments[0].naturalWidth", image);
			
			if(naturalwidth == 0)
			{
				System.out.println("Broken image is "+imageUrl);
			}
			else {
				System.out.println("Image is not broken "+imageUrl);
			}
		}
		
		driver.quit();

	}
	
	

}
