package com.demo.appium;

import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SafariLauncherTest {
  private static AppiumDriver driver;

  @Before
  public void setUp() throws Exception {
    // set up appium
    final DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("device", "iPad Device");
    capabilities.setCapability("deviceName", "iPad 3");
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("version", "7.1");
    driver = new AppiumDriver(new URL("http://10.0.5.244:4723/wd/hub"),
        capabilities);
    Thread.sleep(30000);

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

  @Test
  public void webView() throws InterruptedException {
    final Set<String> contextNames = driver.getContextHandles();
    for (final String contextName : contextNames) {
      System.out.println(contextName);
      if (contextName.contains("WEBVIEW")) {
        System.out.println("ENTERING WEBVIEW....." + contextName);
        Thread.sleep(2000);
        driver.context(contextName);
        System.out.println(driver.getTitle());
      }
    }
    Thread.sleep(2000);
    System.out.println(driver.findElement(By.className("input_text")));
    driver.findElement(By.className("input_text")).clear();
    driver.findElement(By.className("input_text")).sendKeys("Test Automation");
    driver.findElement(By.className("go")).click();
    Thread.sleep(3000);
  }

}
