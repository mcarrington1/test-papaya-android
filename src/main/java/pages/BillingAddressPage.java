package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import model.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class BillingAddressPage extends BasePage {

    public BillingAddressPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    // Address Fields
    @AndroidFindBy(id = "com.snappays:id/edt_address")
    private MobileElement addressStreetInput;

    @AndroidFindBy(id = "com.snappays:id/edt_city")
    private MobileElement addressCityInput;

    @AndroidFindBy(id = "com.snappays:id/edt_zip")
    private MobileElement addressZipInput;

    @AndroidFindBy(id = "com.snappays:id/edt_state")
    private MobileElement addressStateDropDown;

    // Buttons
    @AndroidFindBy(id = "com.snappays:id/switch_accepted_tos")
    private MobileElement tosCheckBox;

    @AndroidFindBy(id = "com.snappays:id/btn_save")
    private MobileElement saveBankAccountButton;

    public BillingAddressPage setAddress(Address address) {
        addressStreetInput.sendKeys(address.getStreet());
        addressCityInput.sendKeys(address.getCity());
        addressZipInput.sendKeys(address.getZip());
        setAddressStateDropDown(address);

        return this;
    }

    /**
     * Tap on the state drop down; does *NOT* presently scroll down, so only select the first ~12 states in view
     * @param address Address object, extracts out the state (e.g. AK, MO, FL, etc.)
     */
    private void setAddressStateDropDown(Address address) {
        addressStateDropDown.click();

        MobileElement stateElement = (MobileElement) driver
                .findElementByXPath("//android.widget.CheckedTextView[@text='"+address.getState()+"']");

        stateElement.click();
    }

    /**
     * Set terms of service checkbox as enabled or disabled to support positive and negative tests
     * Checks the present state of the checkbox as well
     * @param shouldBeChecked true = check the box, false = do not check the box.
     * @return
     */
    public BillingAddressPage setTOSCheckbox(boolean shouldBeChecked) {
        if (shouldBeChecked) {
            enableTOSCheckBox();
        } else {
            disableTOSCheckBox();
        }
        return this;
    }

    private void enableTOSCheckBox() {
        if (!tosCheckBox.getAttribute("checked").contains("true")) {
            tosCheckBox.click();
        }
    }

    private void disableTOSCheckBox() {
        if (tosCheckBox.getAttribute("checked").contains("true")) {
            tosCheckBox.click();
        }
    }

    /**
     * Saves the bank account
     * @return
     */
    public PayPage saveBankAccountAndSubmit() {
        saveBankAccountButton.click();
        return new PayPage(driver);
    }
}
