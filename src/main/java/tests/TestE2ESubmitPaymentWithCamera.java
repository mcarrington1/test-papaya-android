package tests;


import enums.BillType;
import model.Address;
import model.BankAccount;
import org.testng.annotations.Test;
import pages.*;
import utils.AvdManagement;
import validations.CaptureBillPageValidation;
import validations.ConfirmationPageValidation;
import validations.PayPageValidation;

public class TestE2ESubmitPaymentWithCamera extends TestBase {
    private final String expectedBillAmount = "5.00";
    private final String expectedBillerName = "City Of Tallahassee";
    private final BankAccount bankAccount = new BankAccount();
    private final Address address = new Address();

    @Test(description = "Execute an E2E test with a utility bill, including payment setup and submission.")
    public void testSendingUtilityBill() {
        AvdManagement.setTestImage(BillType.UTILITY);

        SplashPage splashPage = new SplashPage(driver);

        CaptureBillPage captureBillPage = splashPage.startPayBill();

        // Capture Bill Image & set amount
        captureBillPage
                .authorizeCameraAccess()
                .captureBillFromCamera()
                .setBillAmount(expectedBillAmount);

        CaptureBillPageValidation.validateBillAmount(captureBillPage, "$" + expectedBillAmount);
        CaptureBillPageValidation.validateBillerName(captureBillPage, expectedBillerName);

        AddBankAccountPage addBankAccountPage = captureBillPage.addBankAccount();

        // Add Bank Account with Address
        BillingAddressPage billingAddressPage = addBankAccountPage
                .enterBankAccountDetails(bankAccount)
                .submitBankAccount();

        PayPage payPage = billingAddressPage
                .setAddress(address)
                .acceptTos()
                .saveBankAccountAndSubmit();

        PayPageValidation.validatePartialAccountNumber(payPage, bankAccount.getAccountNumber());

        // Submit Payment
        //TODO: These are commented out so we do not spam the server
//        ConfirmationPage confirmationPage = payPage.submitPayment();
//        ConfirmationPageValidation.validateConfirmationPageSuccess(confirmationPage);
    }

    @Test
    public void testSendingMedicalBill() {
        AvdManagement.setTestImage(BillType.MEDICAL);


    }
}
