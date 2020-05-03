package org.walletHub.api;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.walletHub.utils.ReadExcel;
import org.walletHub.utils.Reporter;

public class ProjectSpecificMethod extends Reporter {

	public RemoteWebDriver driver;
	public static Properties pr;
	public String dataSheetName;

	@BeforeSuite
	public void loadValues() throws IOException {

		FileReader fl = new FileReader("./property/user.properties");
		pr = new Properties();
		pr.load(fl);

	}
	
	@DataProvider
	public String[][] readExcel() throws IOException {
		ReadExcel values = new ReadExcel();
		return values.readCell(dataSheetName);
	}

	@BeforeMethod
	public void launchBrowser() {
		eachNode = test.createNode(testCaseName);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);

	}

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".png"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();

	}

	@AfterSuite
	public void unloadObjects() {
		pr = null;
	}

}
