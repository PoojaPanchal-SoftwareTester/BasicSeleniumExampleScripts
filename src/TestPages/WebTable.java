package TestPages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable {
	static WebDriver driver;

	public WebTable()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
	
	}
	public static void main(String[] args) 
	{
		
		WebTable obj = new WebTable();
		//obj.readTableData();
		//obj.dynamicTableData();
		obj.sortTable();
	}
	
	public static void readTableData()
	{
		try {
			
		
		  WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
		  List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
			
			for (int i = 1; i <rows.size(); i++) 
			{
				 WebElement row = rows.get(i);
				 
				List<WebElement> cols =  row.findElements(By.tagName("td"));
				
				String Last_Name=cols.get(0).getText();
				String First_Name=cols.get(1).getText();
				String Email=cols.get(2).getText();
				String Due=cols.get(3).getText();
				String Web_Site=cols.get(4).getText();
				String Action=cols.get(5).getText();
				
				System.out.println("Last_Name: "+Last_Name+", First_Name: "+First_Name+", Email: "+Email+", Due: "+Due+", Web_Site: "+Web_Site+", Action: "+Action);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("error while testing "+e.getMessage());
		}
		
		finally
		{
			driver.quit();
		}
	}
	//dynamic table data   method
	public static void dynamicTableData()
	{
		try {
			
			
			  WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
			  List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
			  
			  for (int i = 1; i < rows.size(); i++) 
			  {
				  WebElement row = rows.get(i);
				  
				List<WebElement> cols =  row.findElements(By.tagName("td"));
				String value = cols.get(5).findElement(By.xpath("//td/a[2]")).getText();
				//System.out.println("value is: "+ value);
				
				
				  if(cols.get(1).getText().equalsIgnoreCase("Jason"))
				  { 
					  Thread.sleep(Duration.ofSeconds(30));
					  cols.get(5).findElement(By.xpath("//td/a[2]")).click();
					  //row.click();
					  break; 
				  }
				 
			  }
		}
		catch(Exception e)
		{
			System.out.println("Error while testing: "+ e.getMessage());
		}
		finally
		{
			driver.quit();
		}
	}
	//sorting header method
	public static void sortTable()
	{
		try {
			
			
			  WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
			  List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
			  
			  
				//first name header sort
			WebElement header =
			driver.findElement(By.xpath("//table[@id='table1']//tr[1]//th[1]"));
		    header.click();
				 
		}
		catch(Exception e)
		{
			System.out.println("Error while testing: "+ e.getMessage());
		}
	}
	
	

}
