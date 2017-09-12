package com.zzxy.ssm.po;

import java.util.Date;

public class AprbTOppoGroup {
    private String groupNo;

    private String custNo;

    private String custName;

    private String oppoName;

    private String oppoType;

    private String followStatus;

    private Date finishDate;

    private String custGroup;

    private String custNumber;

    private String oppoState;

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

    public String getOppoName() {
        return oppoName;
    }

    public void setOppoName(String oppoName) {
        this.oppoName = oppoName == null ? null : oppoName.trim();
    }

    public String getOppoType() {
        return oppoType;
    }

    public void setOppoType(String oppoType) {
        this.oppoType = oppoType == null ? null : oppoType.trim();
    }

    public String getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus == null ? null : followStatus.trim();
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getCustGroup() {
        return custGroup;
    }

    public void setCustGroup(String custGroup) {
        this.custGroup = custGroup == null ? null : custGroup.trim();
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber == null ? null : custNumber.trim();
    }

    public String getOppoState() {
        return oppoState;
    }

    public void setOppoState(String oppoState) {
        this.oppoState = oppoState == null ? null : oppoState.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}