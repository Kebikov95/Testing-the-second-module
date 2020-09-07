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

    public static ComputeEngine createComputeEngine() {
        NUMBER_OF_INSTANCE = Integer.valueOf(TestDataReader.getTestData("number_of_instance"));
        MACHINE_TYPE = MachineTypeEnum.valueOf(TestDataReader.getTestData("machine_type"));
        NUMBER_OF_GPUS = NumberOfGpusEnum.valueOf(TestDataReader.getTestData("number_of_gpus"));
        GPU_TYPE = GpuTypeEnum.valueOf(TestDataReader.getTestData("gpu_type"));
        LOCAL_SSD = LocalSsdEnum.valueOf(TestDataReader.getTestData("local_ssd"));
        DATA_CENTER_LOCATION = DataCenterLocationEnum.valueOf(TestDataReader.getTestData("data_center_location"));
        COMMITTED_USAGE = CommittedUsageEnum.valueOf(TestDataReader.getTestData("committed_usage"));
        MAIL_TOTAL_COST = TestDataReader.getTestData("mail_total_cost");
        return new ComputeEngine(NUMBER_OF_INSTANCE, MACHINE_TYPE, NUMBER_OF_GPUS, GPU_TYPE,
                LOCAL_SSD, DATA_CENTER_LOCATION, COMMITTED_USAGE, MAIL_TOTAL_COST);
    }
}
