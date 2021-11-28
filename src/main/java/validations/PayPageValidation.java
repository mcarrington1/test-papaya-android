package validations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.PayPage;

public class PayPageValidation {
    private static final Logger logger = LogManager.getLogger(PayPageValidation.class);

    /**
     * Takes the last 4 of the accountNumber and compares it to the summary in the pay page
     * @param payPage POM Object
     * @param accountNumber Takes a full account number, only compares the last 4
     */
    public static void validatePartialAccountNumber(PayPage payPage, String accountNumber) {
        String lastFourAccountNumber = accountNumber.substring(accountNumber.length() - 4);

        logger.info("Comparing account number, provided full account is {}, trimming to last 4, {}",
                accountNumber, lastFourAccountNumber);
        Assert.assertTrue(payPage.getPaymentInfo().contains(lastFourAccountNumber),
                "Partial account # mismatch");
    }
}
