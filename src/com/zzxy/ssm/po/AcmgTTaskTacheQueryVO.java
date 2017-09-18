package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AcmgTTaskTacheQueryVO {

  private AcmgTTaskTache taskTache;
  
  private AcmgTTaskTacheCustom taskTacheCustom;

  public AcmgTTaskTacheQueryVO() {
    super();
  }

  public AcmgTTaskTacheQueryVO(AcmgTTaskTache taskTache, AcmgTTaskTacheCustom taskTacheCustom) {
    super();
    this.taskTache = taskTache;
    this.taskTacheCustom = taskTacheCustom;
  }

  public AcmgTTaskTache getTaskTache() {
    return taskTache;
  }

  public void setTaskTache(AcmgTTaskTache taskTache) {
    this.taskTache = taskTache;
  }

  public AcmgTTaskTacheCustom getTaskTacheCustom() {
    return taskTacheCustom;
  }

  public void setTaskTacheCustom(AcmgTTaskTacheCustom taskTacheCustom) {
    this.taskTacheCustom = taskTacheCustom;
  }

  @Override
  public String toString() {
    return "AcmgTTaskTacheQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
