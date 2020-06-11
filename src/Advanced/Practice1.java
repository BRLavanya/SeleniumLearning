package Advanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement optionSelected = driver.findElement(By.id("checkBoxOption3"));
		optionSelected.click();
		String optValue = driver.findElement(By.xpath("//input[@id='checkBoxOption3']//parent::label")).getText();
		Select sct = new Select(driver.findElement(By.id("dropdown-class-example")));
		sct.selectByVisibleText(optValue);
		WebElement alertName = driver.findElement(By.id("name"));
		alertName.click();
		alertName.sendKeys(optValue);
		driver.findElement(By.id("alertbtn")).click();
		Alert alt = driver.switchTo().alert();
		String alertMessage = alt.getText();
		alt.accept();
		if (alertMessage.contains(optValue)) {
			System.out.println("option selected is present in alert");
		} else {
			System.out.println("option selected is not present in alert");
		}
		driver.close();

	}
}
