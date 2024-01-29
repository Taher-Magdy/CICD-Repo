package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage{
    Select select;
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private By gender_male_ele = By.id("gender-male");
    private By firstName_ele = By.id("FirstName");
    private By lastName_ele = By.id("LastName");
    private By dateOfBirthDay_ele = By.name("DateOfBirthDay");
    private By dateOfBirthMonth_ele = By.name("DateOfBirthMonth");
    private By dateOfBirthYear_ele = By.name("DateOfBirthYear");
    private By email_ele = By.id("Email");
    private By company_ele = By.id("Company");
    private By password_ele = By.id("Password");
    private By confirmPassword_ele = By.id("ConfirmPassword");
    private By registerBtn_ele = By.name("register-button");
    private By result_ele =  By.className("result");
    private By to_home_page =  By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img");
    private By continueBtn_ele =  By.className("button-1");

    public RegisterPage gender(){
        driver.findElement(gender_male_ele).click(); ;
        return this;
    }
    public RegisterPage firstName(){
        driver.findElement(firstName_ele).sendKeys("Taher");
        return this;
    }
    public RegisterPage lastName(){
        driver.findElement(lastName_ele).sendKeys("Magdy"); ;
        return this;
    }
    public RegisterPage dateOfBirthDay(){
        select = new Select(driver.findElement(dateOfBirthDay_ele));
        select.selectByIndex(10);
        return this;
    }
    public RegisterPage dateOfBirthMonth(){
        select = new Select( driver.findElement(dateOfBirthMonth_ele));
        select.selectByVisibleText("December");
        return this;
    }
    public RegisterPage dateOfBirthYear(){
        select = new Select(driver.findElement(dateOfBirthYear_ele));
        select.selectByValue("1998");
        return this;
    }
    public RegisterPage email(){
        driver.findElement(email_ele).sendKeys("tahermagdy13@gmail.com");
        return this;
    }
    public RegisterPage company(){
        driver.findElement(company_ele).sendKeys("T_M") ;
        return this;
    }
    public RegisterPage password(){
        driver.findElement(password_ele).sendKeys("P@sswOrd");
        return this;
    }
    public RegisterPage confirmPassword(){
        driver.findElement(confirmPassword_ele).sendKeys("P@sswOrd") ;
        return this;
    }

    public HomePage registerBtn(){
        driver.findElement(registerBtn_ele).click();
        return new HomePage(driver);
    }
   /* public Pages.HomePage navigateBackToHomePage() {
        driver.navigate().to("https://demo.nopcommerce.com/");
       return new Pages.HomePage(driver);
    }
*/

    public WebElement result(){
        return driver.findElement(result_ele);
    }


   /* public WebElement gender_male(){
        return driver.findElement(gender_male_ele) ;
    }
    public WebElement firstName(){
        return driver.findElement(firstName_ele) ;
    }
    public WebElement lastName(){
        return driver.findElement(lastName_ele) ;
    }
    public WebElement dateOfBirthDay(){
        return driver.findElement(dateOfBirthDay_ele) ;
    }
    public WebElement dateOfBirthMonth(){
        return driver.findElement(dateOfBirthMonth_ele) ;
    }
    public WebElement dateOfBirthYear(){
        return driver.findElement(dateOfBirthYear_ele) ;
    }
    public WebElement email(){
        return driver.findElement(email_ele) ;
    }
    public WebElement company(){
        return driver.findElement(company_ele) ;
    }
    public WebElement password(){
        return driver.findElement(password_ele);
    }
    public WebElement confirmPassword(){
        return driver.findElement(confirmPassword_ele) ;
    }
    public WebElement registerBtn(){

        return driver.findElement(registerBtn_ele) ;
    }
    public WebElement result(){
        return driver.findElement(result_ele);
    }
    public WebElement continueBtn(){
        return  driver.findElement(continueBtn_ele);
    }
*/}
