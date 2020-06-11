package SeleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowPopupsEx2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.ignoring(StaleElementReferenceException.class).until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Multi-PopUp Test']"))))
				.click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowHandles = it.next();
		while (it.hasNext()) {
			String childWindowHandles = it.next();
			driver.switchTo().window(childWindowHandles);
			System.out.println("current url " + driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			driver.close();
		}
		driver.switchTo().window(parentWindowHandles);
		System.out.println("current url " + driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
	}
}
