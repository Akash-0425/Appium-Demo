package Demo;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AutomateCalculator {

    @Test(priority=1, enabled=true)
    public static void automateCal() throws MalformedURLException, InterruptedException {
        
        // Use UiAutomator2Options instead of DesiredCapabilities for Appium 8+ / Selenium 4
        UiAutomator2Options options = new UiAutomator2Options();
        
        // Setting capabilities using the new strongly-typed methods
        options.setDeviceName("OPPO CPH1931");
        options.setPlatformName("Android");
        options.setAutomationName("uiautomator2");
        
        // appPackage and appActivity now use setAppPackage and setAppActivity
        options.setAppPackage("com.coloros.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.setNoReset(true);

        // Convert URI to URL safely
        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        
        // Pass the 'options' object instead of 'capabilities'
        AndroidDriver driver = new AndroidDriver(url, options);
        
        Thread.sleep(5000);
        System.out.println("Application started");

        // Click on 8
        WebElement eight = driver.findElement(By.id("com.coloros.calculator:id/digit_8"));
        eight.click();
        
        // Click on plus
        WebElement plus = driver.findElement(By.id("com.coloros.calculator:id/op_add"));
        plus.click();
        
        //Click on two
        WebElement two=driver.findElement(By.id("com.coloros.calculator:id/digit_2"));
        two.click();
        
        // click equal
        WebElement equal = driver.findElement(By.id("com.coloros.calculator:id/eq"));
        equal.click();

        // verify result
        WebElement result = driver.findElement(By.id("com.coloros.calculator:id/result"));

        String Result = result.getText();

        if (Result.equals("10")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.quit();
        
        // Optional: Good practice to quit the driver session at the end
        driver.quit();
    }
}