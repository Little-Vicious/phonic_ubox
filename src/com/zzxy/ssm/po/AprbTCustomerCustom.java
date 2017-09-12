package com.zzxy.ssm.po;

import java.util.List;

import net.sf.json.JSONObject;

public class AprbTCustomerCustom extends AprbTCustomer {
  
  private String mainNumber;
  
  private List<String> listNumbers;

  public AprbTCustomerCustom() {
    super();
  }

  public AprbTCustomerCustom(List<String> listNumbers) {
    super();
    this.listNumbers = listNumbers;
  }

  public AprbTCustomerCustom(String mainNumber) {
    super();
    this.mainNumber = mainNumber;
  }

  public AprbTCustomerCustom(String mainNumber, List<String> listNumbers) {
    super();
    this.mainNumber = mainNumber;
    this.listNumbers = listNumbers;
  }

  public String getMainNumber() {
    return mainNumber;
  }

  public void setMainNumber(String mainNumber) {
    this.mainNumber = mainNumber;
  }

  public List<String> getListNumbers() {
    return listNumbers;
  }

  public void setListNumbers(List<String> listNumbers) {
    this.listNumbers = listNumbers;
  }

  @Override
  public String toString() {
    return "AprbTCustomerCustom ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
