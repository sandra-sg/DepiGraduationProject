package testCase;

import Pages.P03_LandingPage;
import Pages.P04_Wishlist;
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

public class T04_Wishlist {
    By wishlistloc =By.className("towishlist");

    public static ChromeDriver driver;
    P04_Wishlist WLocs = new P04_Wishlist();

    @BeforeMethod
    void SetUp() {
        //Open browser & URL & maximizing window
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test
    void TC1() {

        // Scroll down to "Hot Sellers Section"
        boolean c1 = WLocs.HSellersLoc().getText().contains("Sellers");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(c1);

        // Hover on any card and click on “Add to Wishlist” button
        Actions act = new Actions(driver);
        act.moveToElement(WLocs.HoverCardLoc()).perform();

        WebDriverWait Expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Expwait.until(ExpectedConditions.presenceOfElementLocated(wishlistloc));

        WLocs.AddtoWishlistLoc().click();

        //User should be navigated to login page
        boolean r = WLocs.LoginLoc().getText().contains("Login");
        SoftAssert ssoft = new SoftAssert();
        ssoft.assertTrue(r);
        soft.assertAll();

    }
    @Test
    void TC2() {
        // User logging in
        WLocs.SignInLoc().click();
        WLocs.UsernameLoc().sendKeys("sandra.sgorgi@gmail.com");
        WLocs.PasswordLoc().sendKeys("12345StrongPassword");
        WLocs.LoginButtonLoc().click();

        // Scroll Down to Hot Sellers Section
        boolean x = WLocs.HSellersLoc().getText().contains("Sellers");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(x);

        // Hover on any card and click on “Add to Wishlist” button
        Actions act = new Actions(driver);
        act.moveToElement(WLocs.HoverCardLoc()).perform();

        WebDriverWait Expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Expwait.until(ExpectedConditions.presenceOfElementLocated(wishlistloc));

        WLocs.AddtoWishlistLoc().click();

        // navigated to My Wishlist page with the same product added to Wishlist from landing page
        boolean s = WLocs.MyWishListLoc().isDisplayed();
        SoftAssert ysoft = new SoftAssert();
        ysoft.assertTrue(s);

        boolean h = WLocs.HoverCardLoc().isDisplayed();
        SoftAssert zsoft = new SoftAssert();
        zsoft.assertTrue(h);
        soft.assertAll();
    }

    @AfterMethod
    void Quit() {
        driver.quit();

    }
}

