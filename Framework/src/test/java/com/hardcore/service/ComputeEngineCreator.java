package com.hardcore.service;

import com.hardcore.model.ComputeEngine;
import com.structure.enums.*;

public class ComputeEngineCreator {
    public static final String COMPUTE_ENGINE_TYPE = "compute.engine.type";
    private static int NUMBER_OF_INSTANCE;
    private static MachineTypeEnum MACHINE_TYPE;
    private static NumberOfGpusEnum NUMBER_OF_GPUS;
    private static GpuTypeEnum GPU_TYPE;
    private static LocalSsdEnum LOCAL_SSD;
    private static DataCenterLocationEnum DATA_CENTER_LOCATION;
    private static CommittedUsageEnum COMMITTED_USAGE;
    private static String MAIL_TOTAL_COST;

    public static ComputeEngine createComputeEngine() {
        ComputeEngine engine;
        String type = TestDataReader.getTestData(COMPUTE_ENGINE_TYPE);
        switch (type) {
            case "light": {
                engine = withLightParameters();
            }
            case "complicated": {
                engine = withComplicatedParameters();
            }
            default: {
                engine = withOptimalParameters();
            }
        }
        return engine;
    }

    public static ComputeEngine withOptimalParameters() {
        NUMBER_OF_INSTANCE = 4;
        MACHINE_TYPE = MachineTypeEnum.N1_STANDARD_8;
        NUMBER_OF_GPUS = NumberOfGpusEnum.ONE;
        GPU_TYPE = GpuTypeEnum.NVIDIA_TESLA_V100;
        LOCAL_SSD = LocalSsdEnum.TWO;
        DATA_CENTER_LOCATION = DataCenterLocationEnum.FRANKFURT;
        COMMITTED_USAGE = CommittedUsageEnum.ONE_YEAR;
        MAIL_TOTAL_COST = "USD 1,082.77";
        return new ComputeEngine(NUMBER_OF_INSTANCE, MACHINE_TYPE, NUMBER_OF_GPUS, GPU_TYPE,
                LOCAL_SSD, DATA_CENTER_LOCATION, COMMITTED_USAGE, MAIL_TOTAL_COST);
    }

    public static ComputeEngine withLightParameters() {
        NUMBER_OF_INSTANCE = 1;
        MACHINE_TYPE = MachineTypeEnum.N1_STANDARD_1;
        NUMBER_OF_GPUS = NumberOfGpusEnum.ONE;
        GPU_TYPE = GpuTypeEnum.NVIDIA_TESLA_K80;
        LOCAL_SSD = LocalSsdEnum.ONE;
        DATA_CENTER_LOCATION = DataCenterLocationEnum.SOUTH_CAROLINA;
        COMMITTED_USAGE = CommittedUsageEnum.ONE_YEAR;
        MAIL_TOTAL_COST = "USD 247.56";
        return new ComputeEngine(NUMBER_OF_INSTANCE, MACHINE_TYPE, NUMBER_OF_GPUS, GPU_TYPE,
                LOCAL_SSD, DATA_CENTER_LOCATION, COMMITTED_USAGE, MAIL_TOTAL_COST);
    }

    public static ComputeEngine withComplicatedParameters() {
        NUMBER_OF_INSTANCE = 8;
        MACHINE_TYPE = MachineTypeEnum.N1_HIGHCPU_96;
        NUMBER_OF_GPUS = NumberOfGpusEnum.EIGHT;
        GPU_TYPE = GpuTypeEnum.NVIDIA_TESLA_K80;
        LOCAL_SSD = LocalSsdEnum.EIGHT;
        DATA_CENTER_LOCATION = DataCenterLocationEnum.NORTHERN_VIRGINIA;
        COMMITTED_USAGE = CommittedUsageEnum.THREE_YEARS;
        MAIL_TOTAL_COST = "USD 10,522.84";
        return new ComputeEngine(NUMBER_OF_INSTANCE, MACHINE_TYPE, NUMBER_OF_GPUS, GPU_TYPE,
                LOCAL_SSD, DATA_CENTER_LOCATION, COMMITTED_USAGE, MAIL_TOTAL_COST);
    }
}
