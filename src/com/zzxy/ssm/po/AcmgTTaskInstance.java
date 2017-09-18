package com.zzxy.ssm.po;

import java.util.Date;

public class AcmgTTaskInstance {
    private String instanceId;

    private String instanceType;

    private String instanceName;

    private String instanceFlag;

    private Integer instanceStatus;

    private Date instanceTime;

    private Date instanceStartTime;

    private Date instanceEndTime;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId == null ? null : instanceId.trim();
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType == null ? null : instanceType.trim();
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName == null ? null : instanceName.trim();
    }

    public String getInstanceFlag() {
        return instanceFlag;
    }

    public void setInstanceFlag(String instanceFlag) {
        this.instanceFlag = instanceFlag == null ? null : instanceFlag.trim();
    }

    public Integer getInstanceStatus() {
        return instanceStatus;
    }

    public void setInstanceStatus(Integer instanceStatus) {
        this.instanceStatus = instanceStatus;
    }

    public Date getInstanceTime() {
        return instanceTime;
    }

    public void setInstanceTime(Date instanceTime) {
        this.instanceTime = instanceTime;
    }

    public Date getInstanceStartTime() {
        return instanceStartTime;
    }

    public void setInstanceStartTime(Date instanceStartTime) {
        this.instanceStartTime = instanceStartTime;
    }

    public Date getInstanceEndTime() {
        return instanceEndTime;
    }

    public void setInstanceEndTime(Date instanceEndTime) {
        this.instanceEndTime = instanceEndTime;
    }
}