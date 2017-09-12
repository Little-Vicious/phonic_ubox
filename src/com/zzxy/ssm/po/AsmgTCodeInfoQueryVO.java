package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AsmgTCodeInfoQueryVO {

  private AsmgTCodeInfo asmgTCodeInfo;
  
  private AsmgTCodeInfoCustom asmgTCodeInfoCustom;
  
  public AsmgTCodeInfo getAsmgTCodeInfo() {
    return asmgTCodeInfo;
  }

  public void setAsmgTCodeInfo(AsmgTCodeInfo asmgTCodeInfo) {
    this.asmgTCodeInfo = asmgTCodeInfo;
  }

  public AsmgTCodeInfoCustom getAsmgTCodeInfoCustom() {
    return asmgTCodeInfoCustom;
  }

  public void setAsmgTCodeInfoCustom(AsmgTCodeInfoCustom asmgTCodeInfoCustom) {
    this.asmgTCodeInfoCustom = asmgTCodeInfoCustom;
  }

  @Override
  public String toString() {
    return "AsmgTCodeInfoQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
