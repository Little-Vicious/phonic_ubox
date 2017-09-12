package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AprbTEmployeeQueryVO {

  private AprbTEmployee aprbTEmployee;
  
  private AprbTEmployeeCustom aprbTEmployeeCustom;

  public AprbTEmployeeQueryVO() {
    super();
  }
  
  public AprbTEmployeeQueryVO(AprbTEmployeeCustom aprbTEmployeeCustom) {
    super();
    this.aprbTEmployeeCustom = aprbTEmployeeCustom;
  }

  public AprbTEmployeeQueryVO(AprbTEmployee aprbTEmployee) {
    super();
    this.aprbTEmployee = aprbTEmployee;
  }

  public AprbTEmployeeQueryVO(AprbTEmployee aprbTEmployee, AprbTEmployeeCustom aprbTEmployeeCustom) {
    super();
    this.aprbTEmployee = aprbTEmployee;
    this.aprbTEmployeeCustom = aprbTEmployeeCustom;
  }

  public AprbTEmployee getAprbTEmployee() {
    return aprbTEmployee;
  }

  public void setAprbTEmployee(AprbTEmployee aprbTEmployee) {
    this.aprbTEmployee = aprbTEmployee;
  }

  public AprbTEmployeeCustom getAprbTEmployeeCustom() {
    return aprbTEmployeeCustom;
  }

  public void setAprbTEmployeeCustom(AprbTEmployeeCustom aprbTEmployeeCustom) {
    this.aprbTEmployeeCustom = aprbTEmployeeCustom;
  }

  @Override
  public String toString() {
    return "AprbTEmployeeQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }

  
  
}
