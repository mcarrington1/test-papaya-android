package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class SplashPage extends BasePage {
    public SplashPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
    private static final Logger logger = LogManager.getLogger(SplashPage.class);

    @AndroidFindBy(id = "com.snappays:id/big_button")
    private MobileElement payBillButton;

    /**
     * Start bill pay process from splash page
     * @return
     */
    public CaptureBillPage startPayBill() {
        logger.info("Starting payment process");
        payBillButton.click();
        return new CaptureBillPage(driver);
    }
}
