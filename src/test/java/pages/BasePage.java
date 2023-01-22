package pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(30)), this);
    }



    public static void scroll(WebDriver driver, String text) {
        String value = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"" + text + "\"));";
        ((AndroidDriver) driver).findElementByAndroidUIAutomator(value);
    }

    public static void scrollAndClick(WebDriver driver, String text) {
        String value = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"" + text + "\"));";
        ((AndroidDriver) driver).findElementByAndroidUIAutomator(value).click();
    }


    public static ArrayList<String> getTextFromElement(List<WebElement> element) {
        System.out.println("Count: " + element.size());
        ArrayList<String> productPrice = new ArrayList<String>(); // Empty array
        for (WebElement ref : element) {
            productPrice.add(ref.getText().replace("$", ""));
        }
        return productPrice;
    }


    public static void addingProducts(List<WebElement> element) {
        System.out.println("Count: " + element.size());
        for (WebElement ref : element) {
            ref.click();
        }
    }

    public static void longPress(WebDriver driver, WebElement element) {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)).withDuration(Duration.ofSeconds(2))).release().perform();
    }

    public static void tap(WebDriver driver, WebElement element) {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
    }


    public static String getOTP(String otpmsg) {
        String otp = null;
        for (String str : otpmsg.split(" ")) {
            if (str.matches("\\d{6}")) {
                otp = str;
            } else if (str.matches("\\d{4}")) {
                otp = str;
            }
        }
        return otp;
    }

    public static boolean isAndroid(WebDriver driver) {
        return driver != null && driver.toString().toLowerCase().contains("android");
    }

    public static boolean isIosDriver(WebDriver driver) {
        return driver != null && driver.toString().toLowerCase().contains("ios");
    }
}

