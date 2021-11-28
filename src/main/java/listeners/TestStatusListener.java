package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestStatusListener extends TestListenerAdapter {
    private static final Logger logger = LogManager.getLogger(TestStatusListener.class);

    @Override
    public void onTestStart(ITestResult tr) {
        logger.info("### Test Start: {}", tr.getMethod().getMethodName());
        logger.info("### Description: {}", tr.getMethod().getDescription());
        logger.info("### Parameters: {}", tr.getParameters());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger.info("### Test {} Passed", tr.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.error("### Test {} Failed", tr.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger.warn("### Test {} Skipped", tr.getMethod().getMethodName());
    }
}
