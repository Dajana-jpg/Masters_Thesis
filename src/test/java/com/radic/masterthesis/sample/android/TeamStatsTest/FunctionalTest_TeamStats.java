package com.radic.masterthesis.sample.android.TeamStatsTest;

import com.radic.masterthesis.sample.android.Declaration;
import com.radic.masterthesis.sample.android.TestManager;
import com.radic.masterthesis.sample.android.DataProvider.TeamStatsProvider;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FunctionalTest_TeamStats extends TestManager {

    @Test(dataProvider = "TeamMenu",
            dataProviderClass = TeamStatsProvider.class,
            groups = {TeamStatsProvider.GROUP_REGRESSION})
    public void improvementsButtonFunctionality(String team) {
        Declaration.getTeam(team).click();

        By improvementsButton = AppiumBy.id("team_stats_improvements_button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(improvementsButton));
        driver.findElement(improvementsButton).click();
        driver.navigate().back();
    }

}
