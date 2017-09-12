package com.zzxy.ssm.service;

import java.util.List;

import com.zzxy.ssm.po.AprbTActivityGroup;
import com.zzxy.ssm.po.AprbTActivityGroupQueryVO;
import com.zzxy.ssm.po.AprbTBatchCalloutCustom;
/**
 * 活动量群组Service
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月9日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public interface ActivityGroupService {

  /**
   * 活动量群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月9日
   *
   * @return ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTActivityGroup> listCustActivityGroups(AprbTActivityGroupQueryVO aprbTActivityGroupQueryVO);
  
  /**
   * 保存活动量群组客户信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月10日
   *
   * @param activitygroup void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void saveActivityGroup(AprbTActivityGroup activitygroup);

}
