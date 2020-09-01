package pastebinTests.structure.enums.homePage;

public enum SyntaxHighlightingHomePageEnum {
    NONE("None"), BASH("Bash"),
    C("C"), C_SHARP("C#"), C_PLUS_PLUS("C++"),
    CSS("CSS"), HTML("HTML"),
    JSON("JSON"), JAVA("Java"),
    JAVA_SCRIPT("JavaScript"), LUA("Lua");

    private String timeName;

    SyntaxHighlightingHomePageEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName;
    }
}
