package com.structure.enums;

public enum CommittedUsageEnum {
    NONE("NONE"), ONE_YEAR("1 Year"),
    THREE_YEARS("3 Years");

    private String timeName;

    CommittedUsageEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName;
    }
}
