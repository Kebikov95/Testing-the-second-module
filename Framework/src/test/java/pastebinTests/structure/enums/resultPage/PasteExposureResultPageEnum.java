package pastebinTests.structure.enums.resultPage;

public enum PasteExposureResultPageEnum {
    NEVER("never"), TEN_MINUTES("10 min"),
    ONE_HOUR("60 min"), ONE_DAY("24 hours"),
    ONE_WEEK("7 days"), TWO_WEEKS("14 days"),
    ONE_MONTH("30 days"), SIX_MONTHS("180 days"),
    ONE_YEAR("365 days");

    private String timeName;

    PasteExposureResultPageEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName.toUpperCase();
    }
}
