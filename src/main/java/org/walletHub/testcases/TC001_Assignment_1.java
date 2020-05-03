package org.walletHub.testcases;

import org.facebook.pages.FaceBookHomePage;
import org.facebook.pages.FaceBookLoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.walletHub.api.ProjectSpecificMethod;

public class TC001_Assignment_1 extends ProjectSpecificMethod {

	@BeforeTest
	public void setValues() {
		testCaseName = "Assignment 1";
		testCaseDescription = "Login to facebook and post status";
		author = "Sanjay";

	}

	@Parameters({ "FaceBookUrl" })
	@Test
	public void assignment_1(String FaceBookUrl) {

		FaceBookLoginPage fbl = new FaceBookLoginPage(driver, eachNode);
		PageFactory.initElements(driver, fbl);
		fbl.loadUrl(FaceBookUrl).enterUserName().enterPassword().clickLoginButton();
		FaceBookHomePage fbh = new FaceBookHomePage(driver, eachNode);
		PageFactory.initElements(driver, fbh);
		fbh.userCreatePost();

	}

}
