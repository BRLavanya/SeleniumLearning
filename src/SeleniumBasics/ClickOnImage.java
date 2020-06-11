package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnImage {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement fb_img=driver.findElement(By.xpath("//u[text()='Facebook']//parent::i"));
		fb_img.click();
		System.out.println("title of the page is "+driver.getTitle());
		System.out.println("current url is "+driver.getCurrentUrl());
	}
}
