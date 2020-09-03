package com.hardcore.util;

import com.structure.enums.CommittedUsageEnum;
import com.structure.enums.DataCenterLocationEnum;
import com.structure.enums.LocalSsdEnum;
import com.structure.enums.MachineTypeEnum;

public class StringUtils {
    private static final String NUMBER_OF_INSTANCE_PART_LINE = " x";
    private static  final String MACHINE_CLASS_PART_LINE = "VM class: ";
    private static  final String INSTANCE_TYPE_PART_LINE = "Instance type: ";
    private static  final String DATA_CENTER_LOCATION_PART_LINE = "Region: ";
    private static  final String LOCAL_SSD_EXPECTED_PART_LINE = "Total available local SSD space %s GiB";
    private static  final String COMMITTED_USAGE_PART_LINE = "Commitment term: ";
    private static  final String ESTIMATED_COMPONENT_PART_LINE = "Estimated Component Cost: %s per 1 month";
    private static  final String MAIL_TOTAL_COST_PART_LINE = "%s";

    public static String getNumberOfInstanceExpectedResult(int value) {
        return value + NUMBER_OF_INSTANCE_PART_LINE;
    }

    public static String getMachineClassExpectedResult(MachineTypeEnum type) {
        return MACHINE_CLASS_PART_LINE + type.getName().toLowerCase();
    }

    public static String getInstanceTypeExpectedResult(MachineTypeEnum type) {
        return INSTANCE_TYPE_PART_LINE + type.getName().split(" ")[0];
    }

    public static String getDataCenterLocationExpectedResult(DataCenterLocationEnum location) {
        return DATA_CENTER_LOCATION_PART_LINE + location.getName().split(" ")[0];
    }

    public static String getLocalSddExpectedResult(LocalSsdEnum ssd) {
        return String.format(LOCAL_SSD_EXPECTED_PART_LINE, ssd.getName().split(" ")[0]);
    }

    public static String getCommittedUsageExpectedResult(CommittedUsageEnum usage) {
        return COMMITTED_USAGE_PART_LINE + usage.getName();
    }

    public static String getEstimatedComponentPartLineExpectedResult(String cost) {
        return String.format(ESTIMATED_COMPONENT_PART_LINE, cost);
    }

    public static String getMailTotalCostExpectedResult(String cost) {
        return String.format(MAIL_TOTAL_COST_PART_LINE, cost);
    }
}
