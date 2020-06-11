package AddingItemsToaCart;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(75, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemList = { "Cucumber", "Pumpkin" };
		List<WebElement> productList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < productList.size(); i++) {
			String[] name = productList.get(i).getText().split("-");
			String formattedName = name[0].trim();
			System.out.println(formattedName);
			List ItemsneededList = Arrays.asList(itemList);
			System.out.println("******************");
			if (ItemsneededList.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
			}
		}
	}
}