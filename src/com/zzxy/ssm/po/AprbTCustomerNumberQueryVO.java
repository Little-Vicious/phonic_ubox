package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AprbTCustomerNumberQueryVO {

  private AprbTCustomerNumber aprbTCustomerNumber;
  
  private AprbTCustomerNumberCustom aprbTCustomerNumberCustom;

  public AprbTCustomerNumberQueryVO() {
    super();
  }

  public AprbTCustomerNumberQueryVO(AprbTCustomerNumberCustom aprbTCustomerNumberCustom) {
    super();
    this.aprbTCustomerNumberCustom = aprbTCustomerNumberCustom;
  }

  public AprbTCustomerNumberQueryVO(AprbTCustomerNumber aprbTCustomerNumber) {
    super();
    this.aprbTCustomerNumber = aprbTCustomerNumber;
  }

  public AprbTCustomerNumberQueryVO(AprbTCustomerNumber aprbTCustomerNumber, AprbTCustomerNumberCustom aprbTCustomerNumberCustom) {
    super();
    this.aprbTCustomerNumber = aprbTCustomerNumber;
    this.aprbTCustomerNumberCustom = aprbTCustomerNumberCustom;
  }

  public AprbTCustomerNumber getAprbTCustomerNumber() {
    return aprbTCustomerNumber;
  }

  public void setAprbTCustomerNumber(AprbTCustomerNumber aprbTCustomerNumber) {
    this.aprbTCustomerNumber = aprbTCustomerNumber;
  }

  public AprbTCustomerNumberCustom getAprbTCustomerNumberCustom() {
    return aprbTCustomerNumberCustom;
  }

  public void setAprbTCustomerNumberCustom(AprbTCustomerNumberCustom aprbTCustomerNumberCustom) {
    this.aprbTCustomerNumberCustom = aprbTCustomerNumberCustom;
  }

  @Override
  public String toString() {
    return "AprbTCustomerNumberQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
