package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SwipeorScroll {
	@Test
	public static void SwipeAndScrol() throws MalformedURLException, InterruptedException {
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
		
		//get dimention of screen
		Dimension size=driver.manage().window().getSize();
		
		int starty=(int)(size.getHeight()*0.8);
		int startx=size.getWidth()/2;
		
		int endx=startx;
		int endy=(int)(size.getHeight()*0.20);
		
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
		
		//for single scroll
		/*Sequence seq= new Sequence(finger,1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx,starty))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger,Duration.ofMillis(200)))
				.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endx,endy))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(seq));
		//driver.quit();*/
		//for scrolling three times;
		for(int i=0;i<3;i++) {
			Sequence seq= new Sequence(finger,1)
					.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx,starty))
					.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(new Pause(finger,Duration.ofMillis(200)))
					.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endx,endy))
					.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			driver.perform(Arrays.asList(seq));
			//driver.quit();
			
			//if we want to scroll from up down change starty and end y
			//int endy=(int)(size.getHeight()*0.8);
			//int starty=int endy=(int)(size.getHeight()*0.20);
		}
	}

}
