package validations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.ConfirmationPage;

public class ConfirmationPageValidation {
    private static final Logger logger = LogManager.getLogger(ConfirmationPageValidation.class);

    /**
     * Validate that confirmation page image is displayed, informing user; compares with a boolean from POM
     * @param confirmationPage POM object
     */
    public static void validateConfirmationPageSuccess(ConfirmationPage confirmationPage) {
        logger.info("checking if confirmation page is displayed");
        Assert.assertTrue(confirmationPage.isSuccessfulPaymentImageDisplayed());
    }
}
