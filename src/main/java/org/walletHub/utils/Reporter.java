package org.walletHub.utils;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter {
	public ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public ExtentTest test, eachNode;

	public String testCaseName, testCaseDescription, author, category;


	@BeforeSuite
	public void startReport() {
		reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true); 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testCaseName, testCaseDescription);
		test.assignAuthor(author);
		test.assignCategory(category);  
	}

	public abstract long takeSnap();

	public void reportStep(String desc, String status,boolean bSnap ) {
		
		MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".png").build();
			} catch (IOException e) {

			}
		}
		if(status.equalsIgnoreCase("PASS")) {
			eachNode.pass(desc, img);			
		}else if (status.equalsIgnoreCase("FAIL")) {
			eachNode.fail(desc, img);
			eachNode.log(Status.FAIL, "Usage: BOLD TEXT");
			throw new RuntimeException();
		}else if (status.equalsIgnoreCase("WARNING")) {
			eachNode.warning(desc, img);
		}else if (status.equalsIgnoreCase("INFO")) {
			eachNode.info(desc);
		}							
	}


	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}


	@AfterSuite
	public void stopReport() {
		extent.flush();
	}	
}
