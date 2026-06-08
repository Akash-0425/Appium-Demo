package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Practice {
	@Test(priority=1,enabled =true)
	public static void practice() throws MalformedURLException {
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("");
		options.setPlatformName("");
		options.setAutomationName("");
		options.setNoReset(true);
		options.setAppPackage("");
		options.setAppActivity(" ");
		
		URL url=URI.create("http://127.0.0.1:/4723").toURL();
		AndroidDriver driver= new AndroidDriver(url,options);
		
		
		String ElementtoSwitch="Switches";
		WebElement switc=driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))"+
				".scrollIntoView(new UiSelector().text(\""+ElementtoSwitch+"\"))"
				)
				);
		
		
		
	}

}
