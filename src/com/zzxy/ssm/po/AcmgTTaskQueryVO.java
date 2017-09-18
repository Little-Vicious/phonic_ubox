package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AcmgTTaskQueryVO {

  private AcmgTTask acmgTTask;
  
  private AcmgTTaskCustom acmgTTaskCustom;

  public AcmgTTaskQueryVO(AcmgTTask acmgTTask, AcmgTTaskCustom acmgTTaskCustom) {
    super();
    this.acmgTTask = acmgTTask;
    this.acmgTTaskCustom = acmgTTaskCustom;
  }

  public AcmgTTask getAcmgTTask() {
    return acmgTTask;
  }

  public void setAcmgTTask(AcmgTTask acmgTTask) {
    this.acmgTTask = acmgTTask;
  }

  public AcmgTTaskCustom getAcmgTTaskCustom() {
    return acmgTTaskCustom;
  }

  public void setAcmgTTaskCustom(AcmgTTaskCustom acmgTTaskCustom) {
    this.acmgTTaskCustom = acmgTTaskCustom;
  }

  @Override
  public String toString() {
    return "AcmgTTaskQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
}
