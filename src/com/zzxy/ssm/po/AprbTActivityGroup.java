package com.zzxy.ssm.po;

import java.util.Date;

public class AprbTActivityGroup {
    private String groupNo;

    private String custNo;

    private String custName;

    private String activityName;

    private String activityType;

    private Date workday;

    private String contactStep;

    private String sourceChannels;

    private String creater;

    private Integer status;

    private String comments;

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo == null ? null : groupNo.trim();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }

    public Date getWorkday() {
        return workday;
    }

    public void setWorkday(Date workday) {
        this.workday = workday;
    }

    public String getContactStep() {
        return contactStep;
    }

    public void setContactStep(String contactStep) {
        this.contactStep = contactStep == null ? null : contactStep.trim();
    }

    public String getSourceChannels() {
        return sourceChannels;
    }

    public void setSourceChannels(String sourceChannels) {
        this.sourceChannels = sourceChannels == null ? null : sourceChannels.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}