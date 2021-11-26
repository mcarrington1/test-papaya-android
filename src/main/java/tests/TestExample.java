package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestExample {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    //Privacy Splash Elements

    // Splash Screen
    By payABillButton = By.id("com.snappays:id/big_button");

    // Camera Access
    By buttonAllowCamAccess = By.id("com.snappays:id/request_permission_button");
    By notifAllowAppCamAccess = By.id("com.android.permissioncontroller:id/permission_allow_button"); // this is android OS reliant

    // Camera View
    By cameraToolbar = By.id("com.snappays:id/toolbar_main");
    By cameraGalleryButton = By.id("com.snappays:id/gallery_button");
    By cameraShutterButton = By.id("com.snappays:id/capture_button");

    // add amount view
    By addAmountTotalEntry = By.id("com.snappays:id/amount_edt_amount");
    By addAmountContinue = By.id("com.snappays:id/btn_continue");

    // Payment Method view
    By paymentAddBankAccountButton = By.id("com.snappays:id/btn_add_bank_account");
    By paymentAddBankAccountRoutingEntryButton = By.id("com.snappays:id/btn_bank_account_manual");

    // Add Bank Account View
    By addBankAccountPhoneEntry = By.id("com.snappays:id/edt_phone");
    By addBankAccountEmailEntry = By.id("com.snappays:id/edt_email");
    By addBankAccountNameEntry = By.id("com.snappays:id/edt_holder_name");
    By addBankAccountRoutingEntry = By.id("com.snappays:id/edt_routing_number"); // 9 digit 081000210
    By addBankAccountRoutingVerifyEntry = By.id("com.snappays:id/edt_confirm_routing_number");
    By addBankAccountNumberEntry = By.id("com.snappays:id/edt_account_number"); // 10-12 digit
    By addBankAccountNumberVerifyEntry = By.id("com.snappays:id/edt_confirm_account_number");
    By addBankAccountNextButton = By.id("com.snappays:id/btn_save_bank_account");

    // Billing Address View
    By addBillingAddressStreetEntry = By.id("com.snappays:id/edt_address");
    By addBillingAddressCityEntry = By.id("com.snappays:id/edt_city");
    By addBillingAddressZipEntry = By.id("com.snappays:id/edt_zip");
    By addBillingAddressStateButton = By.id("com.snappays:id/edt_state");
    // TODO: Make this less ugly?
    By addBillingAddressStateFirstEntry = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget" +
            ".CheckedTextView[1]");
    By addBillingAddressTosCheck = By.id("com.snappays:id/switch_accepted_tos");
    By addBillingSaveBankAccountButton = By.id("com.snappays:id/btn_save");

    // Pay Bill View
    By payBillNext = By.id("com.snappays:id/big_pay_button");

    // Pay Bill
//    MobileElement payBillAdditionalPatientName = driver.findElementByAccessibilityId("Patient Name");
//    MobileElement getPayBillAdditionalPatientDob = driver.findElementByAccessibilityId("Patient Date of Birth");

    // Gallery View
    By notifAllowMediaAccess = By.id("com.android.permissioncontroller:id/permission_allow_button");
    By galleryImageFolderThumbnail = By.id("com.android.permissioncontroller:id/permission_allow_button");


    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "test2");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.snappays");
        caps.setCapability("appActivity", "com.snappays.activity.LandingActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void basicTestOne() throws InterruptedException {

        // login and capture photo
        wait.until(ExpectedConditions.visibilityOfElementLocated(payABillButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAllowCamAccess)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(notifAllowAppCamAccess)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cameraShutterButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addAmountTotalEntry)).sendKeys("15.00");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addAmountContinue)).click();

        // add bank account
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentAddBankAccountButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentAddBankAccountRoutingEntryButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentAddBankAccountButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addBankAccountPhoneEntry)).sendKeys("314946903");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addBankAccountEmailEntry)).sendKeys("qa@papayapay.com");

        /*
        * Pre-Steps
        * load sample medical bill images */

        /* Steps for Import Image
        * allow cam access
        * allow while using app
        * click on gallery button
        * allow media access
        * select device folder
        * select a photo view, which should have an image
        * select image
        * <image will be scanned>
        * enter in how much we want to pay and hit continue
        * add bank account button
        * use routing & account numbers button
        * fill out phone number, email, account holder name, routing, routing verify, acct, acct verify
        * scroll down and hit "next"
        * add in address
        * for state, tap button, then tap any state
        * check TOS button
        * Save bank account button
        * hit pay button
        * enter in patient name and DOB
        * hit gigantic Papaya Pay button
        * */

        /* Steps for Capture from Camera
        * */
    }
}
