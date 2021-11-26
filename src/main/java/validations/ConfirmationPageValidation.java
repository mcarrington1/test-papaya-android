package validations;

import org.testng.Assert;
import pages.ConfirmationPage;
import pages.PayPage;

public class ConfirmationPageValidation {

    public static void validateConfirmationPageSuccess(ConfirmationPage confirmationPage) {
        Assert.assertTrue(confirmationPage.isSuccessfulPaymentImageDisplayed());
    }
}
