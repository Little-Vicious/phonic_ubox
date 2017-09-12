package com.zzxy.ssm.service;

import java.util.List;

import com.zzxy.ssm.po.AprbTNoticeGroup;
import com.zzxy.ssm.po.AprbTNoticeGroupQueryVO;

/**
 * 提醒Service
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月1日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public interface NoticeGroupService {

  /**
   * 保存提醒群组信息
   * 
   * @作者： 王文博
   * @创建日期：2017年9月1日
   *
   * @param noticeGroup void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void saveNoticeGroup(AprbTNoticeGroup noticeGroup);

  /**
   * 根据查询条件获取提醒群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年9月4日
   *
   * @param noticeGroupQueryVO
   * @return List<AprbTNoticeGroup>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTNoticeGroup> listCustNoticeGroups(AprbTNoticeGroupQueryVO noticeGroupQueryVO);
  
}
