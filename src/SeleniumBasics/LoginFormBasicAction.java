package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFormBasicAction {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/login.html");
		System.out.println("title of the page is " + driver.getTitle());
		WebElement email = driver.findElement(By.id("email"));
		WebElement pwd = driver.findElement(By.id("passwd"));
		System.out.println("entering the values");
		email.sendKeys("test@gmail.com");
		pwd.sendKeys("test123");
		System.out.println("clearing the values");
		email.clear();
		pwd.clear();
		System.out.println("re-entering the values");
		email.sendKeys("retest@gmail.com");
		pwd.sendKeys("retest123");
		driver.findElement(By.id("SubmitLogin")).click();
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.close();
	}
}
