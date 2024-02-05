package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public WebElement noProducts(){
        return driver.findElement(By.className("no-result"));
    }
    public SearchPage invalidSearch() {
        driver.findElement(By.id("small-searchterms")).sendKeys("nothing");
        driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]")).click();
        return new SearchPage(driver);
    }
    public ProductPage clickOnProduct(){
        driver.findElement(By.cssSelector("div[class=\"product-item\"]")).click();
        return new ProductPage(driver);
    }

}
