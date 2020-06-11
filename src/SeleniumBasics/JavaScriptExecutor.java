package SeleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
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

public class JavaScriptExecutor {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\SONY\\Projects\\SeleniumWebdriverLearning\\src\\SeleniumBasics\\config.properties");
		prop.load(fis);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		WebElement gmail = driver.findElement(By.xpath(prop.getProperty("gmail")));
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(gmail));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		border(js, gmail);
		String message = "alert message";
		alertMessage(js, message);
		screenShot(driver);
		Alert alt = driver.switchTo().alert();
		alt.accept();
		driver.close();
	}

	public static void border(JavascriptExecutor js, WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void alertMessage(JavascriptExecutor js, String message) {
		js.executeScript("alert('" + message + "')");
	}

	public static void screenShot(WebDriver driver) throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\SONY\\Projects\\SeleniumWebdriverLearning\\screenshot\\js.png"));

	}
}
