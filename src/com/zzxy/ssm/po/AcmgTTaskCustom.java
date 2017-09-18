package com.zzxy.ssm.po;

import com.zzxy.ssm.common.utils.DateUtils;

public class AcmgTTaskCustom extends AcmgTTask {
  
  private int totalTasks;
  
  private int completedTasks;
  
  private long duration;

  public AcmgTTaskCustom() {
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
    if(this.getTaskEndTime() != null && this.getTaskStartTime() != null) {
      this.duration = DateUtils.getTimeBetween(this.getTaskEndTime(), this.getTaskStartTime());
    }
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }
  
  
}
