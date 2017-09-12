package com.zzxy.ssm.mapper;

import java.util.List;

import com.zzxy.ssm.po.AprbTActivityGroup;
import com.zzxy.ssm.po.AprbTActivityGroupQueryVO;

public interface AprbTActivityGroupMapper {

  void insertActivityGroup(AprbTActivityGroup activitygroup);

  void updateActivityGroup(AprbTActivityGroup activitygroup);
  
  AprbTActivityGroup getActivityGroupByPrimaryKey(String  groupNo);

  /**
   * 活动量群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月21日
   *
   * @param aprbTActivityGroupQueryVO
   * @return List<AprbTActivityGroup>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTActivityGroup> listCustActivityGroups(AprbTActivityGroupQueryVO aprbTActivityGroupQueryVO);
  
}