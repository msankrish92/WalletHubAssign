package org.walletHub.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.api.ProjectSpecificMethod;

import com.aventstack.extentreports.ExtentTest;

public class WalletHubLoginPage extends ProjectSpecificMethod {
	
	@FindBy(how=How.XPATH,using="//a[text()='Login']")
	WebElement loginTabEle;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Email Address']")
	WebElement enterUserNameEle;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Password']")
	WebElement enterPasswordEle;
	
	@FindBy(how=How.XPATH,using="//span[text()='Login']")
	WebElement clickLoginButton;

	public WalletHubLoginPage(RemoteWebDriver driver, ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;
	}
	
	public WalletHubLoginPage loadUrl(String walletHubUrl) {
		try {
		driver.get(walletHubUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		reportStep("The url loaded successfully", "PASS");
		}catch(Exception e) {
			reportStep("The url was not loaded successfully", "FAIL");
		}
		return this;
	}
	
	public WalletHubLoginPage clickLoginTab() {
		try {
			driver.findElementByXPath("//a[text()='Login']").click();
			reportStep("The Login tab clicked", "PASS");
		} catch (Exception e) {
			reportStep("The Login tab not clicked", "FAIL");
		}
		return this;
		
	}
	
	public WalletHubLoginPage enterUserName(String username) {
		try {
			enterUserNameEle.sendKeys(username);
			reportStep("The username is entered successfully", "PASS");
		} catch (Exception e) {
			reportStep("The username not entered successfully", "FAIL");
		}
		return this;
	}
	
	public WalletHubLoginPage enterPassword(String password) {
		try {
			enterPasswordEle.sendKeys(password);
			reportStep("The Password Entered Successfully", "PASS");
		} catch (Exception e) {
			reportStep("The Password not entered successfully", "FAIL");
		}
		return this;
	}
	
	public WalletHubLoginPage clickLogin() {
		try {
			clickLoginButton.click();
			
			reportStep("Login successfull", "PASS");
		} catch (Exception e) {
			reportStep("Login Unsuccessfull", "FAIL");
		}
		return this;
	}
	
	public WalletHubHomePage navigateToInsuranceCompany() {
		try {
			driver.navigate().to("http://wallethub.com/profile/test_insurance_company/");
			reportStep("Navigation successfull", "PASS");
		} catch (Exception e) {
			reportStep("Navigation unsuccessfull", "FAIL");
		}
		return new WalletHubHomePage(driver, eachNode);
	}

}
