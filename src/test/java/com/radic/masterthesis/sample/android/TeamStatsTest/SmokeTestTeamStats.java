package com.radic.masterthesis.sample.android.TeamStatsTest;

import com.radic.masterthesis.sample.android.DataProvider.TeamStatsProvider;
import com.radic.masterthesis.sample.android.Declaration;
import com.radic.masterthesis.sample.android.Message;
import com.radic.masterthesis.sample.android.TestManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SmokeTestTeamStats extends TestManager {

    @Test(dataProvider = "Menu", dataProviderClass = TeamStatsProvider.class, groups = {TeamStatsProvider.GROUP_SMOKE})
    public void smokeTestNavigation(String survey, String player, String team) {
        Declaration.getTeam(team).click();
        Declaration.getPlayer(player).click();
        Declaration.getTeam(team).click();
        Declaration.getSurvey(survey).click();
        Declaration.getTeam(team).click();
    }

    @Test(dataProvider = "TeamMenu", dataProviderClass = TeamStatsProvider.class, groups = {TeamStatsProvider.GROUP_SMOKE})
    public void improvements(String team) {
        SoftAssert softAssert = new SoftAssert();
        Declaration.getTeam(team).click();

        By teamText = AppiumBy.id("team_stats_title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(teamText));
        softAssert.assertEquals(driver.findElement(teamText).getText(), Message.TEAM_STATS_TEXT);

        driver.findElement(AppiumBy.id("team_stats_improvements_button")).click();

        softAssert.assertEquals(Declaration.titleLocator().getText(), Message.IMPROVEMENTS, Message.TITLE_TEXT_DOES_NOT_MATCH);
        softAssert.assertEquals(Declaration.textLocator().getText(), Message.TEAM_STAT_IMPROVEMENT_TEXT, Message.IS_A_KNOWN_BUG);
        softAssert.assertAll();
    }

    @Test(dataProvider = "Team", dataProviderClass = TeamStatsProvider.class, groups = {TeamStatsProvider.GROUP_SMOKE})
    public void teamData(String team, String stats, String percentage) {
        SoftAssert softAssert = new SoftAssert();
        wait.until(ExpectedConditions.visibilityOf(Declaration.getTeam(team))).click();

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
