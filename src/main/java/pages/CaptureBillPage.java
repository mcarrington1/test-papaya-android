package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class CaptureBillPage extends BasePage {
    public CaptureBillPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
    private static final Logger logger = LogManager.getLogger(CaptureBillPage.class);

    // Camera Functionality
    @AndroidFindBy(id = "com.snappays:id/request_permission_button")
    private MobileElement allowCameraAccessButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement approveCameraPermissionButtonAndroid10;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement approveCameraPermissionButtonAndroid11;

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

    /**
     * Authorize camera access including camera access and permission button
     * NOTE: May need more investigation with Android 9 and Android 12
     * @return
     */
    public CaptureBillPage authorizeCameraAccess() {
        logger.info("Authorizing camera");
        allowCameraAccessButton.click();

        // The permission process is different on Android 11+
        if (driver.getCapabilities().getCapability("platformVersion") == "11") {
            approveCameraPermissionButtonAndroid11.click();
        } else {
            approveCameraPermissionButtonAndroid10.click();
        }

        return this;
    }

    /**
     * Interact with shutter button on camera
     * @return
     */
    public CaptureBillPage captureBillFromCamera() {
        logger.info("capturing bill with camera");
        shutterButton.click();
        return this;
    }

    /**
     * Set the bill amount after capturing the bill image
     * @param billAmount
     * @return
     */
    public CaptureBillPage setBillAmount(String billAmount) {
        logger.info("setting bill amount as {}", billAmount);
        addBillAmountInput.sendKeys(billAmount);
        addBillAmountContinueButton.click();
        return this;
    }

    /**
     * Add a bank account and manually enter bank info
     * @return
     */
    public AddBankAccountPage addBankAccount() {
        logger.info("adding manual bank account");
        addBankAccountButton.click();
        addBankAccountManualEntryButton.click();
        return new AddBankAccountPage(driver);
    }

    /**
     * Get quoted payment amount
     * @return String of payment amount quoted, does not include the $ symbol
     */
    public String getPayAmountDisplayed() { return quotedPayAmount.getText(); }

    /**
     * Get quoted biller name
     * @return String of biller name,
     * may not appear as the expected biller for medical bills and display generic text
     */
    public String getBillerNameDisplayed() {
        return quotedBillerName.getText();
    }
}
