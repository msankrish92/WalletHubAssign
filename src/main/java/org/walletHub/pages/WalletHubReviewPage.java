package org.walletHub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.api.ProjectSpecificMethod;

import com.aventstack.extentreports.ExtentTest;

public class WalletHubReviewPage extends ProjectSpecificMethod {

	@FindBy(how = How.XPATH, using = "(//span[@class='dropdown-placeholder'])[2]")
	WebElement clickPolicyTypeDropDownEle;

	@FindBy(how = How.XPATH, using = "//li[text()='Health Insurance']")
	WebElement SelectHeathInsuraneEle;

	@FindBy(how = How.XPATH, using = "//textarea[contains(@placeholder,\"Write your review...\")]")
	WebElement writeAReviewEle;

	@FindBy(how = How.XPATH, using = "//div[text()='Submit']")
	WebElement submitEle;

	public WalletHubReviewPage(RemoteWebDriver driver, ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;
	}

	public WalletHubReviewPage clickPolicyDropDown() {
		try {
			clickPolicyTypeDropDownEle.click();
			reportStep("Clicked policy dropdown", "PASS");
		} catch (Exception e) {
			reportStep("Clicked policy dropdown", "FAIL");

		}
		return this;
	}

	public WalletHubReviewPage selectHealthInsurance() {
		try {
			SelectHeathInsuraneEle.click();
			reportStep("Health Insurance Clicked", "PASS");
		} catch (Exception e) {
			reportStep("Health Insurance not Clicked", "FAIL");
		}
		return this;
	}

	public WalletHubReviewPage clickWriteReview(String review) {
		try {
			writeAReviewEle.click();
			writeAReviewEle.sendKeys(review);
			reportStep("200 character review written successfully", "PASS");
		} catch (Exception e) {
			reportStep("200 character review not written successfully", "FAIL");
		}
		return this;
	}

	public WalletHubReviewPage clickSubmit() {
		try {
			submitEle.click();
			reportStep("Submit button clicked successfully", "PASS");
		} catch (Exception e) {
			reportStep("Submit button clicked successfully", "FAIL");
		}
		return this;
	}

	public WalletHubUserhomePage navigateToUserHomePage() {
		try {
			for (int i = 0; i < 2; i++) {
				driver.navigate().to("https://wallethub.com/profile/msankrish4/");
			}

			reportStep("Navigated to user page successfully", "PASS");
		} catch (Exception e) {
			reportStep("Navigation to user page is unsuccessfully", "FAIL");
		}
		return new WalletHubUserhomePage(driver, eachNode);
	}

}
