package com.structure.enums;

public enum GpuTypeEnum {
    NVIDIA_TESLA_K80("NVIDIA Tesla K80"),
    NVIDIA_TESLA_P100("NVIDIA Tesla P100"),
    NVIDIA_TESLA_P4("NVIDIA Tesla P4"),
    NVIDIA_TESLA_V100("NVIDIA Tesla V100"),
    NVIDIA_TESLA_T4("NVIDIA Tesla T4");

    private String timeName;

    GpuTypeEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName;
    }
}

