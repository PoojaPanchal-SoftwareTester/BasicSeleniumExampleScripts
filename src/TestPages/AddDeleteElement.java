package TestPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddDeleteElement {
	static WebDriver driver;

	public AddDeleteElement()
	{
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		
		driver = new ChromeDriver(options);
		
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		driver.manage().window().maximize();
	}
	
	public static void main(String[] args)
	{
		AddDeleteElement obj = new AddDeleteElement();
		obj.runTest();
	}
	
	public void runTest()
	{
		
		try
		{
			system.out
		
		WebElement addButton = driver.findElement(By.xpath("//div[@class='example']/button"));
		
		if(addButton.isDisplayed())
		{
			for (int i = 0; i <=2; i++) 
			{
				addButton.click();
			}
		
		}
		
		Thread.sleep(Duration.ofSeconds(30));
		List<WebElement> deleteButton = driver.findElements(By.xpath("//div[@id='elements']/button"));
		
		for (WebElement button : deleteButton) 
		{
			button.click();
		}
		//div[@id='elements']/button
		}
		catch (Exception e) 
		{
			System.out.println("Error while checking "+e.getMessage());
		}
		finally {
			driver.quit();
		}
	}

}
