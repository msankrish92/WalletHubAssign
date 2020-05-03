package org.walletHub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.walletHub.api.ProjectSpecificMethod;

import com.aventstack.extentreports.ExtentTest;

public class WalletHubUserhomePage extends ProjectSpecificMethod {

	@FindBy(how = How.XPATH, using = "//div[@class='pr-rec-texts-container']/a")
	WebElement reviewCompanyEle;

	public WalletHubUserhomePage(RemoteWebDriver driver, ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;
	}

	public WalletHubUserhomePage verifyReview() {
		try {
			String reviewPostedCompanyName = reviewCompanyEle.getText();
			Assert.assertEquals(reviewPostedCompanyName, "Test Insurance Company");
			reportStep("Assert Successfull", "PASS");
		} catch (Exception e) {
			reportStep("Assert Failed", "FAIL");
		}
		return this;

	}

}
