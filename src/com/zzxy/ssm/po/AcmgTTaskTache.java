package com.zzxy.ssm.po;

import java.util.Date;

public class AcmgTTaskTache {
    private String tacheId;

    private String tacheName;

    private String tacheFlag;

    private String taskId;

    private String tacheType;

    private Integer tacheStutas;

    private Date tacheTime;

    private Date tacheStartTime;

    private Date tacheEndTime;

    private Integer tacheIndex;

    public String getTacheId() {
        return tacheId;
    }

    public void setTacheId(String tacheId) {
        this.tacheId = tacheId == null ? null : tacheId.trim();
    }

    public String getTacheName() {
        return tacheName;
    }

    public void setTacheName(String tacheName) {
        this.tacheName = tacheName == null ? null : tacheName.trim();
    }

    public String getTacheFlag() {
        return tacheFlag;
    }

    public void setTacheFlag(String tacheFlag) {
        this.tacheFlag = tacheFlag == null ? null : tacheFlag.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getTacheType() {
        return tacheType;
    }

    public void setTacheType(String tacheType) {
        this.tacheType = tacheType == null ? null : tacheType.trim();
    }

    public Integer getTacheStutas() {
        return tacheStutas;
    }

    public void setTacheStutas(Integer tacheStutas) {
        this.tacheStutas = tacheStutas;
    }

    public Date getTacheTime() {
        return tacheTime;
    }

    public void setTacheTime(Date tacheTime) {
        this.tacheTime = tacheTime;
    }

    public Date getTacheStartTime() {
        return tacheStartTime;
    }

    public void setTacheStartTime(Date tacheStartTime) {
        this.tacheStartTime = tacheStartTime;
    }

    public Date getTacheEndTime() {
        return tacheEndTime;
    }

    public void setTacheEndTime(Date tacheEndTime) {
        this.tacheEndTime = tacheEndTime;
    }

    public Integer getTacheIndex() {
        return tacheIndex;
    }

    public void setTacheIndex(Integer tacheIndex) {
        this.tacheIndex = tacheIndex;
    }
}