package validations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.CaptureBillPage;

public class CaptureBillPageValidation {
    private static final Logger logger = LogManager.getLogger(CaptureBillPageValidation.class);

    /**
     * Validate biller name displayed in CaptureBillPage object; compares via String
     * @param captureBillPage POM Object
     * @param expectedBillerName String of matching text
     */
    public static void validateBillerName(CaptureBillPage captureBillPage, String expectedBillerName) {
        logger.info("Comparing biller name, expected {}", expectedBillerName);
        Assert.assertEquals(captureBillPage.getBillerNameDisplayed(), expectedBillerName, "Biller name mismatch");
    }

    /**
     * Validate bill amount displayed in CaptureBillPage object; compares via String
     * @param captureBillPage POM Object
     * @param expectedBillAmount String of matching text
     */
    public static void validateBillAmount(CaptureBillPage captureBillPage, String expectedBillAmount) {
        logger.info("Comparing billing amount, expected {}", expectedBillAmount);
        Assert.assertEquals(captureBillPage.getPayAmountDisplayed(), expectedBillAmount, "Billing mismatch");
    }
}
