package com.zzxy.ssm.po;

import com.zzxy.ssm.common.utils.DateUtils;

public class AcmgTTaskTacheCustom extends AcmgTTaskTache {

  private int totalTasks;
  
  private int completedTasks;
  
  private long duration;

  public AcmgTTaskTacheCustom() {
    super();
  }

  public int getTotalTasks() {
    return totalTasks;
  }

  public void setTotalTasks(int totalTasks) {
    this.totalTasks = totalTasks;
  }

  public int getCompletedTasks() {
    return completedTasks;
  }

  public void setCompletedTasks(int completedTasks) {
    this.completedTasks = completedTasks;
  }

  public long getDuration() {
    if(this.getTacheEndTime() != null && this.getTacheStartTime() != null) {
      this.duration = DateUtils.getTimeBetween(this.getTacheEndTime(), this.getTacheStartTime());
    }
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }
  
  
  
}
