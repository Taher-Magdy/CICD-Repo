import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.SearchPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.ParseException;

public class MainFuncTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test( priority = 1)
    public void register() throws IOException, ParseException, org.json.simple.parser.ParseException {
        new HomePage(driver)
                .ClickOnRegister()
                .gender()
                .firstName()
                .lastName()
                .dateOfBirthDay()
                .dateOfBirthMonth()
                .dateOfBirthYear()
                .email()
                .company()
                .password()
                .confirmPassword()
                .registerBtn();

        RegisterPage registerPage = new RegisterPage(driver);
        String actual = registerPage.result().getText();
        softAssert.assertTrue(actual.contains("Your registration completed"));
    }
    @Test( priority = 2)
    public void valid_login() throws IOException, ParseException, org.json.simple.parser.ParseException {
        new HomePage(driver)
                .ClickOnloginButton()
                .email()
                .password()
                .remember_me()
                .ClickOnlogin_btn();

        LoginPage loginPage = new LoginPage(driver);
        String actual = loginPage.message().getText();
        softAssert.assertFalse(actual.contains("Login was unsuccessful"));
    }

    @Test(priority = 3)
    public void Search(){
        // valid search
        new HomePage(driver)
                .validsearch();
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=Apple"), "search URL");
        // invaild search

        new SearchPage(driver)
                .invalidSearch();
        SearchPage searchPage = new SearchPage(driver);  // in this type should be before the assertion
        String actual = searchPage.noProducts().getText();
        softAssert.assertTrue(actual.contains("No products"));
        // another type of assertion
//            softAssert.assertTrue(searchPage.noProducts().isDisplayed(),"No products");
    }
}