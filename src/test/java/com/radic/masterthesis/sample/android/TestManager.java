package com.radic.masterthesis.sample.android;

import com.radic.masterthesis.sample.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;

public class TestManager {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    public void beforeAll() {
        Hooks.startAppiumServer();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        String methodName = method.getName();
        String udid = "9e490bfdd263fc9f";
        System.out.println(String.format("Running test '%s' on '%s'", methodName, udid));
        driver = createAppiumDriver(udid);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        Declaration.setDriver(driver);
    }

    @AfterSuite
    public void afterAll() {
        Hooks.stopAppiumServer();
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (null != driver) {
            System.out.println("Close the driver");
            driver.quit();
            driver = null;
        }
    }

    private AppiumDriver createAppiumDriver(String udid) {
        System.out.println(String.format("Create AppiumDriver with appium server with device udid - '%s'", udid));

        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        //capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability("unlockType", "pin");
        capabilities.setCapability("unlockKey", "7354");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("disableIdLocatorAutocompletion", true);
        capabilities.setCapability("idleTimeout", 6000);
        capabilities.setCapability("newCommandTimeout", 6000);
        capabilities.setCapability("app",
                new File("src/test/resources/sampleApps/trainingHelper.apk").getAbsolutePath());
        URL appiumServerUrl = Hooks.getAppiumServerUrl();
        AndroidDriver appiumDriver = new AndroidDriver(appiumServerUrl, capabilities);
        System.out.println(String.format("Created AppiumDriver for - %s, appiumPort - %s", udid, appiumServerUrl));
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Cancel']")).click();
        return appiumDriver;
    }
}
