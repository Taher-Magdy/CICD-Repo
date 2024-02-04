package Helper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Helper {
    public static void captureScreenshot(WebDriver driver, String screenshotName)
    {
        Path dest = Paths.get("screenshots", screenshotName+".png");
        try {
            Files.createDirectories(dest.getParent());
            OutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot"+e.getMessage());
        }
    }
}
