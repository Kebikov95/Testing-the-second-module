package com.hardcore.model;

import com.structure.enums.*;

import java.util.Objects;

public class ComputeEngine {
    private int numberOfInstances;
    private MachineTypeEnum machineType;
    private NumberOfGpusEnum numberOfGpus;
    private GpuTypeEnum gpuType;
    private LocalSsdEnum localSsd;
    private DataCenterLocationEnum dataCenterLocation;
    private CommittedUsageEnum committedUsage;

    public ComputeEngine(int numberOfInstances, MachineTypeEnum machineType,
                         NumberOfGpusEnum numberOfGpus, GpuTypeEnum gpuType, LocalSsdEnum localSsd,
                         DataCenterLocationEnum dataCenterLocation, CommittedUsageEnum committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.machineType = machineType;
        this.numberOfGpus = numberOfGpus;
        this.gpuType = gpuType;
        this.localSsd = localSsd;
        this.dataCenterLocation = dataCenterLocation;
        this.committedUsage = committedUsage;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public MachineTypeEnum getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineTypeEnum machineType) {
        this.machineType = machineType;
    }

    public NumberOfGpusEnum getNumberOfGpus() {
        return numberOfGpus;
    }

    public void setNumberOfGpus(NumberOfGpusEnum numberOfGpus) {
        this.numberOfGpus = numberOfGpus;
    }

    public GpuTypeEnum getGpuType() {
        return gpuType;
    }

    public void setGpuType(GpuTypeEnum gpuType) {
        this.gpuType = gpuType;
    }

    public LocalSsdEnum getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(LocalSsdEnum localSsd) {
        this.localSsd = localSsd;
    }

    public DataCenterLocationEnum getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(DataCenterLocationEnum dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public CommittedUsageEnum getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(CommittedUsageEnum committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances=" + numberOfInstances +
                ", machineType=" + machineType +
                ", numberOfGpus=" + numberOfGpus +
                ", gpuType=" + gpuType +
                ", localSsd=" + localSsd +
                ", dataCenterLocation=" + dataCenterLocation +
                ", committedUsage=" + committedUsage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return numberOfInstances == that.numberOfInstances &&
                machineType == that.machineType &&
                numberOfGpus == that.numberOfGpus &&
                gpuType == that.gpuType &&
                localSsd == that.localSsd &&
                dataCenterLocation == that.dataCenterLocation &&
                committedUsage == that.committedUsage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, machineType, numberOfGpus, gpuType, localSsd, dataCenterLocation, committedUsage);
    }
}
