package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class HandleTextBoxCheckBoxRadioButton {
	@Test
	public static void handletextboxCheckBoxandRadioButn() throws MalformedURLException, InterruptedException {
		
			UiAutomator2Options options=new UiAutomator2Options();
			options.setPlatformName("Android");
			options.setDeviceName("OPPO CPH");
			options.setAutomationName("uiautomator2");
			options.setNoReset(true);
			
			options.setAppPackage("com.touchboarder.android.api.demos");
			options.setAppActivity("com.example.android.apis.ApiDemos");
			
			URL url =URI.create("http://127.0.0.1:4723/").toURL();
			AndroidDriver driver = new AndroidDriver(url,options);
			
			Thread.sleep(5000);
			System.out.println("Application Started");
			//Click on View
			driver.findElements(By.id("android:id/text1")).get(11).click();
			System.out.println("Clicked on Views");
			//Click on Controls
			driver.findElements(By.id("android:id/text1")).get(4).click();
			System.out.println("Clicked on controls");
			//Click on LightTheme
			driver.findElements(By.id("android:id/text1")).get(0).click();
			System.out.println("Clicked on Light Theme");
			//Enter text in text field
			driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit")).sendKeys("Akash");
			System.out.println("Text is written");
			//Slect Checkbox
			driver.findElement(By.id("com.touchboarder.android.api.demos:id/check1")).click();
			System.out.println("checkbox is selected");
			//Select Radio button
			driver.findElement(By.id("com.touchboarder.android.api.demos:id/radio1")).click();
			System.out.println("Radio button is selected");
			driver.quit();
		
		}

}
