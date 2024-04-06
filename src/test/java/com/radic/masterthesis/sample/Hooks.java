package com.radic.masterthesis.sample;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.TestNG;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class Hooks {
    private static AppiumDriverLocalService localAppiumServer;
    private static String APPIUM_SERVER_URL = "http://127.0.0.1:4723/";
    public static void startAppiumServer() {
        System.out.println(String.format("Start local Appium server"));
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        // Use any port, in case the default 4723 is already taken (maybe by another Appium server)
        serviceBuilder.usingPort(4723);
        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        serviceBuilder.withAppiumJS(new File("./node_modules/appium/build/lib/main.js"));
        serviceBuilder.withLogFile(new File("./target/appium_logs.txt"));
        serviceBuilder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "adb_shell");
        localAppiumServer = AppiumDriverLocalService.buildService(serviceBuilder);
        localAppiumServer.start();
        APPIUM_SERVER_URL = localAppiumServer.getUrl().toString();
        System.out.println(String.format("Appium server started on url: '%s'",
                localAppiumServer.getUrl().toString()));
    }
    public static void stopAppiumServer() {
        if (null != localAppiumServer) {
            System.out.println(String.format("Stopping the local Appium server running on: '%s'",
                    localAppiumServer.getUrl().toString()));
            localAppiumServer.stop();
            System.out.println("Is Appium server running? " + localAppiumServer.isRunning());
        }
    }
    public static URL getAppiumServerUrl() {
        System.out.println("Appium server url: " + localAppiumServer.getUrl());
        return localAppiumServer.getUrl();
    }

}
