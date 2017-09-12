package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AprbTNoticeGroupQueryVO {
  
  private AprbTNoticeGroup aprbTNoticeGroup;
  
  private AprbTNoticeGroupCustom aprbTNoticeGroupCustom;

  public AprbTNoticeGroupQueryVO() {
    super();
  }

  public AprbTNoticeGroupQueryVO(AprbTNoticeGroup aprbTNoticeGroup, AprbTNoticeGroupCustom aprbTNoticeGroupCustom) {
    super();
    this.aprbTNoticeGroup = aprbTNoticeGroup;
    this.aprbTNoticeGroupCustom = aprbTNoticeGroupCustom;
  }

  public AprbTNoticeGroupQueryVO(AprbTNoticeGroupCustom aprbTNoticeGroupCustom) {
    super();
    this.aprbTNoticeGroupCustom = aprbTNoticeGroupCustom;
  }

  public AprbTNoticeGroupQueryVO(AprbTNoticeGroup aprbTNoticeGroup) {
    super();
    this.aprbTNoticeGroup = aprbTNoticeGroup;
  }

  public AprbTNoticeGroup getAprbTNoticeGroup() {
    return aprbTNoticeGroup;
  }

  public void setAprbTNoticeGroup(AprbTNoticeGroup aprbTNoticeGroup) {
    this.aprbTNoticeGroup = aprbTNoticeGroup;
  }

  public AprbTNoticeGroupCustom getAprbTNoticeGroupCustom() {
    return aprbTNoticeGroupCustom;
  }

  public void setAprbTNoticeGroupCustom(AprbTNoticeGroupCustom aprbTNoticeGroupCustom) {
    this.aprbTNoticeGroupCustom = aprbTNoticeGroupCustom;
  }

  @Override
  public String toString() {
    return "AprbTNoticeGroupQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
