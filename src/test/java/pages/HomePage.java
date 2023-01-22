package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage{

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    WebElement persmissionButton;

    @AndroidFindBy(id = "com.illionsoft.thyrocare:id/btn_skip")
    WebElement skipButton;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Menu opened']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Open navigation menu'`]")
    WebElement navigationMenu;


    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Lab Tests'")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lab Tests']")
    WebElement labtestMenu;

    @AndroidFindBy(id = "com.illionsoft.thyrocare:id/edtSearch")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label contains 'Looking for...'`]")
    WebElement searchBar;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther/XCUIElementTypeStaticText[3]")
    WebElement bloodTest;

    @AndroidFindBy(xpath = "(//android.widget.ToggleButton[@resource-id='com.illionsoft.thyrocare:id/togCart'])[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Add To Cart\"`]")
    WebElement addToCartButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Back\"`]")
    WebElement backButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeLink[`label == \"Skip now\"`]")
    WebElement skipNow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Lab Tests\"]//following-sibling::XCUIElementTypeStaticText")
    WebElement cartIcon;


    public void permission(){

        try{
            persmissionButton.click();
            skipButton.click();
        }catch (Exception e){

        }
    }

    public void navigateToLabTest(){

        navigationMenu.click();
        labtestMenu.click();
    }

    public void addBloodTest(String[] test) throws InterruptedException {
        searchBar.click();
        for(int i=0;i<test.length;i++) {
            searchBar.clear();
            searchBar.sendKeys(test[i]);
            try{
                if(isIosDriver(driver)){
                bloodTest.click();
                skipNow.click();
                navigateToLabTest();
                searchBar.sendKeys(test[i]);
                bloodTest.click();
                }

            }catch (Exception e){
                if(isIosDriver(driver)) {
                    addToCartButton.click();
                    Thread.sleep(3000);
                    if (backButton.isDisplayed()) {
                        backButton.click();
                    }
                    searchBar.clear();
                }
            }
            if(isAndroid(driver)){
                addToCartButton.click();
            }


            Thread.sleep(3000);
        }
    }

}
