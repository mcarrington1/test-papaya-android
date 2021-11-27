package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class PayPage extends BasePage {
    public PayPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "com.snappays:id/big_pay_button")
    private MobileElement payBillSubmitButton;

    @AndroidFindBy(id = "com.snappays:id/payment_method_txt_payment")
    private MobileElement paymentMethodInfo;

    // Note: The following elements only appear for medical bills
    @AndroidFindBy(id = "com.snappays:id/txt_next")
    private MobileElement nextButton;

    @AndroidFindBy(accessibility = "Patient Name")
    private MobileElement patientNameInput;

    @AndroidFindBy(accessibility = "Patient Date of Birth")
    private MobileElement patientDobInput;

    public PayPage setMedicalInformation(String name, String dob) {
        patientNameInput.sendKeys(name);
        patientDobInput.sendKeys(dob);
        return this;
    }

    public PayPage submitForMedicalInfo() {
        nextButton.click();
        return this;
    }

    public ConfirmationPage submitPayment() {
        payBillSubmitButton.click();
        return new ConfirmationPage(driver);
    }

    public String getPaymentInfo() {
        return paymentMethodInfo.getText();
    }
}
