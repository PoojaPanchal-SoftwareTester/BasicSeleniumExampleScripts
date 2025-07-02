package TestPages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrokenLinks {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(option);
		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for (WebElement link : links) 
		{
		 String url = 	link.getAttribute("href");
		 
		 if(url!= null && !url.isEmpty())
		 {
			 checkLinkStatus(url);
		 }
		}
		
		driver.quit();
	}
	
	public static void checkLinkStatus(String url) throws IOException
	{
		URL link = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) link.openConnection();
		
		connection.setRequestMethod("HEAD");
		connection.connect();
		int status = connection.getResponseCode();
		
		if(status == 200)
		{
			System.out.println("Valid link "+url+ " Response code is "+status );
		}
		else
		{
			System.out.println("InValid link "+url+ " Response code is "+status);
		}
	}

}
