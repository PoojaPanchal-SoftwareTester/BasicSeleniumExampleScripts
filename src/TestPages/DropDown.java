package TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
 
	static WebDriver driver;
	public static void main(String[] args) 
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pujap\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
		 ChromeOptions option = new ChromeOptions();
		 option.setBinary("C:\\Users\\pujap\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		  driver= new ChromeDriver(option);
		  driver.get("https://the-internet.herokuapp.com/dropdown");
	       
	       driver.manage().window().maximize();
	       
	       Select dropdown = new Select(driver.findElement(By.xpath("//select[@id ='dropdown']")));
	       
	      // getOptions(dropdown);
	       //selectByIndex(dropdown);
	      // selectByValue(dropdown);
	       //selectByVisibleText(dropdown);
	      // getFirstSelectedOption(dropdown);
	       getAllSelectedOptions(dropdown);
	       
	     
	}
	
	public static void getOptions(Select op_list)
	{
		 List<WebElement> options =  op_list.getOptions();
	      
	      for (WebElement options_list : options)
	      {
	    	 String result=  options_list.getText();
	    	
	    	 
	    	 if(result.equalsIgnoreCase("Option 1"))
	    	 {
	    		 options_list.click();
	    	 }
		  }
	}
	
	
	public static void selectByIndex(Select op_list)
	{
		op_list.selectByIndex(2);
	}
	
	public static void selectByValue(Select op_list)
	{
		op_list.selectByValue("1");
	}
	public static void selectByVisibleText(Select op_list)
	{
		op_list.selectByVisibleText("Option 2");
	}
	
	public static void getFirstSelectedOption(Select op_list)
	{
	  WebElement result = 	op_list.getFirstSelectedOption();
	  String result_value =  result.getText();
	  System.out.println("First selected value is "+result_value);
	}
	public static void getAllSelectedOptions(Select op_list)
	{
	 List<WebElement> results= 	op_list.getAllSelectedOptions();
	 for (WebElement results_value : results) 
	 {
		 String value =  results_value.getText();
		 System.out.println("All selected value is "+value);
	 }
	 
	}
	
	
}
