import Helper.Helper;
import Pages.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    public static ExtentReports extent;
    public static ExtentTest logger;
    ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @Parameters({"Browser"})
    @BeforeClass
    public void openDriver() throws InterruptedException {
        // HuB-Node mode
       /* if(Browser.equals("chrome")){
        driver = WebDriverManager.chromiumdriver().remoteAddress("http://localhost:4444").create();}
        else if(Browser.equals("edge")){
        driver = WebDriverManager.edgedriver().remoteAddress("http://localhost:4444").create();}*/



        // Standalone mode
        /*String hubUrl = "http://192.168.1.109:4444";
        if(Browser.equals("chrome")){
        driver = WebDriverManager.chromiumdriver().remoteAddress(hubUrl).create();}
        else if(Browser.equals("edge")){
        driver = WebDriverManager.edgedriver().remoteAddress(hubUrl).create();}*/

        // this is run success
        /*capabilities.setCapability("browserName", "MicrosoftEdge");
        driver = new RemoteWebDriver(new URL("http://192.168.80.1:4444"), capabilities);*/

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
    }

    @BeforeTest
    public void beforeTestMethod() {
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "extent.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("extent");
        htmlReporter.config().setReportName("Extent Report");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Taher");
        log.info("Setting up test suite...");
    }


    @BeforeMethod
        public void setupTest(ITestResult result) {
        logger = extent.createTest(result.getMethod().getMethodName());
        }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed !");
            System.out.println("Taking Screenshot...");
            Helper.captureScreenshot(driver, result.getName());
        }
    }

    @AfterMethod
    public void afterMethoMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, "Test Failed");
            logger.log(Status.FAIL, result.getThrowable());
            String MethodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + MethodName + "Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, m);

        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, "Test Skipped");
            String MethodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + MethodName + "Skipped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP, m);

        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, "Test Passed");
            String MethodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + MethodName + "Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);
        }
    }
    @AfterTest
    public void afterTest() {
        extent.flush();
        log.info("Tearing down test Method");
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

}

