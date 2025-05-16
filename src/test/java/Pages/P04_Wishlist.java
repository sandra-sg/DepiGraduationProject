package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testCase.T03_LandingPage;
import testCase.T04_Wishlist;

public class P04_Wishlist {
    public WebElement HSellersLoc() {
        return T04_Wishlist.driver.findElement(By.className("content-heading"));
    }
    public WebElement HoverCardLoc() {
        return T04_Wishlist.driver.findElement(By.className("product-image-photo"));
    }
    public WebElement AddtoWishlistLoc() {
        return T04_Wishlist.driver.findElement(By.className("towishlist"));
    }
    public WebElement LoginLoc() {
        return T04_Wishlist.driver.findElement(By.className("page-title-wrapper"));
    }
    public WebElement MyWishListLoc() {
        return T04_Wishlist.driver.findElement(By.className("page-title"));
    }
    public WebElement SignInLoc () {
        return T04_Wishlist.driver.findElement(By.linkText("Sign In"));
    }
    public WebElement UsernameLoc() {
        return T04_Wishlist.driver.findElement(By.name("login[username]"));
    }
    public WebElement PasswordLoc() {
        return T04_Wishlist.driver.findElement(By.name("login[password]"));
    }
    public WebElement LoginButtonLoc() {
        return T04_Wishlist.driver.findElement(By.className("primary"));
    }

}
