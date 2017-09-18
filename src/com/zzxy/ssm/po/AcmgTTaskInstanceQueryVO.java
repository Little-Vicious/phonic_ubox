package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AcmgTTaskInstanceQueryVO {

  private AcmgTTaskInstance instance;
  
  private AcmgTTaskInstanceCustom instanceCustom;

  public AcmgTTaskInstanceQueryVO() {
    super();
  }

  public AcmgTTaskInstanceQueryVO(AcmgTTaskInstance instance, AcmgTTaskInstanceCustom instanceCustom) {
    super();
    this.instance = instance;
    this.instanceCustom = instanceCustom;
  }

  public AcmgTTaskInstance getInstance() {
    return instance;
  }

  public void setInstance(AcmgTTaskInstance instance) {
    this.instance = instance;
  }

  public AcmgTTaskInstanceCustom getInstanceCustom() {
    return instanceCustom;
  }

  public void setInstanceCustom(AcmgTTaskInstanceCustom instanceCustom) {
    this.instanceCustom = instanceCustom;
  }

  @Override
  public String toString() {
    return "AcmgTTaskInstanceQueryVO ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
