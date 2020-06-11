package SeleniumBasics;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinksAndImages {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(75, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.zlti.com/");
		// 1. get list of all the links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));

		System.out.println("the total links available in the page is " + links.size());

		// 2. get active links
		List<WebElement> ActiveLinks = new ArrayList<WebElement>();
		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getAttribute("href") != null
					&& (!links.get(i).getAttribute("href").contains("javascript"))) {
				ActiveLinks.add(links.get(i));
			}
		}

		System.out.println("the total active links available in the page is " + ActiveLinks.size());

		for (int j = 0; j < ActiveLinks.size(); j++) {
			String url = ActiveLinks.get(j).getAttribute("href");
			System.out.println(url);
			HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
				connection.setRequestMethod("HEAD");
			connection.connect();
			String responseMessage = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(responseMessage);
		}

		driver.close();
	}
}
