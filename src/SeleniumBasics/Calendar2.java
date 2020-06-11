package SeleniumBasics;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar2 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SONY\\Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
		String date = "01-01-2021 12:00 AM";
		WebElement calendarOpen = driver.findElement(By.xpath("//span[contains(@class,'k-icon k-i-calendar')]"));
		calendarOpen.click();
		WebElement nextArrow = driver.findElement(By.xpath("//a[@data-action='next']"));
		WebElement prevArrow = driver.findElement(By.xpath("//a[@data-action='prev']"));
		WebElement midCalendar = driver.findElement(By.xpath("//a[@data-action='nav-up']"));
		String date_mm_yyyy[] = (date.split(" ")[0]).split("-");
		int yearDiff = Integer.parseInt(date_mm_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		midCalendar.click();
		if (yearDiff != 0) {
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					nextArrow.click();
				}
			} else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					prevArrow.click();
				}

			}
		}
		List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//a[@tabindex='-1' and @class='k-link']"));
		list_AllMonthToBook.get(Integer.parseInt(date_mm_yyyy[1]) - 1).click();
		List<WebElement> list_AllDays = driver.findElements(By.xpath(
				"//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
		list_AllDays.get(Integer.parseInt(date_mm_yyyy[0]) - 1).click();

		WebElement timeOpen = driver.findElement(By.xpath("//span[@class='k-icon k-i-clock']"));
		timeOpen.click();
		List<WebElement> list_time = driver.findElements(By.xpath("//ul[@id='datetimepicker_timeview']//li"));
		date = date.split(" ")[1] + " " + date.split(" ")[2];
		System.out.println(date);
		for (WebElement dtime : list_time) {
			if (dtime.getText().equalsIgnoreCase(date)) {
				dtime.click();
			}
		}
	}
}
