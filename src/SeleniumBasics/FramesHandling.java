package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandling {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.switchTo().frame("a077aa5e");
		String src = driver.findElement(By.xpath("//a//img")).getAttribute("src");
		System.out.println("src is " + src);
		driver.switchTo().defaultContent();
		System.out.println("heading is " + driver.findElement(By.xpath("//h2//font")).getText());
		driver.quit();
	}
}
