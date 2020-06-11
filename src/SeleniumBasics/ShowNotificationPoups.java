package SeleniumBasics;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ShowNotificationPoups {
	public static void main(String[] args) {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "chrome");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");

		ChromeOptions opt = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();
		contentSettings.put("notifications", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		opt.setExperimentalOption("prefs", prefs);

		caps.setCapability(ChromeOptions.CAPABILITY, opt);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(caps);
		driver.get(
				"https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwiP9I-PyL3pAhWYdmAKHWBzCksYABACGgJ0bQ&ohost=www.google.com&cid=CAESQOD2Cxdmc-7yFHKhfwiBlX-Nak6kIx_TuhD5scJKO3WOKkpjQg2bXb6mABVKpc7jZyB7ElGLOB8lY7mZLsPqgEM&sig=AOD64_3O4ksuh1fLiKA_hX8qN76OACrs5Q&q=&ved=2ahUKEwjI3oePyL3pAhWXyDgGHZ0TA8oQ0Qx6BAgSEAE&adurl=");
	}
}
