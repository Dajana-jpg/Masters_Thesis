package com.radic.masterthesis.sample.android.PlayersTest;

import com.radic.masterthesis.sample.android.Declaration;
import com.radic.masterthesis.sample.android.TestManager;
import com.radic.masterthesis.sample.android.Message;
import com.radic.masterthesis.sample.android.DataProvider.PlayerProvider;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class FunctionalTest_Players extends TestManager {
    @Test(dataProvider = "improvementsTest", dataProviderClass = PlayerProvider.class, groups = {PlayerProvider.GROUP_REGRESSION})
    public void improvements(String player) {
        SoftAssert softAssert = new SoftAssert();

        wait.until(ExpectedConditions.visibilityOf(Declaration.getPlayer(player)));
        Declaration.getPlayer(player).click();

        List<WebElement> block = driver.findElements(By.className("android.view.View"));
        WebElement elementBlock = block.get(10);

        new Actions(driver)
                .click(elementBlock)
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("player_details_improvements_button")));
        By improvementButton = AppiumBy.id("player_details_improvements_button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(improvementButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/content")));
        softAssert.assertEquals(Declaration.titleLocatorPlayers().getText(), Message.IMPROVEMENTS);
        softAssert.assertEquals(Declaration.textLocator().getText(), Message.STRING, Message.IS_A_KNOWN_BUG);

        softAssert.assertAll();
    }

}
