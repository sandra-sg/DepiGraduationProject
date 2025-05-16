package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testCase.T03_LandingPage;

import java.util.List;

public class P03_LandingPage {
    public WebElement HotSellersLoc() {
        return T03_LandingPage.driver.findElement(By.xpath("//h2[text()=\"Hot Sellers\"]"));
    }
public WebElement HoverLoc() {
        return T03_LandingPage.driver.findElement(By.className("product-image-photo"));

}
public WebElement SelectSizeLoc() {
        return T03_LandingPage.driver.findElement(By.xpath("(//div[text()='M'])[2]"));
}
public WebElement SelectColorLoc() {
        return T03_LandingPage.driver.findElement(By.id("option-label-color-93-item-60"));
}
public WebElement AddToCartLoc() {
        return T03_LandingPage.driver.findElement(By.xpath("(//span[.=\"Add to Cart\"])[2]"));
}
public WebElement HoverOnBreatheEasyLoc() {
        return T03_LandingPage.driver.findElement(By.linkText("Breathe-Easy Tank"));
}
public WebElement ShoppingCartLoc() {
        return T03_LandingPage.driver.findElement(By.linkText("shopping cart"));
}

public WebElement CartIconCounterLoc() {
        return T03_LandingPage.driver.findElement(By.className("counter-number"));
}
}
