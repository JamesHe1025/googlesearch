package interview;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	static String google = "http://www.google.com";
	static WebDriver driver;
	static String searchTarget = "RTS Labs";
	static String RTSWebsite = "https://rtslabs.com/";

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(google);
		driver.findElement(By.xpath("//input[contains(@name,'q')]")).sendKeys(searchTarget + Keys.ENTER);
		driver.findElement(By.xpath("(//h3[contains(@class,'LC20lb MBeuO DKV0Md')])[1]")).click();
		String currentWebsite = driver.getCurrentUrl();
		if (currentWebsite.equals(RTSWebsite)) {
			System.out.println("You are in the right place. ");
		} else {
			System.out.println("Sorry some thing wrong.");
		}

		closeBrowser();
	}

	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
