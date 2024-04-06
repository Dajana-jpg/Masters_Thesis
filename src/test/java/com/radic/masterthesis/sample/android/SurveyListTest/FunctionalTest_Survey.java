package com.radic.masterthesis.sample.android.SurveyListTest;

import com.radic.masterthesis.sample.android.Declaration;
import com.radic.masterthesis.sample.android.Message;
import com.radic.masterthesis.sample.android.TestManager;
import com.radic.masterthesis.sample.android.DataProvider.SurveyProvider;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;

public class FunctionalTest_Survey extends TestManager {
    SoftAssert softAssert = new SoftAssert();

    @Test(dataProvider = "DataCheck", dataProviderClass = SurveyProvider.class, groups = {SurveyProvider.GROUP_REGRESSION})
    public void saveFunctionCheck(String type, BigDecimal concentration, String effortText, String concentrationText, String note) {

        Declaration.plusButton();
        Declaration.getTypeCallLocator(type).click();
        Declaration.getSliders().get(0).sendKeys(concentration.toString());

        Declaration.sendKeysToEditText(note);

        Declaration.clickConfirmButton();

        List<WebElement> lokacija = driver.findElements(By.className("android.view.View"));
        WebElement firstBlock = lokacija.get(0);
        wait.until(ExpectedConditions.visibilityOf(firstBlock));

        By block = AppiumBy.className("android.widget.TextView");

        WebElement checkedEfforts = driver.findElements(block).get(0);
        Assert.assertTrue(checkedEfforts.getText().equals(effortText));
        WebElement checkedConc = driver.findElements(block).get(1);
        Assert.assertTrue(checkedConc.getText().equals(concentrationText));

        WebElement checkedNotes = driver.findElements(block).get(3);
        Assert.assertTrue(checkedNotes.getText().equals(note));

        softAssert.assertAll();
    }

    @Test(dataProvider = "checkSurvey", dataProviderClass = SurveyProvider.class, groups = {SurveyProvider.GROUP_REGRESSION})
    public void checkSurveyDelete(String offensive, BigDecimal concentration, String note) {
        Declaration.plusButton();

        WebElement elementOffensive = Declaration.getOffensive(offensive);
        wait.until(ExpectedConditions.visibilityOf(elementOffensive));
        elementOffensive.click();

        List<WebElement> slider = Declaration.getSliders();
        slider.get(0).sendKeys(concentration.toString());

        Declaration.sendKeysToEditText(note);
        Declaration.clickConfirmButton();

        List<WebElement> locationBeforeDelete = driver.findElements(By.className("android.view.View"));
        WebElement firstBlock = locationBeforeDelete.get(0);
        wait.until(ExpectedConditions.visibilityOf(firstBlock));

        Declaration.clickDeleteButton();

        WebElement locationAfterDelete = driver.findElements(By.className("android.view.View")).get(0);
        Assert.assertTrue(locationAfterDelete.getText().isEmpty(), Message.NOT_EMPTY);
    }

    @Test(dataProvider = "Survey", dataProviderClass = SurveyProvider.class, groups = {SurveyProvider.GROUP_REGRESSION})
    public void screenFunctionCancel(String type, BigDecimal concentration, String note) {
        Declaration.plusButton();
        Declaration.getTypeCallLocator(type);
        Declaration.getSliders().get(0).sendKeys(concentration.toString());
        Declaration.sendKeysToEditText(note);
        Declaration.clickCancelButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.view.View")));
        Assert.assertTrue(driver.findElements(By.className("android.view.View")).get(0).getText().isEmpty(), Message.NOT_EMPTY);
    }

    @Test(dataProvider = "NotesCheck", dataProviderClass = SurveyProvider.class, groups = {SurveyProvider.GROUP_REGRESSION})
    public void xButtonNoteFunctionality(String note) {
        Declaration.plusButton();
        Declaration.sendKeysToEditText(note);

        List<WebElement> xButton = driver.findElements(By.className("android.widget.Button"));
        xButton.get(0).click();

        Declaration.sendKeysToEditText(note);
        Declaration.clickConfirmButton();

        By checkedNote = AppiumBy.className("android.widget.TextView");
        WebElement checkedNotes = driver.findElements(checkedNote).get(3);
        Assert.assertTrue(checkedNotes.getText().equals(note));
    }

    @Test(groups = {SurveyProvider.GROUP_REGRESSION})
    public void Defensive() {
        Declaration.plusButton();
        By locator = AppiumBy.id("radio_button_row");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement radio = driver.findElements(locator).get(1);
        Boolean checkedStatus = Boolean.parseBoolean(radio.getAttribute("checked"));
        Assert.assertTrue(checkedStatus);
    }

}
