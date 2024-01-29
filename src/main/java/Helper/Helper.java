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

   /* public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

                // Adding timestamp to make the screenshot name unique
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String timestamp = dateFormat.format(new Date());

                // Creating the directory if it doesn't exist
                File directory = new File("./ScreenShots/");
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File destination = new File(directory, screenshotName + "_" + timestamp + ".png");
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot taken: " + destination.getAbsolutePath());
            } else {
                System.out.println("Driver does not support screenshots");
            }
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }*/
}
