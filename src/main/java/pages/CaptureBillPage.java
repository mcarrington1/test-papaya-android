package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class CaptureBillPage extends BasePage {

    private AppiumDriver driver;

    public CaptureBillPage() {}

    public CaptureBillPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    // Camera Functionality
    @AndroidFindBy(id = "com.snappays:id/request_permission_button")
    private MobileElement allowCameraAccessButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement approveCameraPermissionButton;

    @AndroidFindBy(id = "com.snappays:id/capture_button")
    private MobileElement shutterButton;

    // Adding Amount
    @AndroidFindBy(id = "com.snappays:id/amount_edt_amount")
    private MobileElement addBillAmountInput;

    @AndroidFindBy(id = "com.snappays:id/btn_continue")
    private MobileElement addBillAmountContinueButton;

    @AndroidFindBy(id = "com.snappays:id/txt_amount")
    private MobileElement quotedPayAmount;

    @AndroidFindBy(id = "com.snappays:id/txt_biller_name")
    private MobileElement quotedBillerName;

    @AndroidFindBy(id = "com.snappays:id/btn_add_bank_account")
    private MobileElement addBankAccountButton;

    @AndroidFindBy(id = "com.snappays:id/btn_bank_account_manual")
    private MobileElement addBankAccountManualEntryButton;




    public CaptureBillPage authorizeCameraAccess() {
        allowCameraAccessButton.click();
        approveCameraPermissionButton.click();
        return this;
    }

    public CaptureBillPage captureBillFromCamera() {
        shutterButton.click();
        return this;
    }

    public CaptureBillPage setBillAmount(String billAmount) {
        addBillAmountInput.sendKeys(billAmount);
        addBillAmountContinueButton.click();
        return this;
    }

    // TODO: Convert to ENUM and change to "add payment method"
    public CaptureBillPage addBankAccount() {
        addBankAccountButton.click();
        addBankAccountManualEntryButton.click();
        return this;
    }

    public String getPayAmountDisplayed() {
        return quotedPayAmount.getText();
    }

    public String getBillerNameDisplayed() {
        return quotedBillerName.getText();
    }
}
