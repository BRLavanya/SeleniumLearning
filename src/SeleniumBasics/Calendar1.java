package SeleniumBasics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar1 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/");
		System.out.println("page heading is " + driver.getTitle());
		String date = "01012020";
		String time = "1200AM";
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement dateTime = driver.findElement(By.xpath("//input[@type='datetime-local']"));
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(dateTime));
		dateTime.sendKeys(date, Keys.TAB);
		dateTime.sendKeys(time);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("C:\\Users\\SONY\\Projects\\SeleniumWebdriverLearning\\screenshot\\calendar1.png"));

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver
				.findElement(By.xpath("//body[contains(@style,'Quicksand')]//div[contains(@style,'15px')]")).getText());
		driver.close();
	}
}
