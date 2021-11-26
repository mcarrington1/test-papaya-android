package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import model.BankAccount;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class AddBankAccountPage extends BasePage {

//    private AppiumDriver driver;

    public AddBankAccountPage() {}

    public AddBankAccountPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    // Contact Fields
    @AndroidFindBy(id = "com.snappays:id/edt_phone")
    private MobileElement customerPhoneInput;

    @AndroidFindBy(id = "com.snappays:id/edt_email")
    private MobileElement customerEmailInput;

    // Bank Fields
    @AndroidFindBy(id = "com.snappays:id/edt_name")
    private MobileElement bankAccountHolderInput;

    @AndroidFindBy(id = "com.snappays:id/edt_routing")
    private MobileElement bankAccountRoutingInput;

    @AndroidFindBy(id = "com.snappays:id/edt_confirm_routing")
    private MobileElement bankAccountRoutingConfirmInput;

    @AndroidFindBy(id = "com.snappays:id/edt_account")
    private MobileElement bankAccountInput;

    @AndroidFindBy(id = "com.snappays:id/edt_confirm_account")
    private MobileElement bankAccountConfirmInput;

    // Other Page Interactions
    @AndroidFindBy(id = "com.snappays:id/btn_save_bank_account")
    private MobileElement bankAccountNextButton;

    public AddBankAccountPage enterBankAccountDetails(BankAccount bankAccount) {
        customerPhoneInput.sendKeys(bankAccount.getPhoneNumber());
        customerEmailInput.sendKeys(bankAccount.getEmailAddress());
        bankAccountHolderInput.sendKeys(bankAccount.getAccountHolderName());
        bankAccountRoutingInput.sendKeys(bankAccount.getRoutingNumber());
        bankAccountRoutingConfirmInput.sendKeys(bankAccount.getRoutingNumberConfirmation());
        bankAccountInput.sendKeys(bankAccount.getAccountNumber());
        bankAccountConfirmInput.sendKeys(bankAccount.getAccountNumberConfirmation());

        return this;
    }

    public AddBankAccountPage submitBankAccount() {
        bankAccountNextButton.click();
        return this;
    }
}
