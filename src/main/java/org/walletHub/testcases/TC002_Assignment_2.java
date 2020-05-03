package org.walletHub.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.walletHub.api.ProjectSpecificMethod;
import org.walletHub.pages.WalletHubHomePage;
import org.walletHub.pages.WalletHubLoginPage;
import org.walletHub.pages.WalletHubReviewPage;
import org.walletHub.pages.WalletHubUserhomePage;

public class TC002_Assignment_2 extends ProjectSpecificMethod {

	@BeforeTest
	public void setValues() {

		testCaseName = "Assignment 2";
		testCaseDescription = "Login to walletHub and add review for Test Insurance Company";
		author = "Sanjay";
		dataSheetName = "TC002_Assignment_2";

	}

	@Test(dataProvider = "readExcel")
	public void assignment_2(String Url, String Username, String Password, String Review) {

		WalletHubLoginPage whl = new WalletHubLoginPage(driver, eachNode);
		PageFactory.initElements(driver, whl);
		whl.loadUrl(Url).clickLoginTab().enterUserName(Username).enterPassword(Password).clickLogin()
				.navigateToInsuranceCompany();

		WalletHubHomePage whh = new WalletHubHomePage(driver, eachNode);
		PageFactory.initElements(driver, whh);
		whh.mouseOverToStars().clickStar();

		WalletHubReviewPage whr = new WalletHubReviewPage(driver, eachNode);
		PageFactory.initElements(driver, whr);
		whr.clickPolicyDropDown().selectHealthInsurance().clickWriteReview(Review).clickSubmit()
				.navigateToUserHomePage();

		WalletHubUserhomePage whuh = new WalletHubUserhomePage(driver, eachNode);
		PageFactory.initElements(driver, whuh);
		whuh.verifyReview();
	}

}
