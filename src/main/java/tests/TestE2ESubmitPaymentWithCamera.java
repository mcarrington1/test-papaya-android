package tests;


import enums.BillType;
import model.Address;
import model.BankAccount;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.AvdManagement;
import validations.CaptureBillPageValidation;
import validations.ConfirmationPageValidation;
import validations.PayPageValidation;

import static enums.BillType.MEDICAL;

public class TestE2ESubmitPaymentWithCamera extends TestBase {
    private final String expectedBillAmount = "5.00";
    private final BankAccount bankAccount = new BankAccount();
    private final Address address = new Address();

    /**
     * Column One - Utility Type,
     * Column Two - Expected Biller type, based on the image
     */
    @DataProvider(name = "test-data")
    public Object[][] getTestData()
    {
        Object [][] myData = {{BillType.UTILITY, "City Of Tallahassee"},
                {MEDICAL, "Your Bill"}};
        return myData;
    }

    @Test(description = "Execute an E2E test with a given bill type, including payment setup and submission.", dataProvider="test-data")
    public void testSendingBill(BillType billType, String expectedBillerName) {
        AvdManagement.setTestImage(billType);

        // Initiate Payment Process
        SplashPage splashPage = new SplashPage(driver);
        splashPage.startPayBill();

        // Capture our payment and submit bill amount
        CaptureBillPage captureBillPage = new CaptureBillPage(driver);
        captureBillPage
                .authorizeCameraAccess()
                .captureBillFromCamera()
                .setBillAmount(expectedBillAmount);

        CaptureBillPageValidation.validateBillAmount(captureBillPage, "$" + expectedBillAmount);
        CaptureBillPageValidation.validateBillerName(captureBillPage, expectedBillerName);
        captureBillPage.addBankAccount();

        // Submit our bank account information
        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        addBankAccountPage
                .enterBankAccountDetails(bankAccount)
                .submitBankAccount();

        // Submit and confirm our billing information
        BillingAddressPage billingAddressPage = new BillingAddressPage(driver);
        billingAddressPage
                .setAddress(address)
                .acceptTos()
                .saveBankAccountAndSubmit();

        // Validate our payment and submit
        PayPage payPage = new PayPage(driver);
        PayPageValidation.validatePartialAccountNumber(payPage, bankAccount.getAccountNumber());
        //TODO: These are commented out so we do not spam the server

        // Additional information is requested for Medical bills
        if (billType == MEDICAL) {
            payPage.submitForMedicalInfo();
            payPage.setMedicalInformation("test client", "08141982");
        }
//        payPage.submitPayment();
//        // Confirm successful payment
//        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
//        ConfirmationPageValidation.validateConfirmationPageSuccess(confirmationPage);
    }


}
