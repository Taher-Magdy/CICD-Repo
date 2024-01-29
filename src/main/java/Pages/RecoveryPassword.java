package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecoveryPassword extends BasePage{
    public RecoveryPassword(WebDriver driver) {
        super(driver);
    }
    public WebElement email ()
    {
        return driver.findElement(By.cssSelector("input[id=\"Email\"]"));
    }

    public RecoveryPassword ClickOnrecoveryButton()
    {
        driver.findElement(By.cssSelector("button[class=\"button-1 password-recovery-button\"]")).click();
        return new RecoveryPassword(driver);
    }
    /*public WebElement recoveryButton()
    {
        return driver.findElement(By.cssSelector("button[class=\"button-1 password-recovery-button\"]"));
    }*/

    public RecoveryPassword emailRec(){
         driver.findElement(By.className("email")).sendKeys("tahermagdy90@gmail.com");
        return new RecoveryPassword(driver);
    }
    /*public WebElement emailRec(){
        return driver.findElement(By.className("email"));
    }*/
    public WebElement message()
    {
        return  driver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
}
