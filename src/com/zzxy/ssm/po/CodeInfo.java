package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class CodeInfo {
  private String codeValue;

  private String typeCode;

  private String codeName;
  

  public CodeInfo() {
    super();
  }

  public CodeInfo(String codeValue, String typeCode, String codeName) {
    super();
    this.codeValue = codeValue;
    this.typeCode = typeCode;
    this.codeName = codeName;
  }

  public String getCodeValue() {
    return codeValue;
  }

  public void setCodeValue(String codeValue) {
    this.codeValue = codeValue;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public String getCodeName() {
    return codeName;
  }

  public void setCodeName(String codeName) {
    this.codeName = codeName;
  }

  @Override
  public String toString() {
    return "CodeInfo ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
} 
