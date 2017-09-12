package com.zzxy.ssm.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzxy.ssm.mapper.AprbTNoticeGroupMapper;
import com.zzxy.ssm.po.AprbTNoticeGroup;
import com.zzxy.ssm.po.AprbTNoticeGroupQueryVO;
import com.zzxy.ssm.service.NoticeGroupService;
/**
 * 提醒Service实现类
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月1日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class NoticeGroupServiceImpl implements NoticeGroupService {
  
  @Autowired
  private AprbTNoticeGroupMapper noticeGroupMapper;

  /**
   * 保存提醒群组信息
   */
  @Override
  public void saveNoticeGroup(AprbTNoticeGroup noticeGroup) {
    if(StringUtils.isBlank(noticeGroup.getGroupNo())) {
      noticeGroupMapper.insertNoticeGroup(noticeGroup);
    }else {
      noticeGroupMapper.updateNoticeGroup(noticeGroup);
    }
    
  }

  /**
   * 根据查询条件获取提醒群组列表
   */
  @Override
  public List<AprbTNoticeGroup> listCustNoticeGroups(AprbTNoticeGroupQueryVO noticeGroupQueryVO) {
    return noticeGroupMapper.listCustNoticeGroups(noticeGroupQueryVO);
  }

}
