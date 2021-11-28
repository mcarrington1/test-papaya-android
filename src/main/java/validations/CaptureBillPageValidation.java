package validations;

import org.testng.Assert;
import pages.CaptureBillPage;

public class CaptureBillPageValidation {
    /**
     * Validate biller name displayed in CaptureBillPage object; compares via String
     * @param captureBillPage POM Object
     * @param expectedBillerName String of matching text
     */
    public static void validateBillerName(CaptureBillPage captureBillPage, String expectedBillerName) {
        Assert.assertEquals(captureBillPage.getBillerNameDisplayed(), expectedBillerName, "Biller name mismatch");
    }

    /**
     * Validate bill amount displayed in CaptureBillPage object; compares via String
     * @param captureBillPage POM Object
     * @param expectedBillAmount String of matching text
     */
    public static void validateBillAmount(CaptureBillPage captureBillPage, String expectedBillAmount) {
        Assert.assertEquals(captureBillPage.getPayAmountDisplayed(), expectedBillAmount, "Billing mismatch");
    }
}
