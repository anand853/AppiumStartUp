package com.test.appium;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.util.base.Constants;

import io.appium.java_client.android.AndroidDriver;

public class GoogleAccess {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apk/");
		File app = new File(appDir, "myapplication");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(Constants.AUTOMATIONNAME, "appium");
		capabilities.setCapability(Constants.PLATFORMNAME, "Android");
		capabilities.setCapability(Constants.PLATFORMVERSION, "5.0");
		capabilities.setCapability(Constants.DEVICENAME, "Android Emulator");

		capabilities.setCapability(Constants.APP, app.getAbsolutePath());
		capabilities.setCapability(Constants.APPPACKAGE, "com.match.anand.myapplication");
		capabilities.setCapability(Constants.APPACTIVITY, ".LoginActivity");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:9519/wd/hub"), capabilities);

	}

	@Test
	public void testOne() {
		driver.get("http://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("anand pasunoori");

	}

	@AfterTest
	public void terminateDriver() {
		driver.quit();
	}

}
