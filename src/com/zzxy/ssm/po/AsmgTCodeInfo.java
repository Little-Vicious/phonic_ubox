package com.zzxy.ssm.po;

import java.util.Date;

public class AsmgTCodeInfo {
    private String codeValue;

    private String typeCode;

    private String codeName;

    private String local;

    private Integer indexNo;

    private String remark;

    private String dataSrc;

    private String insertUser;

    private String insertUserName;

    private String creatorOrgNo;

    private String creatorOrg;

    private String insertIpaddress;

    private Date insertDatetime;

    private String updateUser;

    private String updateUserName;

    private String modiferOrgNo;

    private String modiferOrg;

    private String updateIpaddress;

    private Date updateDatetime;

    private String isDel;

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue == null ? null : codeValue.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local == null ? null : local.trim();
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc == null ? null : dataSrc.trim();
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser == null ? null : insertUser.trim();
    }

    public String getInsertUserName() {
        return insertUserName;
    }

    public void setInsertUserName(String insertUserName) {
        this.insertUserName = insertUserName == null ? null : insertUserName.trim();
    }

    public String getCreatorOrgNo() {
        return creatorOrgNo;
    }

    public void setCreatorOrgNo(String creatorOrgNo) {
        this.creatorOrgNo = creatorOrgNo == null ? null : creatorOrgNo.trim();
    }

    public String getCreatorOrg() {
        return creatorOrg;
    }

    public void setCreatorOrg(String creatorOrg) {
        this.creatorOrg = creatorOrg == null ? null : creatorOrg.trim();
    }

    public String getInsertIpaddress() {
        return insertIpaddress;
    }

    public void setInsertIpaddress(String insertIpaddress) {
        this.insertIpaddress = insertIpaddress == null ? null : insertIpaddress.trim();
    }

    public Date getInsertDatetime() {
        return insertDatetime;
    }

    public void setInsertDatetime(Date insertDatetime) {
        this.insertDatetime = insertDatetime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public String getModiferOrgNo() {
        return modiferOrgNo;
    }

    public void setModiferOrgNo(String modiferOrgNo) {
        this.modiferOrgNo = modiferOrgNo == null ? null : modiferOrgNo.trim();
    }

    public String getModiferOrg() {
        return modiferOrg;
    }

    public void setModiferOrg(String modiferOrg) {
        this.modiferOrg = modiferOrg == null ? null : modiferOrg.trim();
    }

    public String getUpdateIpaddress() {
        return updateIpaddress;
    }

    public void setUpdateIpaddress(String updateIpaddress) {
        this.updateIpaddress = updateIpaddress == null ? null : updateIpaddress.trim();
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }
}