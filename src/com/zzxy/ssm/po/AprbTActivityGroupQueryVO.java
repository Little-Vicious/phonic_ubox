package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AprbTActivityGroupQueryVO {

  private AprbTActivityGroup aprbTActivityGroup;
  
  private AprbTActivityGroupCustom activityGroupCustom;

  public AprbTActivityGroupQueryVO() {
    super();
  }

  public AprbTActivityGroupQueryVO(AprbTActivityGroupCustom activityGroupCustom) {
    super();
    this.activityGroupCustom = activityGroupCustom;
  }

  public AprbTActivityGroupQueryVO(AprbTActivityGroup aprbTActivityGroup) {
    super();
    this.aprbTActivityGroup = aprbTActivityGroup;
  }

  public AprbTActivityGroupQueryVO(AprbTActivityGroup aprbTActivityGroup, AprbTActivityGroupCustom activityGroupCustom) {
    super();
    this.aprbTActivityGroup = aprbTActivityGroup;
    this.activityGroupCustom = activityGroupCustom;
  }

  public AprbTActivityGroup getAprbTActivityGroup() {
    return aprbTActivityGroup;
  }

  public void setAprbTActivityGroup(AprbTActivityGroup aprbTActivityGroup) {
    this.aprbTActivityGroup = aprbTActivityGroup;
  }

  public AprbTActivityGroupCustom getActivityGroupCustom() {
    return activityGroupCustom;
  }

  public void setActivityGroupCustom(AprbTActivityGroupCustom activityGroupCustom) {
    this.activityGroupCustom = activityGroupCustom;
  }

  @Override
  public String toString() {
    return "AprbTActivityGroupQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
