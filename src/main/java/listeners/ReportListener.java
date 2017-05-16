package listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;

/**
 * Created by Billy on 1/16/2017.
 */
public class ReportListener extends TestListenerAdapter implements IInvokedMethodListener, ISuiteListener {
    private ExtentTest extentTest;
    private ExtentReports extentReports;

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod())
            extentTest = extentReports.startTest(iTestResult.getTestName());
    }
    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {}

    @Override
    public void onTestFailure(ITestResult tr) {
        extentTest.setDescription(tr.getName());
        extentTest.log(LogStatus.FAIL, tr.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        extentTest.setDescription(tr.getName());
        extentTest.log(LogStatus.SKIP, tr.getThrowable());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        extentTest.setDescription(tr.getName());
        extentTest.log(LogStatus.PASS, "Test complete Passed");
    }

    @Override
    public void onStart(ISuite iSuite) {
        extentReports = new ExtentReports(System.getProperty("user.dir") + "/reports/testReport.html", true);
        extentReports.addSystemInfo("HostName", "Billy")
                .addSystemInfo("Environment", "TestVKPosts")
                .addSystemInfo("User Name", "Billy");
        extentReports.loadConfig(ClassLoader.getSystemResource("extent-config.xml"));
    }

    @Override
    public void onFinish(ISuite iSuite) {
        extentReports.endTest(extentTest);
        extentReports.flush();
    }
}
