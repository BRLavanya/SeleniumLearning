package Advanced;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScoreBoardCalculation {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		int RunCount = 0;
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/27378/ms-vs-psz-27th-match-pakistan-super-league-2020");
		List<WebElement> RunsList = driver.findElements(By.xpath(
				"//span[text()='Multan Sultans Innings']//parent::div//following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms']//div[contains(@class,'cb-col cb-col-8 text-right text-bold')]"));
		for (int i = 0; i < RunsList.size(); i++) {
			String Run = RunsList.get(i).getText();
			RunCount += Integer.parseInt(Run);
		}
		String extras = driver.findElement(By.xpath(
				"//span[text()='Multan Sultans Innings']//parent::div//following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms']//div[contains(@class,'cb-col cb-col-8 text-bold cb-text-black text-right')]"))
				.getText();
		RunCount += Integer.parseInt(extras);

		String TotalCount = driver.findElement(By.xpath(
				"//span[text()='Multan Sultans Innings']//parent::div//following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms']//div[contains(@class,'cb-col cb-col-8 text-bold text-black text-right')]"))
				.getText();

		if (Integer.parseInt(TotalCount) == RunCount) {
			System.out.println("the sum matches");
			System.out.println(RunCount);
		} else {
			System.out.println("sum does not match");
		}
		driver.close();
	}
}
