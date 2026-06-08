package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class HandlingDropDown {
	@Test
	public static void dropdown() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options=new UiAutomator2Options() ;
		options.setPlatformName("Android");
		options.setDeviceName("OPPO CPH 1931");
		options.setAutomationName("uiautomator2");
		options.setNoReset(true);
		
		options.setAppPackage("com.touchboarder.android.api.demos");
		options.setAppActivity("com.example.android.apis.ApiDemos");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		
		AndroidDriver driver=new AndroidDriver(url,options);	
		
		Thread.sleep(5000);
		System.out.println("Application Started");
		
		//Click on Views
		driver.findElements(By.id("android:id/text1")).get(11).click();
		//click on controls
		driver.findElements(By.id("android:id/text1")).get(4).click();
		//click on light theme
		driver.findElements(By.id("android:id/text1")).get(0).click();
		Thread.sleep(2000);
		//click on 
		//driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.touchboarder.android.api.demos:id/spinner1\"]")).click();
		System.out.println("clicked on webelement");
		
		//driver.findElements(By.id("android:id/text1")).get(1).click();
		Thread.sleep(2000);
		//click on Earth
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Earth\"]")).click();
		
		
		//driver.findElements(By.id("android:id/text1")).get(2).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
