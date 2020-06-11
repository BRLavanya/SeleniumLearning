package SeleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavascriptHighlightElements {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("title is " + driver.getTitle());
		System.out.println("current url is " + driver.getCurrentUrl());
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\SONY\\Projects\\SeleniumWebdriverLearning\\src\\SeleniumBasics\\config.properties");
		prop.load(fis);
		WebElement gmail = driver.findElement(By.xpath(prop.getProperty("gmail")));
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(gmail));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgcolor = gmail.getCssValue("backgroundColor");
		String color = "rgb(0,200,0)";
		for (int i = 0; i < 5; i++) {
			js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", gmail);
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(
					"C:\\Users\\\\SONY\\Projects\\SeleniumWebdriverLearning\\screenshot\\higlight" + i + ".png"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].style.backgroundColor = '" + bgcolor + "'", gmail);

		}
		driver.close();

	}
}
