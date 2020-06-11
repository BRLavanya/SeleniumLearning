package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownUsingBootstrap {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(75, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_14#");
		System.out.println("page heading is " + driver.getTitle());
		driver.findElement(By.id("btnDropdownDemo")).click();
		List<WebElement> dropDownList = driver.findElements(By.xpath("//a[@class='dropdown-item']"));
		for (int i = 0; i < dropDownList.size(); i++) {
			if (dropDownList.get(i).getText().equals("Excel")) {
				WebDriverWait wait = new WebDriverWait(driver, 25);
				wait.ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.visibilityOf(dropDownList.get(i)));
				dropDownList.get(i).click();
			}
		}
		System.out.println("page heading is " + driver.getTitle());
		driver.navigate().back();
		driver.close();
	}
}
