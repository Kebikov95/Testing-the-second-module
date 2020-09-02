package com.hardcore.service;

import com.hardcore.model.ComputeEngine;
import com.structure.enums.*;

public class ComputeEngineCreator {
    public static final int NUMBER_OF_INSTANCE = 4;
    public static final MachineTypeEnum MACHINE_TYPE = MachineTypeEnum.N1_STANDARD_8;
    public static final NumberOfGpusEnum NUMBER_OF_GPUS = NumberOfGpusEnum.ONE;
    public static final GpuTypeEnum GPU_TYPE = GpuTypeEnum.NVIDIA_TESLA_V100;
    public static final LocalSsdEnum LOCAL_SSD = LocalSsdEnum.TWO;
    public static final DataCenterLocationEnum DATA_CENTER_LOCATION = DataCenterLocationEnum.FRANKFURT;
    public static final CommittedUsageEnum COMMITTED_USAGE = CommittedUsageEnum.ONE_YEAR;

    public static ComputeEngine withOptimalParameters() {
        return new ComputeEngine(NUMBER_OF_INSTANCE, MACHINE_TYPE, NUMBER_OF_GPUS, GPU_TYPE,
                LOCAL_SSD, DATA_CENTER_LOCATION, COMMITTED_USAGE);
    }
}
