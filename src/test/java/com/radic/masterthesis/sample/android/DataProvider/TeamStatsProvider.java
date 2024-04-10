package com.radic.masterthesis.sample.android.DataProvider;

import org.testng.annotations.DataProvider;

public class TeamStatsProvider {

    public final static String GROUP_SMOKE = "smoke";
    public final static String GROUP_REGRESSION = "regression";

    @DataProvider(name = "Menu")
    protected static Object[][] menu() {
        return new Object[][]{
                {"SurveyList", "Players", "Team stats"}

        };
    }

    @DataProvider(name = "Team")
    protected static Object[][] team() {
        return new Object[][]{
                {"Team stats", "Speed", "72.0%"},
                {"Team stats", "Stamina", "73.0%"},
                {"Team stats", "Strength", "70.0%"},
                {"Team stats", "Ball control", "77.0%"},
                {"Team stats", "Concentration", "79.0%"},
                {"Team stats", "Creativity", "79.0%"},
                {"Team stats", "Teamwork", "85.0%"},
                {"Team stats", "Shot Power", "74.0%"}
        };
    }

    @DataProvider(name = "TeamMenu")
    protected static Object[][] teamMenu() {
        return new Object[][]{
                {"Team stats"}
        };
    }

}
