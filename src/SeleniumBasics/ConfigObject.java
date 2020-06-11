package SeleniumBasics;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigObject {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\SONY\\Projects\\SeleniumWebdriverLearning\\src\\SeleniumBasics\\config.properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("gmail"))).click();
		driver.findElement(By.xpath(prop.getProperty("createAccount"))).click();
		WebElement FirstName = driver.findElement(By.id(prop.getProperty("fName")));
		WebElement LastName = driver.findElement(By.id(prop.getProperty("lName")));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(FirstName));
		FirstName.sendKeys(prop.getProperty("fname"));

		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(LastName));
		LastName.sendKeys(prop.getProperty("lname"));

		driver.findElement(By.xpath(prop.getProperty("next"))).click();
	}
}
