package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By emil_ele = By.className("email");
    private By password_ele = By.className("password");
    private By login_ele = By.cssSelector("button[class=\"button-1 login-button\"]");
    private By remember_me_ele = By.id("RememberMe");
    private By forgot_password_ele = By.className("forgot-password");
    private By wrong_message_ele = By.xpath("//*[@id=\"Email-error\"]");

    public LoginPage email(){

        driver.findElement(emil_ele).sendKeys("tahermagdy90@gmail.com");
        return this;
    }
    public LoginPage password(){
        driver.findElement(password_ele).sendKeys("P@sswOrd");
        return this;
    }

    public LoginPage ClickOnlogin_btn(){
        driver.findElement(login_ele).click();
        return this;
    }
    public LoginPage remember_me(){
        driver.findElement(remember_me_ele).sendKeys("tahermagdy90@gmail.com");
        return this;
    }
    public RecoveryPassword forgot_password(){
        driver.findElement(forgot_password_ele).click();
        return new RecoveryPassword(driver);
    }
    public LoginPage wrong_message(){
        driver.findElement(wrong_message_ele).sendKeys("tahermagdy90@gmail.com");
        return this;
    }
  /*  public WebElement email(){
        return driver.findElement(emil_ele);
    }
    public void password(){
         driver.findElement(password_ele).sendKeys("P@sswOrd");
    }
    public WebElement login_btn(){
        return driver.findElement(login_ele);
    }
    public WebElement remember_me(){
        return driver.findElement(remember_me_ele);
    }
   *//* public WebElement forgot_password(){
        return driver.findElement(forgot_password_ele);
    }*//*
    public WebElement wrong_message(){
        return driver.findElement(wrong_message_ele);
    }
*/
}

