package com.demo.appium;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidTest {

  WebDriver driver;

  @Test
  public void chromeDemo() throws InterruptedException {
    Thread.sleep(10000);
    driver.get("http://nejm.org");
    System.out.println(driver.getCurrentUrl());
    driver.findElement(By.cssSelector(".text")).clear();
    driver.findElement(By.cssSelector(".text")).sendKeys("Hypertension");
    driver.findElement(By.cssSelector(".searchSubmit")).click();
  }

  @Before
  public void setUp() throws Exception {
    final DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("device", "Android");
    capabilities.setCapability("app", "Chrome");
    capabilities.setCapability(CapabilityType.VERSION, "4.3");
    capabilities.setCapability(CapabilityType.PLATFORM, "Windows");
    driver = new RemoteWebDriver(new URL("http://127.0.0.0:4723/wd/hub"),
        capabilities);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

}
