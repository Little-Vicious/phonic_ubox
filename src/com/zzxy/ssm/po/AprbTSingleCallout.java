package com.zzxy.ssm.po;

import java.util.Date;

public class AprbTSingleCallout {
    private String callNo;

    private String batchNo;

    private String projectType;

    private Date startTime;

    private Integer duration;

    private String custName;

    private String custNumber;

    private String custType;

    private String custNo;

    private Date disposeTime;

    private Date lastUpdateTime;

    private String result;

    private Integer calloutTimes;

    private Integer calloutStatus;

    private Integer allotStatus;

    private String belongOrg;

    private String custChannels;

    private String area;

    public String getCallNo() {
        return callNo;
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo == null ? null : callNo.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber == null ? null : custNumber.trim();
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public Date getDisposeTime() {
        return disposeTime;
    }

    public void setDisposeTime(Date disposeTime) {
        this.disposeTime = disposeTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Integer getCalloutTimes() {
        return calloutTimes;
    }

    public void setCalloutTimes(Integer calloutTimes) {
        this.calloutTimes = calloutTimes;
    }

    public Integer getCalloutStatus() {
        return calloutStatus;
    }

    public void setCalloutStatus(Integer calloutStatus) {
        this.calloutStatus = calloutStatus;
    }

    public Integer getAllotStatus() {
        return allotStatus;
    }

    public void setAllotStatus(Integer allotStatus) {
        this.allotStatus = allotStatus;
    }

    public String getBelongOrg() {
        return belongOrg;
    }

    public void setBelongOrg(String belongOrg) {
        this.belongOrg = belongOrg == null ? null : belongOrg.trim();
    }

    public String getCustChannels() {
        return custChannels;
    }

    public void setCustChannels(String custChannels) {
        this.custChannels = custChannels == null ? null : custChannels.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}