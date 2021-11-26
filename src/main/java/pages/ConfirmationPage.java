package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class ConfirmationPage extends BasePage {
    public ConfirmationPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "com.snappays:id/iv_bill_success")
    private MobileElement paymentSuccessImage;

    @AndroidFindBy(id = "com.snappays:id/btn_continue")
    private MobileElement continueButton;

    public Boolean isSuccessfulPaymentImageDisplayed() {
        return paymentSuccessImage.isDisplayed();
    }

    public ConfirmationPage continueFromPage() {
        continueButton.click();
        return this;
    }
}
