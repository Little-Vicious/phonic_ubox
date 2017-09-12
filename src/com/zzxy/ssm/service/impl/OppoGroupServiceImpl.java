package com.zzxy.ssm.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzxy.ssm.mapper.AprbTOppoGroupMapper;
import com.zzxy.ssm.po.AprbTOppoGroup;
import com.zzxy.ssm.po.AprbTOppoGroupQueryVO;
import com.zzxy.ssm.service.OppoGroupService;
/**
 * 商机群组Service实现类
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月22日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class OppoGroupServiceImpl implements OppoGroupService {

  @Autowired
  private AprbTOppoGroupMapper aprbTOppoGroupMapper;
  
  /**
   * 保存商机群组信息
   */
  @Override
  public void saveOppoGroup(AprbTOppoGroup oppoGroup) {
    if(StringUtils.isBlank(oppoGroup.getGroupNo())) {
      aprbTOppoGroupMapper.insertOppoGroup(oppoGroup);
    }else {
      aprbTOppoGroupMapper.updateOppoGroup(oppoGroup);
    }
    
    
  }

  /**
   * 获取商机群组列表
   */
  @Override
  public List<AprbTOppoGroup> listOppoGroups(AprbTOppoGroupQueryVO aprbTOppoGroupQueryVO) {
    return aprbTOppoGroupMapper.listOppoGroups(aprbTOppoGroupQueryVO);
  }

}
