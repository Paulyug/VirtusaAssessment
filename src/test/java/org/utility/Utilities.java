package org.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilities {
	public static WebDriver driver;

	public static WebDriver openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;

	}

	public static void openUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}
	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

	}

	public static void enterValue(WebElement e, String val) {
		e.sendKeys(val);

	}

	public static void click(WebElement e) {
		e.click();

	}

	public static String getUrl() {
		return driver.getCurrentUrl();

	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static void windowHandles(int in) {
		Set<String> all = driver.getWindowHandles();
		List<String> li = new LinkedList<String>(all);
		driver.switchTo().window(li.get(in));
	}

	public static void closeBrowser() {
		driver.quit();

	}

	public static void screenshot(String image) {
		TakesScreenshot tk= (TakesScreenshot)driver;
		try {
			FileUtils.copyFile(tk.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot\\"+image+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
