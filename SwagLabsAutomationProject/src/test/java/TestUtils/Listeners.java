package TestUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	
	ExtentReports extent=ExtentReporterNG.getReporterObject();
	ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
    	//create a new test 
    	test=extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	//prints a message that the Test Passed
        test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	//fail the test and get the reason for the failure
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
   
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        // generates the test report after executing all tests
    	extent.flush();
    }

}
