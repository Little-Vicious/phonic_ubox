package com.zzxy.ssm.mapper;

import com.zzxy.ssm.po.AprbTEmployee;
import com.zzxy.ssm.po.AprbTEmployeeQueryVO;

public interface AprbTEmployeeMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(AprbTEmployee record);

    AprbTEmployee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AprbTEmployee record);

    /**
     * 根据账号获取用户信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月11日
     *
     * @param account
     * @return AprbTEmployee
     *
     * @修改记录（修改时间、作者、原因）：
     */
    AprbTEmployee getEmployeeByVO(AprbTEmployeeQueryVO employeeQueryVO);

}