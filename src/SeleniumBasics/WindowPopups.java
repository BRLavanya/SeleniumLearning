package SeleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopups {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[text()='Good PopUp #2']")).click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String ParenWindowID = it.next();
		while (it.hasNext()) {
			String childWindowId = it.next();
			driver.switchTo().window(childWindowId);
			System.out.println("current url " + driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			driver.close();
		}
		driver.switchTo().window(ParenWindowID);
		System.out.println("current url " + driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
	}
}
