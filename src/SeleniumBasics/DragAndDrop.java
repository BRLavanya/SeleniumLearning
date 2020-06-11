package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println("page title is " + driver.findElement(By.xpath("//h1")).getText());
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		System.out.println(
				"Before dropping messgae is " + driver.findElement(By.xpath("//div[@id='droppable']//p")).getText());
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(By.id("draggable"))).moveToElement(driver.findElement(By.id("droppable")))
				.release().build().perform();
		System.out.println(
				"After dropping messgae is " + driver.findElement(By.xpath("//div[@id='droppable']//p")).getText());
		driver.switchTo().defaultContent();
		System.out.println("page title is : " + driver.getTitle());
		driver.quit();
	}
}
