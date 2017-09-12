package com.zzxy.ssm.po;

import net.sf.json.JSONObject;

public class AprbTBatchCalloutCustom extends AprbTBatchCallout {

  private Integer countCallout;//总个数
  private Long countDuration;//总时长
  private Integer countFinish;//已完成数
  private Integer countUnfinish;//未完成数
  private Integer countEffective;//有效数
  
  public AprbTBatchCalloutCustom() {
    super();
  }
  
  
  public AprbTBatchCalloutCustom(Integer countCallout, Long countDuration, Integer countFinish, Integer countUnfinish, Integer countEffective) {
    super();
    this.countCallout = countCallout;
    this.countDuration = countDuration;
    this.countFinish = countFinish;
    this.countUnfinish = countUnfinish;
    this.countEffective = countEffective;
  }


  public Integer getCountCallout() {
    return countCallout;
  }
  public void setCountCallout(Integer countCallout) {
    this.countCallout = countCallout;
  }
  public Long getCountDuration() {
    return countDuration;
  }
  public void setCountDuration(Long countDuration) {
    this.countDuration = countDuration;
  }
  public Integer getCountFinish() {
    return countFinish;
  }
  public void setCountFinish(Integer countFinish) {
    this.countFinish = countFinish;
  }
  public Integer getCountUnfinish() {
    return countUnfinish;
  }
  public void setCountUnfinish(Integer countUnfinish) {
    this.countUnfinish = countUnfinish;
  }
  public Integer getCountEffective() {
    return countEffective;
  }
  public void setCountEffective(Integer countEffective) {
    this.countEffective = countEffective;
  }
  @Override
  public String toString() {
    return "AprbTBatchCalloutCustom ["+JSONObject.fromObject(this).toString()+"]";
  }
  
  
}
