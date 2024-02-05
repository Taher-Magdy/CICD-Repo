package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private By ClearBTN = By.cssSelector("#product_enteredQuantity_4");
    private By wishlist_btn_element  = By.id("add-to-wishlist-button-4");
    private By AddToCartBTN = By.id("add-to-cart-button-4");
    private By added_to_cart = By.cssSelector("div[class=\"bar-notification success\"]");
    private By added_to_wishlist = By.cssSelector("div[class=\"bar-notification success\"]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clearBTN(){
        driver.findElement(ClearBTN).clear();
        return this;
    }
    public ProductPage enter_count(){
        driver.findElement(ClearBTN).sendKeys("2");
        return this;
    }
    public ProductPage wishlist_btn(){
        driver.findElement(wishlist_btn_element).click();
        return this;
    }
    public ProductPage AddToCartBTN(){
        driver.findElement(AddToCartBTN).click();
        return this;
    }
    public WebElement added_to_cart(){
        return driver.findElement(added_to_cart);
    }
    public WebElement added_to_wishlist(){
        return driver.findElement(added_to_wishlist);
    }

}
