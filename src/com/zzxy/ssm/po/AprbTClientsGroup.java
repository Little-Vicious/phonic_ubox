package com.zzxy.ssm.po;

import java.util.Date;

public class AprbTClientsGroup {
    private String groupNo;

    private String custNo;

    private String custName;

    private String custSex;

    private String cardType;

    private String cardInt;

    private String custInt;

    private String contactStep;

    private String noticeName;

    private String noticeType;

    private String followStatus;

    private Date finishDate;

    private String custGroup;

    private String noticeState;

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

    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex == null ? null : custSex.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getCardInt() {
        return cardInt;
    }

    public void setCardInt(String cardInt) {
        this.cardInt = cardInt == null ? null : cardInt.trim();
    }

    public String getCustInt() {
        return custInt;
    }

    public void setCustInt(String custInt) {
        this.custInt = custInt == null ? null : custInt.trim();
    }

    public String getContactStep() {
        return contactStep;
    }

    public void setContactStep(String contactStep) {
        this.contactStep = contactStep == null ? null : contactStep.trim();
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName == null ? null : noticeName.trim();
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
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

    public String getNoticeState() {
        return noticeState;
    }

    public void setNoticeState(String noticeState) {
        this.noticeState = noticeState == null ? null : noticeState.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}