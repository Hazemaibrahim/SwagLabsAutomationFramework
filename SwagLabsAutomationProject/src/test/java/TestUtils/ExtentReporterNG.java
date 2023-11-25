package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	 static ExtentReports extent;
	
	public static ExtentReports getReporterObject() {
		
		//ExtentReports, ExtentSparkReporter ( 2 classes)
		
		//sets the path for the html report in the ExtentRepots project 
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		
		//creates report and takes path for report as an argument
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		
		reporter.config().setReportName("SwagLabs Test Automation Results");

		reporter.config().setDocumentTitle("Test Results");
		
		//creates object from the class
		extent= new ExtentReports();
		
		//attach the object to the main class
		extent.attachReporter(reporter);
		
		//set the tester name to Hazem Ahmed
		extent.setSystemInfo("Tester", "Hazem Ahmed");
		
		return extent;
		
		
	}

}
