package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AutomateDialer {
	@Test
	public static void autDial() throws MalformedURLException, InterruptedException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName("OPPO CPH1931");
		options.setAutomationName("uiautomator2");
		options.setAppActivity("com.android.contacts.DialtactsActivityAlias");
		options.setAppPackage("com.android.contacts");
		options.setNoReset(true);
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver= new AndroidDriver(url,options);
		
		Thread.sleep(5000);
		System.out.println("Application started");
		
		driver.findElement(By.id("com.android.contacts:id/nine")).click();
		driver.findElement(By.id("com.android.contacts:id/zero")).click();
		driver.findElement(By.id("com.android.contacts:id/eight")).click();
		driver.findElement(By.id("com.android.contacts:id/four")).click();
		driver.findElement(By.id("com.android.contacts:id/eight")).click();
		driver.findElement(By.id("com.android.contacts:id/six")).click();
		driver.findElement(By.id("com.android.contacts:id/five")).click();
		driver.findElement(By.id("com.android.contacts:id/four")).click();
		driver.findElement(By.id("com.android.contacts:id/five")).click();
		
		driver.findElement(By.id("com.android.contacts:id/eight")).click();
		driver.findElement(By.id("com.android.contacts:id/dial_icon")).click();
		Thread.sleep(5000);
		
		driver.close();
		
		
	}

}
