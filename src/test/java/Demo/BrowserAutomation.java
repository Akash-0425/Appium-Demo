package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserAutomation {
	@Test
	public static void brAut() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();

		options.setPlatformName("Android");
		options.setDeviceName("OPPO CPH 1931");
		options.setAutomationName("uiautomator2");

		options.setCapability("browserName", "Chrome");

		options.setChromedriverExecutable(
		"C:\\Users\\kumar\\eclipse-workspace\\AppiumDemo\\driver\\chromedriver-win64\\chromedriver.exe"
		);

		URL url = URI.create("http://127.0.0.1:4723").toURL();

		AndroidDriver driver = new AndroidDriver(url, options);

		driver.get("https://www.google.com/");
		//AndroidDriver driver=new AndroidDriver(url,options);	
		driver.get("https://www.google.com/");
		//chrome://inspect/#devices
		
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("Taj Mahal");
		searchbox.sendKeys(Keys.RETURN);
		
		Thread.sleep(5000);
		System.out.println("Application Started");
	}

}
