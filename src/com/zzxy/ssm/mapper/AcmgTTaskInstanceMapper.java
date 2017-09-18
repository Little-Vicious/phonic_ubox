package com.zzxy.ssm.mapper;

import com.zzxy.ssm.po.AcmgTTaskInstance;
import com.zzxy.ssm.po.AcmgTTaskInstanceCustom;
import com.zzxy.ssm.po.AcmgTTaskInstanceQueryVO;

public interface AcmgTTaskInstanceMapper {
    int deleteByPrimaryKey(String instanceId);

    int insert(AcmgTTaskInstance record);

    int insertSelective(AcmgTTaskInstance record);

    AcmgTTaskInstance selectByPrimaryKey(String instanceId);

    int updateByPrimaryKeySelective(AcmgTTaskInstance record);

    int updateByPrimaryKey(AcmgTTaskInstance record);

    /**
     * 根据查询VO获取实例信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月18日
     *
     * @param queryVO
     * @return AcmgTTaskInstance
     *
     * @修改记录（修改时间、作者、原因）：
     */
    AcmgTTaskInstanceCustom getInstanceByVO(AcmgTTaskInstanceQueryVO queryVO);
}