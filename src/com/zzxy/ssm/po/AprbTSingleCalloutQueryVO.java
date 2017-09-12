package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AprbTSingleCalloutQueryVO {
  private AprbTSingleCallout aprbTSingleCallout;
  private AprbTSingleCalloutCustom aprbTSingleCalloutCustom;
  public AprbTSingleCalloutQueryVO() {
    super();
  }
  public AprbTSingleCalloutQueryVO(AprbTSingleCalloutCustom aprbTSingleCalloutCustom) {
    super();
    this.aprbTSingleCalloutCustom = aprbTSingleCalloutCustom;
  }
  public AprbTSingleCalloutQueryVO(AprbTSingleCallout aprbTSingleCallout) {
    super();
    this.aprbTSingleCallout = aprbTSingleCallout;
  }
  public AprbTSingleCalloutQueryVO(AprbTSingleCallout aprbTSingleCallout, AprbTSingleCalloutCustom aprbTSingleCalloutCustom) {
    super();
    this.aprbTSingleCallout = aprbTSingleCallout;
    this.aprbTSingleCalloutCustom = aprbTSingleCalloutCustom;
  }
  public AprbTSingleCallout getAprbTSingleCallout() {
    return aprbTSingleCallout;
  }
  public void setAprbTSingleCallout(AprbTSingleCallout aprbTSingleCallout) {
    this.aprbTSingleCallout = aprbTSingleCallout;
  }
  public AprbTSingleCalloutCustom getAprbTSingleCalloutCustom() {
    return aprbTSingleCalloutCustom;
  }
  public void setAprbTSingleCalloutCustom(AprbTSingleCalloutCustom aprbTSingleCalloutCustom) {
    this.aprbTSingleCalloutCustom = aprbTSingleCalloutCustom;
  }
  @Override
  public String toString() {
    return "AprbTSingleCalloutQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
