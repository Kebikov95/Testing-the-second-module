package com.structure.enums;

public enum MachineClassEnum {
    REGULAR("Regular"), PREEMPTIBLE("Preemptible");

    private String timeName;

    MachineClassEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName;
    }
}
