package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class APKInstall {

	public static void main(String[] args) throws MalformedURLException, InterruptedException   {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//How to install apk on virtual divice
		capabilities.setCapability("devicename","AndroidEmulator");
		capabilities.setCapability("platform","Android");
		capabilities.setCapability("automationName","uiautomator2");
		capabilities.setCapability("app","path");
		capabilities.setCapability("androidVersion", "13");
		//how to install apk on Real Device
		/*capabilities.setCapability("devicename","OPPO CPH1931");
		capabilities.setCapability("platform","Android");
		capabilities.setCapability("automationName","uiautomator2");
		capabilities.setCapability("app","path");
		capabilities.setCapability("androidVersion", "13");*/
		
		URL url=URI.create("http://127.0.0.1:4723").toURL();
		AndroidDriver driver= new AndroidDriver(url,capabilities);
		Thread.sleep(5000);
		System.out.println("Application Started");
		driver.quit();

	}

}
