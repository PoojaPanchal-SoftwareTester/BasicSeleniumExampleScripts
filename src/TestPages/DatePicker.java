package TestPages;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {
	static WebDriver driver;

	public DatePicker() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\pujap\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\\\Users\\\\pujap\\\\Downloads\\\\chrome-win64\\\\chrome-win64\\\\chrome.exe");
		driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
	}

	public static void main(String[] args) {
		DatePicker obj = new DatePicker();
		// obj.selectCurrentMonthDate();
		obj.selectNextMonthDate();
	}

	public static void selectCurrentMonthDate() {
		try {

			WebElement iframe = driver.findElement(By.tagName("iframe"));

			driver.switchTo().frame(iframe);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker"))).click();

			WebElement select_date = driver.findElement(By.xpath("//tbody//tr//td//a[contains(text(),'11')]"));
			select_date.click();

		} catch (Exception e) {
			System.out.println("Error while testing: " + e.getMessage());
		}

		finally {
			// driver.quit();
		}
	}

	public static void selectNextMonthDate() {
		try {

			WebElement iframe = driver.findElement(By.tagName("iframe"));

			driver.switchTo().frame(iframe);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker"))).click();

			
			String month = "June";

			WebElement month_title = driver
					.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']"));

			System.out.print("here  "+month_title.getText());
			
			while(!month_title.getText().contains(month))
			{
				System.out.println("i am "+month_title.getText());
				WebElement next_month = driver.findElement(
						By.xpath("//div[@id ='ui-datepicker-div']//div//a[@class='ui-datepicker-next ui-corner-all']"));
				next_month.click();
				 month_title = driver
							.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']"));
				System.out.println("mow "+month_title.getText());
			
			} 

		} catch (Exception e) {
			System.out.println("Error while testing: " + e.getMessage());
		}

		finally {
			// driver.quit();
		}
	}

}
