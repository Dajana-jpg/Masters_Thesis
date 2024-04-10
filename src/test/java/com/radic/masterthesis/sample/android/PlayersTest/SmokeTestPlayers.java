package com.radic.masterthesis.sample.android.PlayersTest;

import com.radic.masterthesis.sample.android.DataProvider.PlayerProvider;
import com.radic.masterthesis.sample.android.Declaration;
import com.radic.masterthesis.sample.android.Message;
import com.radic.masterthesis.sample.android.TestManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class SmokeTestPlayers extends TestManager {
    @Test(dataProvider = "Menu",
            dataProviderClass = PlayerProvider.class,
            groups = {PlayerProvider.GROUP_SMOKE})
    public void smokeTestNavigation
            (String survey, String player, String team) {
        Declaration.getPlayer(player).click();
        Declaration.getTeam(team).click();
        Declaration.getPlayer(player).click();
        Declaration.getSurvey(survey).click();
    }

    @Test(dataProvider = "improvementsTest", dataProviderClass = PlayerProvider.class, groups = {PlayerProvider.GROUP_SMOKE})
    public void smokeTestUIView(String player) {
        SoftAssert softAssert = new SoftAssert();
        Declaration.getPlayer(player).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Declaration.playerCardName()));

        WebElement name = driver.findElement(Declaration.playerCardName());
        WebElement surname = driver.findElement(Declaration.playerCardSurname());
        WebElement dateOfBirth = driver.findElement(Declaration.playerDOB());
        softAssert.assertEquals(name.getText().trim(), "Reece");
        softAssert.assertEquals(surname.getText(), "James");
        softAssert.assertEquals(dateOfBirth.getText(), "DOB: 8.12.1999.");

        softAssert.assertEquals(Declaration.PlayerData().get(3).getText(), "24");
        softAssert.assertEquals(Declaration.PlayerData().get(4).getText(), "1");
        softAssert.assertEquals(Declaration.PlayerData().get(5).getText(), "RB");
        softAssert.assertEquals(Declaration.PlayerData().get(6).getText(), "0");
        softAssert.assertEquals(Declaration.PlayerData().get(7).getText(), "1");

        softAssert.assertAll();
    }

    @Test(dataProvider = "PlayerContent", dataProviderClass = PlayerProvider.class, groups = {PlayerProvider.GROUP_SMOKE})
    public void smokeTestBlock(String player) {
        SoftAssert softAssert = new SoftAssert();

        WebElement playerElement = Declaration.getPlayer(player);
        wait.until(ExpectedConditions.visibilityOf(playerElement));
        playerElement.click();

        List<WebElement> block = driver.findElements(By.className("android.view.View"));
        wait.until(ExpectedConditions.elementToBeClickable(block.get(10)));
        WebElement elementBlock = wait.until(ExpectedConditions.elementToBeClickable(block.get(10)));

        new Actions(driver)
                .moveToElement(elementBlock)
                .click()
                .perform();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.id("top_bar_title")));
        Assert.assertEquals(Declaration.playersDetailName(), "Reece  James, 24");
        wait.until(ExpectedConditions.visibilityOfAllElements(Declaration.imageIsDisplayed()));
        Assert.assertTrue(Declaration.imageIsDisplayed().isDisplayed());
        Assert.assertEquals(Declaration.playersDetailTitle(), Message.PLAYERS_TITLE);

        softAssert.assertAll();
    }

    @Test(dataProvider = "Player", dataProviderClass = PlayerProvider.class, groups = {PlayerProvider.GROUP_SMOKE})
    public void smokeTestData(String player, String stats, String percentage) {
        SoftAssert softAssert = new SoftAssert();
        WebElement playerElement = Declaration.getPlayer(player);
        playerElement.click();

        List<WebElement> block = driver.findElements(By.className("android.view.View"));
        wait.until(ExpectedConditions.elementToBeClickable(block.get(10)));
        WebElement elementBlock = wait.until(ExpectedConditions.elementToBeClickable(block.get(10)));

        new Actions(driver)
                .moveToElement(elementBlock)
                .click()
                .perform();

        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(Declaration.statsLocation(stats)));
            softAssert.assertEquals(Declaration.findStatsScroll(stats), stats);

        } catch (NoSuchElementException e) {
            softAssert.assertEquals(Declaration.findStats(stats), stats);
        }

        try {
            softAssert.assertEquals(Declaration.findPercentageScroll(percentage), percentage);

        } catch (NoSuchElementException e) {
            softAssert.assertEquals(Declaration.findPercentage(percentage), percentage);
        }

        softAssert.assertAll();
    }
}
