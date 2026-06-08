package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppManagement {
	public static void appManag() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options() ;
		options.setPlatformName("Android");
		options.setDeviceName("OPPO CPH 1931");
		options.setAutomationName("uiautomator2");
		options.setNoReset(true);
		
		//options.setAppPackage("com.touchboarder.android.api.demos");
		//options.setAppActivity("com.example.android.apis.ApiDemos");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		
		AndroidDriver driver=new AndroidDriver(url,options);	
		String packageName=" ";
		driver.removeApp(packageName);
		driver.terminateApp(packageName);
		driver.isAppInstalled(packageName);
		
		driver.installApp("C:\\Users\\kumar\\OneDrive\\Desktop\\API Demos for Android_1.9.0_APKPure.apk");
		//activate app
		driver.activateApp(packageName);
		//install app only if it is not installed in phone
		if(!driver.isAppInstalled(packageName)){
			driver.installApp("C:\\Users\\kumar\\OneDrive\\Desktop\\API Demos for Android_1.9.0_APKPure.apk");
		}else {
			System.out.println("App is already installed");
		}
	}

}
