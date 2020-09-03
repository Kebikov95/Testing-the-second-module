package com.hardcore.service;

import com.hardcore.model.ComputeEngine;
import com.structure.enums.*;

public class ComputeEngineCreator {
    private static int NUMBER_OF_INSTANCE;
    private static MachineTypeEnum MACHINE_TYPE;
    private static NumberOfGpusEnum NUMBER_OF_GPUS;
    private static GpuTypeEnum GPU_TYPE;
    private static LocalSsdEnum LOCAL_SSD;
    private static DataCenterLocationEnum DATA_CENTER_LOCATION;
    private static CommittedUsageEnum COMMITTED_USAGE;
    private static String MAIL_TOTAL_COST;

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
}
