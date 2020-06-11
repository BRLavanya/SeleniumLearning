package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatBot {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(75, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(
				"https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwiP9I-PyL3pAhWYdmAKHWBzCksYABACGgJ0bQ&ohost=www.google.com&cid=CAESQOD2Cxdmc-7yFHKhfwiBlX-Nak6kIx_TuhD5scJKO3WOKkpjQg2bXb6mABVKpc7jZyB7ElGLOB8lY7mZLsPqgEM&sig=AOD64_3O4ksuh1fLiKA_hX8qN76OACrs5Q&q=&ved=2ahUKEwjI3oePyL3pAhWXyDgGHZ0TA8oQ0Qx6BAgSEAE&adurl=");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe_fuguWidgetContent']")));

		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("hippo-chat-icon"))));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("hippo-chat-icon"))).build().perform();
		driver.findElement(By.id("hippo-chat-icon")).click();

		driver.findElement(By.xpath("//div[@id='fuguLauncherContainer']//div//img[@class='cancel-icon']")).click();

	}
}
