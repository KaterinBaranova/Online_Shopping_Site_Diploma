package tests.testng;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private final static Logger logger = Logger.getLogger(TestListener.class);

    @Override
    public synchronized void onStart(ITestContext context) {
        logger.info("Test Suite started!");
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        logger.info((result.getMethod().getMethodName() + " passed!"));
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        logger.info((result.getMethod().getMethodName() + " failed!"));
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        logger.info((result.getMethod().getMethodName() + " skipped!"));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
}
