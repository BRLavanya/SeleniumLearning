package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropEx2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		WebElement drag1 = driver.findElement(By.xpath("//a[contains(text(),'BANK ')]"));
		WebElement drop1 = driver.findElement(By.xpath("//ol[@id='bank']//li"));
		WebElement drag2 = driver.findElement(By.xpath("//a[contains(text(),'SALES')]"));
		WebElement drop2 = driver.findElement(By.xpath("//ol[@id='loan']//li"));
		WebElement drag3 = driver.findElement(By.xpath("//li[@id='fourth']//a[contains(text(),'5000')]"));
		WebElement drop3 = driver.findElement(By.xpath("//ol[@id='amt7']//li"));
		WebElement drop4 = driver.findElement(By.xpath("//ol[@id='amt8']//li"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag1, drop1).build().perform();
		act.dragAndDrop(drag2, drop2).build().perform();
		act.dragAndDrop(drag3, drop3).build().perform();
		act.dragAndDrop(drag3, drop4).build().perform();
		String ActualText = driver.findElement(By.xpath("//div[@id='equal']//a")).getText();
		System.out.println(ActualText);
		if ("Perfect!".equals(ActualText)) {
			System.out.println("the text matches");
		} else {
			System.out.println("not a match");
		}
		driver.quit();

	}
}
