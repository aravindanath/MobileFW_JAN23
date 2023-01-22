package testcases;

import org.testng.annotations.Test;
import pages.HomePage;

public class TC_001 extends BaseTest {

    @Test
    public void test_01() throws InterruptedException {
        String[] test = {"HbA1c","BETA HCG"};
        HomePage hp = new HomePage(driver);
        hp.permission();
        hp.navigateToLabTest();
        hp.addBloodTest(test);

    }
}
