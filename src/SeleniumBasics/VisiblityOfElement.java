package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisiblityOfElement {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("u_0_2")).click();
		WebElement gender = driver.findElement(By.id("u_2_4"));
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(gender));
		gender.click();
		boolean status = gender.isSelected();
		System.out.println("radio button is selected: " + status);
		boolean statusIsdisplayed = driver.findElement(By.id("u_2_s")).isDisplayed();
		System.out.println("signup button is displayed or not ? " + statusIsdisplayed);
		driver.close();
	}
}
