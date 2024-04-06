package com.radic.masterthesis.sample.android.SurveyListTest;

import com.radic.masterthesis.sample.android.Declaration;
import com.radic.masterthesis.sample.android.TestManager;
import com.radic.masterthesis.sample.android.DataProvider.SurveyProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;


public class SmokeTest_Survey extends TestManager {

    @Test(dataProvider = "TextTest", dataProviderClass = SurveyProvider.class, groups = {SurveyProvider.GROUP_SMOKE})
    public void trainingText(String type) {

        Declaration.plusButton();
        WebElement typeCall = Declaration.getTypeCallLocator(type);
        System.out.println("Found: " + typeCall);
    }

    @Test(dataProvider = "Menu", dataProviderClass = SurveyProvider.class, groups = {SurveyProvider.GROUP_SMOKE})
    public void smokeTestNavigation(String player, String survey, String team) {
        Declaration.getPlayer(player).click();
        Declaration.getSurvey(survey).click();
        Declaration.getTeam(team).click();
    }

    @Test(dataProvider = "EmptyScreen", dataProviderClass = SurveyProvider.class, groups = {SurveyProvider.GROUP_SMOKE})
    public void emptyScreen(String emptyText) {
        List<WebElement> empty = driver.findElements(By.className("android.widget.TextView"));
        Assert.assertEquals(empty.get(0).getText(), emptyText);
    }

    @Test(dataProvider = "surveyTrainingButton", dataProviderClass = SurveyProvider.class, groups = {SurveyProvider.GROUP_SMOKE})
    public void trainingButtons(String offensive, String defensive, String physical) {
        Declaration.plusButton();
        Declaration.getOffensive(offensive).click();
        Declaration.getDefensive(defensive).click();
        Declaration.getPhysical(physical).click();
    }

    @Test(dataProvider = "TrainingType", dataProviderClass = SurveyProvider.class, groups = {SurveyProvider.GROUP_SMOKE})
    public void plusButtonToDelete(String offensive, BigDecimal concentration, BigDecimal effort, String note) {
        Declaration.plusButton();
        Declaration.getOffensive(offensive).click();

        List<WebElement> sliders = Declaration.getSliders();
        sliders.get(0).sendKeys(concentration.toString());
        sliders.get(1).sendKeys(effort.toString());

        Declaration.sendKeysToEditText(note);

        Declaration.clickConfirmButton();
        Declaration.clickDeleteButton();
    }
}
