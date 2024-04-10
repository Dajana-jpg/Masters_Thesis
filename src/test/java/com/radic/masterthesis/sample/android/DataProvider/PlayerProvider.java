package com.radic.masterthesis.sample.android.DataProvider;

import org.testng.annotations.DataProvider;


public class PlayerProvider {

    public final static String GROUP_SMOKE = "smoke";
    public final static String GROUP_REGRESSION = "regression";

    @DataProvider(name = "Menu")
    protected static Object[][] menu() {
        return new Object[][]{
                {"SurveyList", "Players", "Team stats"}
        };
    }

    @DataProvider(name = "Player")
    protected static Object[][] player() {
        return new Object[][]{
                {"Players", "Speed", "81.0%"},
                {"Players", "Stamina", "77.0%"},
                {"Players", "Strength", "85.0%"},
                {"Players", "Ball control", "82.0%"},
                {"Players", "Concentration", "77.0%"},
                {"Players", "Creativity", "84.0%"},
                {"Players", "Teamwork", "89.0%"},
                {"Players", "Shot Power", "89.0%"}
        };

    }

    @DataProvider(name = "improvementsTest")
    protected static Object[][] improvementsTest() {
        return new Object[][]{
                {"Players"}
        };
    }

    @DataProvider(name = "PlayerContent")
    protected static Object[][] playerContent() {
        return new Object[][]{
                {"Players"}
        };
    }

}
