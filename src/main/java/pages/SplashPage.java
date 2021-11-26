package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class SplashPage extends BasePage {

    private AppiumDriver driver;

    public SplashPage() {}

    public SplashPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "com.snappays:id/big_button")
    private MobileElement payBillButton;

    public SplashPage startPayBill() {
        payBillButton.click();
        return this;
    }

}
