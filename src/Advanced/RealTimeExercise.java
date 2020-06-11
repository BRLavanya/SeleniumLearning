package Advanced;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealTimeExercise {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List LinksCount = driver.findElements(By.xpath("//a"));
		System.out.println("nummber of links in the page is " + LinksCount.size());

		List FooterCount = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		System.out.println("number of links in the footer of the page is " + FooterCount.size());

		WebElement firsColumnFooterCount = driver.findElement(By.xpath("//div[@id='gf-BIG']//td[1]"));
		System.out.println("number of links in the footer of the first of the colums is "
				+ firsColumnFooterCount.findElements(By.tagName("a")).size());

		for (int i = 1; i < firsColumnFooterCount.findElements(By.tagName("a")).size(); i++) {
			String newtab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firsColumnFooterCount.findElements(By.tagName("a")).get(i).sendKeys(newtab);
			Set<String> childwindow = driver.getWindowHandles();
			Iterator<String> it = childwindow.iterator();
			String parentWindow = it.next();
			while (it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println("page heading is " + driver.getTitle());
				driver.close();
			}


		}

		driver.quit();

	}

}
