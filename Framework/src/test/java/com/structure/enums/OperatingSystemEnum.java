package com.structure.enums;

public enum OperatingSystemEnum {
    DEBAIN_CENTOS_COREOS_UBUNTU_AND_OTHER("Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS"),
    WINDOWS_SERVER_2008_2012_2016_CORE("Windows Server 2008r2, Windows Server 2012r2, Windows Server 2016, Windows Core"),
    RED_HAT_ENTERPRISE_LINUX("Red Hat Enterprise Linux"),
    RED_HAT_ENTERPRISE_LINUX_FOR_SAP("Red Hat Enterprise Linux for SAP Applications"),
    RED_HAT_ENTERPRISE_LINUX_FOR_SAP_WITH_UPDATE("Red Hat Enterprise Linux for SAP with HA and Update Services"),
    SLES("SLES"),
    SLES_FOR_SAP("SLES for SAP"),
    SQL_SERVER_STANDARD_2012_2014_2016_2017_2019("SQL Server Standard (2012, 2014, 2016, 2017, 2019)"),
    SQL_SERVER_WEB_2012_2014_2016_2017_2019("SQL Server Web (2012, 2014, 2016, 2017, 2019)"),
    SQL_SERVER_ENTERPRISE_2012_2014_2016_2017_2019("SQL Server Enterprise (2012, 2014, 2016, 2017, 2019)");

    private String timeName;

    OperatingSystemEnum(String timeName) {
        this.timeName = timeName;
    }

    public String getName() {
        return timeName;
    }
}
