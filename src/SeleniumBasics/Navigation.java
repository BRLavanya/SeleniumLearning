package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
		System.out.println("navigating back page");
		driver.navigate().back();
		System.out.println(driver.getTitle());
		System.out.println("navigating forward");
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
