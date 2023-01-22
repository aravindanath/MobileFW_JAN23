package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    protected WebDriver driver;

    @BeforeClass
    @Parameters("deviceUDID")
    public void setup(String udid) throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if(udid.length()>15) {
            desiredCapabilities.setCapability("bundleId", "com.illionsoft.thyrocare");
            desiredCapabilities.setCapability("platformName", "iOS");
            desiredCapabilities.setCapability("platformVersion", "15.6");
            desiredCapabilities.setCapability("automationName", "XCUITest");
            desiredCapabilities.setCapability("newCommandTimeout", "100");
            desiredCapabilities.setCapability("launchTimeout", "800000");
            desiredCapabilities.setCapability("deviceName", "iPhone 12 mini");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), desiredCapabilities);
        }else{
            desiredCapabilities.setCapability("appActivity","com.illionsoft.thyrocare.activity.SplashActivity");
            desiredCapabilities.setCapability("appPackage","com.illionsoft.thyrocare");
            desiredCapabilities.setCapability("platformName","Android");
            desiredCapabilities.setCapability("automationName","UiAutomator2");
            desiredCapabilities.setCapability("deviceName",udid);
            desiredCapabilities.setCapability( "deviceName", "Pixel 6 API 31");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),desiredCapabilities);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}

