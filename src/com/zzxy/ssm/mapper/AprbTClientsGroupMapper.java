package com.zzxy.ssm.mapper;

import com.zzxy.ssm.po.AprbTClientsGroup;

public interface AprbTClientsGroupMapper {

    int deleteByPrimaryKey(String groupNo);

    /**
     * 新增客户群组信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月4日
     *
     * @param record
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int insertClientsGroup(AprbTClientsGroup clientsGroup);

    /**
     * 根据主键获取客户群组信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月4日
     *
     * @param groupNo
     * @return AprbTClientsGroup
     *
     * @修改记录（修改时间、作者、原因）：
     */
    AprbTClientsGroup getClientsGroupByPrimaryKey(String groupNo);

    /**
     * 更新客户群组信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月4日
     *
     * @param record
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int updateClientsGroup(AprbTClientsGroup clientsGroup);

}