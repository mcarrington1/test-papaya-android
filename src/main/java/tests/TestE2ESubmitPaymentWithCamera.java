package tests;


import model.Address;
import model.BankAccount;
import org.testng.annotations.Test;
import pages.*;
import validations.CaptureBillPageValidation;
import validations.PayPageValidation;

public class TestE2ESubmitPaymentWithCamera extends TestBase {

    // TODO: Experiment with passing reference / object from one page to the next

    @Test(description = "Execute an E2E test with a utility bill, including payment setup and submission")
    public void testSendingUtilityBill() {
        // Pages
        SplashPage splashPage = new SplashPage(driver);
        CaptureBillPage captureBillPage = new CaptureBillPage(driver);
        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        BillingAddressPage billingAddressPage = new BillingAddressPage(driver);
        PayPage payPage = new PayPage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        // Models
        BankAccount bankAccount = new BankAccount();
        Address address = new Address();

        // Test Data
        String expectedBillAmount = "5.00";
        String expectedBillerName = "City Of Tallahassee";

        splashPage.startPayBill();
        captureBillPage
                .authorizeCameraAccess()
                .captureBillFromCamera()
                .setBillAmount(expectedBillAmount);

        CaptureBillPageValidation.validateBillAmount(captureBillPage, "$" + expectedBillAmount);
        CaptureBillPageValidation.validateBillerName(captureBillPage, expectedBillerName);

        captureBillPage.addBankAccount();

        addBankAccountPage
                .enterBankAccountDetails(bankAccount)
                .submitBankAccount();

        billingAddressPage
                .setAddress(address)
                .acceptTos()
                .saveBankAccount();

        PayPageValidation.validatePartialAccountNumber(payPage, bankAccount.getAccountNumber());
        //TODO: These are commented out so we do not spam the server
//        payPage.submitPayment();
//        ConfirmationPageValidation.validateConfirmationPageSuccess(confirmationPage);
    }
}
