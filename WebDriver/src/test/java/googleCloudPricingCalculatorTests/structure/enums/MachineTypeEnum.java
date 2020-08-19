package googleCloudPricingCalculatorTests.structure.enums;

public enum MachineTypeEnum {
    CUSTOM_MACHINE_TYPE("Custom Machine Type"),
    F1_MICRO("f1-micro    (vCPUs: shared, RAM: 0.60 GB)"),
    G1_SMALL("g1-small    (vCPUs: shared, RAM: 1.70 GB)"),
    N1_STANDARD_1("n1-standard-1 (vCPUs: 1, RAM: 3.75GB)"),
    N1_STANDARD_2("n1-standard-2 (vCPUs: 2, RAM: 7.5GB)"),
    N1_STANDARD_4("n1-standard-4 (vCPUs: 4, RAM: 15GB)"),
    N1_STANDARD_8("n1-standard-8 (vCPUs: 8, RAM: 30GB)"),
    N1_STANDARD_16("n1-standard-16 (vCPUs: 16, RAM: 60GB)"),
    N1_STANDARD_32("n1-standard-32 (vCPUs: 32, RAM: 120GB)"),
    N1_STANDARD_64("n1-standard-64 (vCPUs: 64, RAM: 240GB)"),
    N1_STANDARD_96("n1-standard-96 (vCPUs: 96, RAM: 360GB)"),
    N1_HIGHMEM_2("n1-highmem-2 (vCPUs: 2, RAM: 13GB)"),
    N1_HIGHMEM_4("n1-highmem-4 (vCPUs: 4, RAM: 26GB)"),
    N1_HIGHMEM_8("n1-highmem-8 (vCPUs: 8, RAM: 52GB)"),
    N1_HIGHMEM_16("n1-highmem-16 (vCPUs: 16, RAM: 104GB)"),
    N1_HIGHMEM_32("n1-highmem-32 (vCPUs: 32, RAM: 208GB)"),
    N1_HIGHMEM_64("n1-highmem-64 (vCPUs: 64, RAM: 416GB)"),
    N1_HIGHMEM_96("n1-highmem-96 (vCPUs: 96, RAM: 624GB)"),
    N1_HIGHCPU_2("n1-highcpu-2 (vCPUs: 2, RAM: 1.8GB)"),
    N1_HIGHCPU_4("n1-highcpu-4 (vCPUs: 4, RAM: 3.6GB)"),
    N1_HIGHCPU_8("n1-highcpu-8 (vCPUs: 8, RAM: 7.2GB)"),
    N1_HIGHCPU_16("n1-highcpu-16 (vCPUs: 16, RAM: 14.4GB)"),
    N1_HIGHCPU_32("n1-highcpu-32 (vCPUs: 32, RAM: 28.8GB)"),
    N1_HIGHCPU_64("n1-highcpu-64 (vCPUs: 64, RAM: 57.6GB)"),
    N1_HIGHCPU_96("n1-highcpu-96 (vCPUs: 96, RAM: 86.4GB)");

    private String timeName;

    MachineTypeEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName;
    }
}

