package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheckbox {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/radio.html");
		System.out.println("title of the page is " + driver.getTitle());
		WebElement radioButton = driver.findElement(By.id("vfb-7-2"));
		radioButton.click();
		System.out.println("radio button text : "+radioButton.getText());
		WebElement Checkbox = driver.findElement(By.id("vfb-6-2"));
		Checkbox.click();
		System.out.println("checkbox text : "+Checkbox.getText());
		driver.close();

	}
}
