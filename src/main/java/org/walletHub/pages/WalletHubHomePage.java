package org.walletHub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.walletHub.api.ProjectSpecificMethod;

import com.aventstack.extentreports.ExtentTest;

public class WalletHubHomePage extends ProjectSpecificMethod {

	@FindBy(how = How.XPATH, using = "//*[@id=\"reviews-section\"]/div[1]/div[3]/review-star/div//*[local-name()='svg'][4]")
	WebElement starEle;

	@FindBy(how = How.XPATH, using = "//*[@id=\"reviews-section\"]/div[1]/div[3]/review-star/div//*[local-name()='svg'][4]/*[local-name()='g']/*[local-name()='path'][2]")
	WebElement clickStartEle;


	
	public WalletHubHomePage(RemoteWebDriver driver, ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;

	}
	
	public WalletHubHomePage mouseOverToStars() {
		try {

			Actions builder = new Actions(driver);
			builder.moveToElement(starEle).perform();
			reportStep("The Start is being Highlighted", "PASS");
		} catch (Exception e) {
			reportStep("The Start is not being Highlighted", "FAIL");
		}
		return this;
	}

	public WalletHubReviewPage clickStar() {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(clickStartEle).click().perform();
			reportStep("Start clicked after highlight", "PASS");
		} catch (Exception e) {
			reportStep("Start was not Clicked", "PASS");
		}
		return new WalletHubReviewPage(driver, eachNode);
	}

}
