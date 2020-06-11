package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'International Connection Baggage')]")))
				.click().build().perform();
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		driver.navigate().back();
		System.out.println("title of home page is " + driver.getTitle());
		driver.close();
	}
}
