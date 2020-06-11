package SeleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		System.out.println("title of the page is " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//td[@class='heading3']")).getText());
		driver.findElement(By.name("cusid")).sendKeys("5656");
		driver.findElement(By.name("submit")).click();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
		driver.findElement(By.name("submit")).click();
		alt.accept();
		System.out.println(alt.getText());
		alt.accept();
		System.out.println("title of the page is "
				+ driver.findElement(By.xpath("//div[@id='site-name']//a[@title='Home']")).getText());
		driver.close();
	}
}
