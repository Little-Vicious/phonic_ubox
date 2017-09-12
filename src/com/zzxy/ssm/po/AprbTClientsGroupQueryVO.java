package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AprbTClientsGroupQueryVO {
  private AprbTClientsGroup aprbTClientsGroup;
  
  private AprbTClientsGroupCustom aprbTClientsGroupCustom;

  public AprbTClientsGroupQueryVO() {
    super();
  }

  public AprbTClientsGroupQueryVO(AprbTClientsGroupCustom aprbTClientsGroupCustom) {
    super();
    this.aprbTClientsGroupCustom = aprbTClientsGroupCustom;
  }

  public AprbTClientsGroupQueryVO(AprbTClientsGroup aprbTClientsGroup) {
    super();
    this.aprbTClientsGroup = aprbTClientsGroup;
  }

  public AprbTClientsGroupQueryVO(AprbTClientsGroup aprbTClientsGroup, AprbTClientsGroupCustom aprbTClientsGroupCustom) {
    super();
    this.aprbTClientsGroup = aprbTClientsGroup;
    this.aprbTClientsGroupCustom = aprbTClientsGroupCustom;
  }

  public AprbTClientsGroup getAprbTClientsGroup() {
    return aprbTClientsGroup;
  }

  public void setAprbTClientsGroup(AprbTClientsGroup aprbTClientsGroup) {
    this.aprbTClientsGroup = aprbTClientsGroup;
  }

  public AprbTClientsGroupCustom getAprbTClientsGroupCustom() {
    return aprbTClientsGroupCustom;
  }

  public void setAprbTClientsGroupCustom(AprbTClientsGroupCustom aprbTClientsGroupCustom) {
    this.aprbTClientsGroupCustom = aprbTClientsGroupCustom;
  }

  @Override
  public String toString() {
    return "AprbTClientsGroupQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
