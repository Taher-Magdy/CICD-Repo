package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WishlistPage extends BasePage{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }
    public int wishListItems(){
        int size = driver.findElements(By.cssSelector("div[class=\"wishlist-content\"]")).size();
        return size;
    }
    public WebElement addWishListInPage() {
        return driver.findElement(By.id("add-to-wishlist-button-4"));
    }

    public WebElement wishSuccessMsg() {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }
    public void ram4() {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("2 GB");
    }
    public WebElement hdd320() {
        return driver.findElement(By.xpath("//*[@id=\"product_attribute_3_6\"]"));
    }

}
