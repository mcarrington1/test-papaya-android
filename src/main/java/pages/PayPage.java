package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class PayPage extends BasePage {

    private AppiumDriver driver;

    public PayPage() {}

    public PayPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "com.snappays:id/big_pay_button")
    private MobileElement payBillSubmitButton;

    @AndroidFindBy(id = "com.snappays:id/payment_method_txt_payment")
    private MobileElement paymentMethodInfo;

    public PayPage submitPayment() {
        payBillSubmitButton.click();
        return this;
    }

    public String getPaymentInfo() {
        return paymentMethodInfo.getText();
    }

}
