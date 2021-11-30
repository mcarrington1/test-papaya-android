package E2E;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestBase {

    public AndroidDriver<MobileElement> driver;
    private final String apkResourceLocation = "/apk/com.snappays.3669220.apk";

    @BeforeSuite
    @Parameters({"deviceName","udid","platformName","platformVersion"})
    public void setupDriver(@Optional("test2") String deviceName, @Optional("emulator-5554") String udid,
                            @Optional("Android") String platformName, @Optional("10.0") String platformVersion)
            throws MalformedURLException, URISyntaxException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", getApkAbsolutePath());
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

    private String getApkAbsolutePath() throws URISyntaxException {
        URI uri = getClass().getClassLoader().getResource("apk/com.snappays.3669220.apk").toURI();
        return Paths.get(uri).toString();
    }
}
