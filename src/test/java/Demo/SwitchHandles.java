package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SwitchHandles {
	@Test
	public static void HandleSwitch() throws MalformedURLException, InterruptedException {
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
		
		driver.findElements(By.id("android:id/text1")).get(11).click();
		
		String ElementToSwitch ="Switches";
		
		
		WebElement switchh = driver.findElement(
			    AppiumBy.androidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true))" +
			        ".scrollIntoView(new UiSelector().text(\"" + ElementToSwitch + "\"))"
			    )
			);
		switchh.click();
		
		WebElement moniterswitch=driver.findElement(By.id("com.touchboarder.android.api.demos:id/monitored_switch"));
		//moniterswitch.click();
		Thread.sleep(2000);
		/*if(moniterswitch.isSelected()==true) {
			System.out.println("Moniterswitch is on");
		}else {
			System.out.println("Moniter switch is off.Doing switch on");
			//moniterswitch.click();
		}*/
		String state=moniterswitch.getAttribute("checked");
		System.out.println(state);
		if(state.equals("true")) {
			System.out.println("Moniterswitch is on");
		}else {
			System.out.println("Moniter switch is off.Doing switch on");
			moniterswitch.click();
		}
		Thread.sleep(5000);
		driver.quit();
		
		

	}
}
