package org.facebook.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.api.ProjectSpecificMethod;

import com.aventstack.extentreports.ExtentTest;

public class FaceBookLoginPage extends ProjectSpecificMethod {

	@FindBy(how = How.ID, using = "email")
	WebElement userNameEle;

	@FindBy(how = How.ID, using = "pass")
	WebElement passwordEle;

	@FindBy(how = How.XPATH, using = "//label[@id=\"loginbutton\"]/input")
	WebElement loginbuttonEle;

	public FaceBookLoginPage(RemoteWebDriver driver, ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;
	}

	public FaceBookLoginPage loadUrl(String faceBookUrl) {
		try {
			driver.get(faceBookUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			reportStep("The url loaded successfully", "PASS");
		} catch (Exception e) {
			reportStep("The url was not loaded successfully", "FAIL");
		}
		return this;
	}

	public FaceBookLoginPage enterUserName() {

		try {
			userNameEle.sendKeys(pr.getProperty("username"));
			reportStep("The username entered successfully", "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("The username is not entered successfully", "FAIL");
		}
		return this;
	}

	public FaceBookLoginPage enterPassword() {
		try {
			passwordEle.sendKeys(pr.getProperty("password"));
			reportStep("The password entered successfully", "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("The password is not entered successfully", "PASS");
		}
		return this;
	}

	public FaceBookHomePage clickLoginButton() {
		try {
			loginbuttonEle.click();
			reportStep("The login button clicked successfully", "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("The login button is not clicked successfully", "PASS");
		}
		return new FaceBookHomePage(driver, eachNode);
	}

}
