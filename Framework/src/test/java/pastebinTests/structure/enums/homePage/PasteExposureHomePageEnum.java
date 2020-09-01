package pastebinTests.structure.enums.homePage;

public enum PasteExposureHomePageEnum {
    NEVER("Never"), TEN_MINUTES("10 Minutes"),
    ONE_HOUR("1 Hour"), ONE_DAY("1 Day"),
    ONE_WEEK("1 Week"), TWO_WEEKS("2 Weeks"),
    ONE_MONTH("1 Month"), SIX_MONTHS("6 Months"),
    ONE_YEAR("1 Year");

    private String timeName;

    PasteExposureHomePageEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName;
    }
}
