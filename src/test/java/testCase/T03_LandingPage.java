package testCase;

import Pages.P03_LandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class T03_LandingPage {
    By AddToCartLoc=By.xpath("//span[text()=\"Add to Cart\"]");
    public static ChromeDriver driver;
    P03_LandingPage LLocs = new P03_LandingPage();

    @BeforeMethod
    void SetUp() {
        // open browser & URL
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    void TC1() {

        // Scroll Down to Hot Sellers Section
        boolean c1 = LLocs.HotSellersLoc().getText().contains("Sellers");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(c1);

        // Observe each card is displayed with Price
        for (int i = 0; i < 6; i++) {
            boolean c2 = driver.findElements(By.className("price-final_price")).get(i).getText().contains("$");
            soft.assertTrue(c2);
            soft.assertAll();
        }
    }

        @Test
        void TC2 () {

        //Scroll Down to Hot Sellers Section
        boolean c1 = LLocs.HotSellersLoc().getText().contains("Sellers");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(c1);

        Actions act = new Actions(driver);
        act.moveToElement(LLocs.HoverLoc()).perform();

        WebDriverWait Expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Expwait.until(ExpectedConditions.presenceOfElementLocated(AddToCartLoc));

        //Observe each card contains “Add to Cart”
        for (int y = 0; y < 6; y++) {
            boolean c2 = driver.findElements(By.className("tocart")).get(y).isDisplayed();
            SoftAssert zsoft= new SoftAssert();
            zsoft.assertTrue(c2);
            zsoft.assertAll();
        }

        }
        @Test
        void TC3() {

        //Hover on Card “Breathe-Easy Tank”
        Actions act = new Actions(driver);
        act.moveToElement(LLocs.HoverOnBreatheEasyLoc()).perform();
        WebDriverWait Expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Expwait.until(ExpectedConditions.presenceOfElementLocated(AddToCartLoc));

        //Select Size “M” & color & Click on Add to Cart
        LLocs.SelectColorLoc().click();
        LLocs.SelectSizeLoc().click();
        LLocs.AddToCartLoc().click();

        //Product should be added to cart successfully
        LLocs.ShoppingCartLoc().click();
        boolean s=LLocs.HoverOnBreatheEasyLoc().getText().contains("Breathe");
        SoftAssert ssoft = new SoftAssert();
        ssoft.assertTrue(s);

        boolean e=LLocs.CartIconCounterLoc().getText().contains("1");
        ssoft.assertTrue(e);
        ssoft.assertAll();

        }
        @AfterMethod
        void Quit () {
            driver.quit();
        }
    }


