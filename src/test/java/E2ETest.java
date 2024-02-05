import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.SearchPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.ParseException;

public class E2ETest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 1)
    public void valid_login() throws IOException, ParseException, org.json.simple.parser.ParseException {
        new HomePage(driver)
                .ClickOnloginButton()
                .email()
                .password()
                .remember_me()
                .ClickOnlogin_btn();
    }
    @Test(priority = 2)
    public void Search(){
        // valid search
        new HomePage(driver)
                .validsearch();
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=Apple"), "search URL");
    }

    @Test(priority = 3)
    public void Product_chart() {
        new SearchPage(driver)
                .clickOnProduct()
                .clearBTN()
                .enter_count()
                .wishlist_btn();
        ProductPage productPage = new ProductPage(driver);
        String actual = productPage.added_to_wishlist().getText();
        softAssert.assertTrue(actual.contains("The product has been added"));

        new ProductPage(driver)
                .AddToCartBTN();
        String actual2 = productPage.added_to_cart().getText();
        softAssert.assertTrue(actual2.contains("The product has been added"));
    }
}