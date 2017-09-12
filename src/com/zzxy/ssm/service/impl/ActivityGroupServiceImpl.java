package com.zzxy.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzxy.ssm.mapper.AprbTActivityGroupMapper;
import com.zzxy.ssm.mapper.AprbTBatchCalloutMapper;
import com.zzxy.ssm.po.AprbTActivityGroup;
import com.zzxy.ssm.po.AprbTActivityGroupQueryVO;
import com.zzxy.ssm.po.AprbTBatchCalloutCustom;
import com.zzxy.ssm.po.AprbTSingleCallout;
import com.zzxy.ssm.po.AprbTSingleCalloutCustom;
import com.zzxy.ssm.po.AprbTSingleCalloutQueryVO;
import com.zzxy.ssm.service.ActivityGroupService;

public class ActivityGroupServiceImpl implements ActivityGroupService {

  @Autowired
  private AprbTActivityGroupMapper aprbTActivityGroupMapper;
  
  @Autowired
  private AprbTBatchCalloutMapper aprbTBatchCalloutMapper;
  
  /**
   * 活动量群组列表
   */
  @Override
  public List<AprbTActivityGroup> listCustActivityGroups(AprbTActivityGroupQueryVO aprbTActivityGroupQueryVO) {
    return aprbTActivityGroupMapper.listCustActivityGroups(aprbTActivityGroupQueryVO);
  }
  
  /**
   * 保存活动量群组客户信息
   */
  @Override
  public void saveActivityGroup(AprbTActivityGroup activitygroup) {
    if(StringUtils.isBlank(activitygroup.getGroupNo())) {
      aprbTActivityGroupMapper.insertActivityGroup(activitygroup);
    }else {
      aprbTActivityGroupMapper.updateActivityGroup(activitygroup);
    }
  }

}
