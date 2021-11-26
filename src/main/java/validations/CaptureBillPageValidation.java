package validations;

import org.testng.Assert;
import pages.CaptureBillPage;

public class CaptureBillPageValidation {
    public static void validateBillerName(CaptureBillPage captureBillPage, String expectedBillerName) {
        Assert.assertEquals(captureBillPage.getBillerNameDisplayed(), expectedBillerName, "Biller name mismatch");
    }

    public static void validateBillAmount(CaptureBillPage captureBillPage, String expectedBillAmount) {
        Assert.assertEquals(captureBillPage.getPayAmountDisplayed(), expectedBillAmount, "Billing mismatch");
    }
}
