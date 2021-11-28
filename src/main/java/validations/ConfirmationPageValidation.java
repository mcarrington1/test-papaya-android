package validations;

import org.testng.Assert;
import pages.ConfirmationPage;
import pages.PayPage;

public class ConfirmationPageValidation {

    /**
     * Validate that confirmation page image is displayed, informing user; compares with a boolean from POM
     * @param confirmationPage POM object
     */
    public static void validateConfirmationPageSuccess(ConfirmationPage confirmationPage) {
        Assert.assertTrue(confirmationPage.isSuccessfulPaymentImageDisplayed());
    }
}
