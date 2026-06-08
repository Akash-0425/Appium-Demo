package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LongPress {
	static AndroidDriver driver;
	@Test
	public static void longPress() throws MalformedURLException, InterruptedException {
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
		
		WebElement eraser=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Delete\"]"));
		Point loc=eraser.getLocation();
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence seq= new Sequence(finger,1);
		seq.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), loc.x,loc.y));
		seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(finger,Duration.ofMillis(300)));
		seq.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), loc.x,loc.y));
		seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(seq));
		driver.quit();
		
		//longPressBtn(eraser);
		
		
	}
	/*public static void longPressBtn(WebElement ele) {
		Point loc=ele.getLocation();
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence seq= new Sequence(finger,1);
		seq.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), loc.x,loc.y));
		seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq.addAction(new Pause(finger,Duration.ofMillis(300)));
		seq.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), loc.x,loc.y));
		seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(seq));
		
	}*/
 

}
