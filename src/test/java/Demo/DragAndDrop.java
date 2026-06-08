`package Demo;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;

public class DragAndDrop {
	@Test
	public static void DraganDrop() throws MalformedURLException, InterruptedException {
		
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
		
		//Click on View
		//driver.findElements(By.id("android:id/text1")).get(12).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Views\"]")).click();
		System.out.println("Clicked on Views");
		//Click on Drop and Drown
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Drag and Drop\"]")).click();
		System.out.println("Clicked on Drag and Drop");
		
		WebElement source =driver.findElement(By.xpath("//android.view.View[@resource-id=\"com.touchboarder.android.api.demos:id/drag_dot_1\"]"));
		WebElement target =driver.findElement(By.xpath("//android.view.View[@resource-id=\"com.touchboarder.android.api.demos:id/drag_dot_2\"]"));
		
		//By using W3C API class
		
		Point sourceEWlementCenter=getCenter(source);
		Point targetEWlementCenter=getCenter(target);
		
		//PointerInput class to create a sequence of Actions
		
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
		
		Sequence seq= new Sequence(finger,1)
		//move finger to the starting point
		.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceEWlementCenter))
		
		//finger coming down to contact screen
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(finger,Duration.ofMillis(588)))
		
		//move finger to the end position
		.addAction(finger.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(), targetEWlementCenter))
		
		//move fingerbuttonUp
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		//Perform sequence of Actions
		
		driver.perform(Arrays.asList(seq));
		driver.quit();
		
		
		
		

		
		
		
		
		
	}
	public static Point getCenter(WebElement element) {
		//GET LOCATION
		Point location=element.getLocation();
		//get size
		Dimension size= element.getSize();
		
		//getcenter
		
		Point Center=new Point(location.x+size.width/2,location.y+size.height/2);
		return Center;
	}

}
