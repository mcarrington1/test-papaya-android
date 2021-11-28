package E2E;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public AndroidDriver<MobileElement> driver;

    @BeforeMethod
    @Parameters({"deviceName","udid","platformName","platformVersion"})
    public void setupDriver(@Optional("test2") String deviceName, @Optional("emulator-5554") String udid,
                            @Optional("Android") String platformName, @Optional("10.0") String platformVersion)
            throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("udid", udid); //DeviceId from "adb devices" command
        caps.setCapability("platformName", platformName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.snappays");
        caps.setCapability("appActivity", "com.snappays.activity.LandingActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps); // If using Appium 3.0+ drop the /wd/hub/
    }
}
