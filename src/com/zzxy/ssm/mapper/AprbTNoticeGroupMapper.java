package com.zzxy.ssm.mapper;

import java.util.List;

import com.zzxy.ssm.po.AprbTNoticeGroup;
import com.zzxy.ssm.po.AprbTNoticeGroupQueryVO;

public interface AprbTNoticeGroupMapper {

    int deleteByPrimaryKey(String groupNo);

    /**
     * 新增提醒群组
     * 
     * @作者： 王文博
     * @创建日期：2017年9月4日
     *
     * @param record
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int insertNoticeGroup(AprbTNoticeGroup noticeGroup);

    /**
     * 根据主键获取消息提醒群组信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月4日
     *
     * @param groupNo
     * @return AprbTNoticeGroup
     *
     * @修改记录（修改时间、作者、原因）：
     */
    AprbTNoticeGroup getNoticeGroupByPrimaryKey(String groupNo);

    /**
     * 更新提醒群组
     * 
     * @作者： 王文博
     * @创建日期：2017年9月4日
     *
     * @param record
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int updateNoticeGroup(AprbTNoticeGroup noticeGroup);

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