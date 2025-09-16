package exListeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Baselibrary.basePage;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReport;
	public ExtentReports extent;
	public static ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String currentdatetimestamp = df.format(dt);
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test_Report-" + timeStamp + ".html";
		sparkReport = new ExtentSparkReporter(".\\reports\\" + repName);
		
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setReportName("MobiBattle Test Report");
		sparkReport.config().setTheme(Theme.STANDARD);
		
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		extent.setSystemInfo("Application", "mobibattle");
		extent.setSystemInfo("Modual","Admin");
		extent.setSystemInfo("User Name", "Prashant Saini");
		extent.setSystemInfo("Environement", "QA");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());
	  //test.assignCategory(result.getMethod().getGroups()); // to dispaly groups in report
		test.log(Status.PASS, result.getName()+" got successful executed");
		
		try {
			String imgPath = new basePage().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath); }
		 catch(IOException e1) {
			 
			 e1.printStackTrace();
		}
	}
	
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
	  //test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath = new basePage().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath); }
		 catch(IOException e1) {
			 
			 e1.printStackTrace();
		}}
	
		public void onTestSkipped(ITestResult result) {
			
			test = extent.createTest(result.getTestClass().getName());
			  //test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP,result.getName()+" got skipped");
			test.log(Status.INFO, result.getThrowable().getMessage());
		}
		
		public void onFinish(ITestContext testContext) {
			
			extent.flush();
			
			String pathOfExtentReport = System.getProperty("user.dir")+ "\\report\\"+repName;
		File extentReport = new File (pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch(IOException e) {
			
			e.printStackTrace();
		}
		}
		

}
