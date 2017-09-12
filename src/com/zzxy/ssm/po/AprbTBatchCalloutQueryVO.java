package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AprbTBatchCalloutQueryVO {
  
  private AprbTBatchCallout aprbTBatchCallout;
  
  private AprbTBatchCalloutCustom aprbTBatchCalloutCustom;

  public AprbTBatchCalloutQueryVO() {
    super();
  }

  public AprbTBatchCalloutQueryVO(AprbTBatchCalloutCustom aprbTBatchCalloutCustom) {
    super();
    this.aprbTBatchCalloutCustom = aprbTBatchCalloutCustom;
  }

  public AprbTBatchCalloutQueryVO(AprbTBatchCallout aprbTBatchCallout) {
    super();
    this.aprbTBatchCallout = aprbTBatchCallout;
  }

  public AprbTBatchCalloutQueryVO(AprbTBatchCallout aprbTBatchCallout, AprbTBatchCalloutCustom aprbTBatchCalloutCustom) {
    super();
    this.aprbTBatchCallout = aprbTBatchCallout;
    this.aprbTBatchCalloutCustom = aprbTBatchCalloutCustom;
  }

  public AprbTBatchCallout getAprbTBatchCallout() {
    return aprbTBatchCallout;
  }

  public void setAprbTBatchCallout(AprbTBatchCallout aprbTBatchCallout) {
    this.aprbTBatchCallout = aprbTBatchCallout;
  }

  public AprbTBatchCalloutCustom getAprbTBatchCalloutCustom() {
    return aprbTBatchCalloutCustom;
  }

  public void setAprbTBatchCalloutCustom(AprbTBatchCalloutCustom aprbTBatchCalloutCustom) {
    this.aprbTBatchCalloutCustom = aprbTBatchCalloutCustom;
  }

  @Override
  public String toString() {
    return "AprbTBatchCalloutQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
