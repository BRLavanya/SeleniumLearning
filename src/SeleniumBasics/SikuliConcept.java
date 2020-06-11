package SeleniumBasics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliConcept {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(75, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String path = System.getProperty("user.dir") + "\\sikuli_Images\\";
		System.out.println(path);
		Screen s = new Screen();
		System.out.println("hello");
		Pattern pause = new Pattern(path + "pause.png");
		Pattern settings = new Pattern(path + "settings.png");
		Pattern quality = new Pattern(path + "quality.png");
		Pattern resolution = new Pattern(path + "resolution.png");
		Pattern play = new Pattern(path + "play.png");

		driver.get("https://www.youtube.com/watch?v=OtQAMoXYqes&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=22");

		s.wait(pause, 20);
		s.click();
		s.click();

		s.wait(settings, 20);
		s.click();

		s.wait(quality, 20);
		s.click();

		s.wait(resolution, 20);
		s.click();

		s.wait(play, 20);
		s.click();

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("C:\\Users\\SONY\\Projects\\SeleniumWebdriverLearning\\screenshot\\skiluli.png"));
	}
}
