import Pages.HomePage;
import Pages.SearchPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class RegisterPageTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void register() {
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
    }
    @Test( priority = 1)
    public void valid_login() {
        new HomePage(driver)
                .ClickOnloginButton()
                .email()
                .password()
                .ClickOnlogin_btn();
    }

    @Test(priority = 2)
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