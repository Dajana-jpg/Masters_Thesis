package com.radic.masterthesis.sample.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Declaration extends TestManager {


    private static AppiumDriver driver;

    public static void setDriver(AppiumDriver appiumDriver) {
        driver = appiumDriver;
    }

    public static void plusButton() {
        driver.findElements(By.className("android.widget.Button")).get(0).click();
    }

    public static WebElement getType(String type) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='" + type + "']"));
    }

    public static WebElement getPlayer(String player) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='" + player + "']"));
    }

    public static WebElement getSurvey(String survey) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='" + survey + "']"));
    }

    public static WebElement getTeam(String team) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='" + team + "']"));
    }

    public static WebElement getOffensive(String offensive) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='" + offensive + "']"));
    }

    public static WebElement getDefensive(String defensive) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='" + defensive + "']"));
    }

    public static WebElement getPhysical(String physical) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='" + physical + "']"));
    }

    public static List<WebElement> getSliders() {
        return driver.findElements(By.className("android.widget.SeekBar"));
    }

    public static void sendKeysToEditText(String note) {
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='text_input']")).sendKeys(note);
    }

    public static void clickConfirmButton() {
        driver.findElements(By.className("android.widget.Button")).get(2).click();
    }

    public static void clickCancelButton() {
        List<WebElement> cancel = driver.findElements(By.className("android.widget.Button"));
        cancel.get(1).click();
    }

    public static void clickDeleteButton() {
        driver.findElements(By.className("android.widget.Button"))
                .get(0).click();
    }

    public static WebElement titleLocator() {
        return driver.findElement(AppiumBy.id("improvements_alert_dialog_title"));
    }

    public static WebElement textLocator() {
        return driver.findElement(AppiumBy.id("improvements_alert_dialog_text"));
    }

    public static String playersDetailTitle() {
        return driver.findElement(AppiumBy.id("player_details_title")).getText();
    }

    public static String playersDetailName() {
        return driver.findElement(AppiumBy.id("top_bar_title")).getText();
    }

    public static WebElement imageIsDisplayed() {
        return driver.findElement(AppiumBy.id("player_details_async_image"));
    }

    public static List<WebElement> PlayerData() {
        return driver.findElements(By.className("android.widget.TextView"));
    }

    public static By playerCardName() {
        return AppiumBy.id("player_card_name");
    }

    public static By playerCardSurname() {
        return AppiumBy.id("player_card_surname");
    }

    public static By playerDOB() {
        return AppiumBy.id("player_card_dob");
    }

    public static String findStatsScroll(String stats) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + stats + "\"))")).getText();
    }

    public static String findStats(String stats) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + stats + "\")")).getText();
    }

    public static String findPercentageScroll(String percentage) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + percentage + "\"))")).getText();
    }

    public static String findPercentage(String percentage) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + percentage + "\")")).getText();
    }

    public static WebElement statsLocation(String stats) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + stats + "\"))"));
    }
}
