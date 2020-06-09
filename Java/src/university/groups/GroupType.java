package university.groups;

public enum GroupType {
    BUSINESS_ECONOMICS("Business economics"),
    WORLD_ECONOMY("World economy"),
    AUTOMATED_ELECTRIC("Automated electric"),
    ENTERPRISES_ENERGY("Enterprises energy"),
    JAVA_DEVELOPMENT("Java development"),
    WEB_DEVELOPMENT("WEB development");

    private String groupName;
    GroupType(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }
}
