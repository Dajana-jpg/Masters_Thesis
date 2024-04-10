package com.radic.masterthesis.sample.android.DataProvider;

import org.testng.annotations.DataProvider;

import java.math.BigDecimal;


public class SurveyProvider {

    public final static String GROUP_SMOKE = "smoke";
    public final static String GROUP_REGRESSION = "regression";

    @DataProvider(name = "Survey")
    protected static Object[][] surveyInput() {
        return new Object[][]{
                {"Offensive", BigDecimal.valueOf(0.55), "Some note"},
        };
    }

    @DataProvider(name = "DataCheck")
    protected static Object[][] dataCheck() {
        return new Object[][]{
                {"Offensive", BigDecimal.valueOf(0.55), "Team effort: 0.0 %", "Team concentration: 55.0%", "Some note"},
        };
    }

    @DataProvider(name = "TrainingType")
    protected static Object[][] type() {
        return new Object[][]{
                {"Offensive", BigDecimal.valueOf(0.55), BigDecimal.valueOf(0.55), "Some note"}
        };
    }

    @DataProvider(name = "CheckSurvey")
    protected static Object[][] checkSurvey() {
        return new Object[][]{
                {"Offensive", BigDecimal.valueOf(0.55), "Some note"}
        };
    }

    @DataProvider(name = "Menu")
    protected static Object[][] navigate() {
        return new Object[][]{
                {"Players", "SurveyList", "Team stats"}
        };
    }

    @DataProvider(name = "TextTest")
    protected static Object[][] surveyTraining() {
        return new Object[][]{
                {"What type of training you had?"},
                {"What was your teams level of concentration?"},
                {"How do you rate your teams effort?"},
                {"This is where you write your additional notes..."}
        };

    }

    @DataProvider(name = "NotesCheck")
    protected static Object[][] xButton() {
        return new Object[][]{
                {"Some note"}
        };
    }

    @DataProvider(name = "EmptyScreen")
    protected static Object[][] emptyScreen() {
        return new Object[][]{
                {"There aren't any saved Training Sessions"}
        };
    }

    @DataProvider(name = "SurveyTrainingButton")
    protected static Object[][] surveyTrainingButton() {
        return new Object[][]{
                {"Offensive", "Defensive", "Physical"}
        };
    }
}