package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AsmgTCodeTypeQueryVO {

  private AsmgTCodeType asmgTCodeType;
  private AsmgTCodeTypeCustom asmgTCodeTypeCustom;
  
  
  public AsmgTCodeType getAsmgTCodeType() {
    return asmgTCodeType;
  }
  public void setAsmgTCodeType(AsmgTCodeType asmgTCodeType) {
    this.asmgTCodeType = asmgTCodeType;
  }
  public AsmgTCodeTypeCustom getAsmgTCodeTypeCustom() {
    return asmgTCodeTypeCustom;
  }
  public void setAsmgTCodeTypeCustom(AsmgTCodeTypeCustom asmgTCodeTypeCustom) {
    this.asmgTCodeTypeCustom = asmgTCodeTypeCustom;
  }
  
  @Override
  public String toString() {
    return "AsmgTCodeTypeQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
}
