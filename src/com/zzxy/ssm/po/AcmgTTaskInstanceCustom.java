package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AcmgTTaskInstanceCustom extends AcmgTTaskInstance {

  private long duration;

  public AcmgTTaskInstanceCustom() {
    super();
  }

  public AcmgTTaskInstanceCustom(long duration) {
    super();
    this.duration = duration;
  }

  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }

  @Override
  public String toString() {
    return "AcmgTTaskInstanceCustom ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
