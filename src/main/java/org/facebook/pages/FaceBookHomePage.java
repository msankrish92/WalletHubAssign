package org.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.api.ProjectSpecificMethod;

import com.aventstack.extentreports.ExtentTest;

public class FaceBookHomePage extends ProjectSpecificMethod {

	@FindBy(how = How.XPATH, using = "//textarea[contains(@title,\"Write something here...\")]")
	WebElement createPostEle;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "//span[text()='Post']")
	WebElement postButtonEle;

	@FindBy(how = How.ID, using = "guardrail_cancel")
	WebElement noThanksEle;

	public FaceBookHomePage(RemoteWebDriver driver, ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;
	}

	public FaceBookHomePage userCreatePost() {

		try {
			createPostEle.click();
			createPostEle.sendKeys("Hello World");
			reportStep("The Content written successfully", "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block

			reportStep("The Content is not written successfully", "FAIL");
		}
		return this;

	}

}
