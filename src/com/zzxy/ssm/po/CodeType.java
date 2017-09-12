package com.zzxy.ssm.po;

import java.util.List;

import net.sf.json.JSONObject;

public class CodeType {
  private String typeCode;

  private String typeName;
  
  private List<CodeInfo> listCodeInfo;
  
  

  public CodeType() {
    super();
  }

  public CodeType(String typeCode, String typeName, List<CodeInfo> listCodeInfo) {
    super();
    this.typeCode = typeCode;
    this.typeName = typeName;
    this.listCodeInfo = listCodeInfo;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public List<CodeInfo> getListCodeInfo() {
    return listCodeInfo;
  }

  public void setListCodeInfo(List<CodeInfo> listCodeInfo) {
    this.listCodeInfo = listCodeInfo;
  }

  @Override
  public String toString() {
    return "CodeType ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
