package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AprbTOppoGroupQueryVO {

  private AprbTOppoGroup aprbTOppoGroup;
  
  private AprbTOppoGroupCustom aprbTOppoGroupCustom;

  public AprbTOppoGroupQueryVO() {
    super();
  }

  public AprbTOppoGroupQueryVO(AprbTOppoGroupCustom aprbTOppoGroupCustom) {
    super();
    this.aprbTOppoGroupCustom = aprbTOppoGroupCustom;
  }

  public AprbTOppoGroupQueryVO(AprbTOppoGroup aprbTOppoGroup) {
    super();
    this.aprbTOppoGroup = aprbTOppoGroup;
  }

  public AprbTOppoGroupQueryVO(AprbTOppoGroup aprbTOppoGroup, AprbTOppoGroupCustom aprbTOppoGroupCustom) {
    super();
    this.aprbTOppoGroup = aprbTOppoGroup;
    this.aprbTOppoGroupCustom = aprbTOppoGroupCustom;
  }

  public AprbTOppoGroup getAprbTOppoGroup() {
    return aprbTOppoGroup;
  }

  public void setAprbTOppoGroup(AprbTOppoGroup aprbTOppoGroup) {
    this.aprbTOppoGroup = aprbTOppoGroup;
  }

  public AprbTOppoGroupCustom getAprbTOppoGroupCustom() {
    return aprbTOppoGroupCustom;
  }

  public void setAprbTOppoGroupCustom(AprbTOppoGroupCustom aprbTOppoGroupCustom) {
    this.aprbTOppoGroupCustom = aprbTOppoGroupCustom;
  }

  @Override
  public String toString() {
    return "AprbTOppoGroupQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
