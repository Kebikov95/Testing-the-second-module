package com.structure.enums;

public enum NumberOfGpusEnum {
    ZERO("0"), ONE("1"),
    TWO("2"), FOUR("4"), EIGHT("8");

    private String timeName;

    NumberOfGpusEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName;
    }
}

