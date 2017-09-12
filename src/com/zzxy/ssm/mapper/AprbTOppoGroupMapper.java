package com.zzxy.ssm.mapper;

import java.util.List;

import com.zzxy.ssm.po.AprbTOppoGroup;
import com.zzxy.ssm.po.AprbTOppoGroupQueryVO;

/**
 * 商机群组Mapper接口
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月22日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public interface AprbTOppoGroupMapper {
  
  /**
   * 新增商机群组信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @param oppoGroup void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void insertOppoGroup(AprbTOppoGroup oppoGroup);

  /**
   * 更新群组信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @param oppoGroup void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void updateOppoGroup(AprbTOppoGroup oppoGroup);

  /**
   * 获取商机群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @param aprbTOppoGroupQueryVO
   * @return List<AprbTOppoGroup>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTOppoGroup> listOppoGroups(AprbTOppoGroupQueryVO aprbTOppoGroupQueryVO);

  /**
   * 根据主键获取商机活动信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @param groupNo
   * @return AprbTOppoGroup
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AprbTOppoGroup getOppoGroupByPrimaryKey(String groupNo);
  
}