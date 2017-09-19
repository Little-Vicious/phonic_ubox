package com.zzxy.ssm.mapper;

import java.util.List;

import com.zzxy.ssm.po.AcmgTTaskInstance;
import com.zzxy.ssm.po.AcmgTTaskInstanceCustom;
import com.zzxy.ssm.po.AcmgTTaskInstanceQueryVO;

public interface AcmgTTaskInstanceMapper {
    int deleteByPrimaryKey(String instanceId);

    int insert(AcmgTTaskInstance record);

    /**
     * 新增环节实例信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月19日
     *
     * @param record
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int insertInstance(AcmgTTaskInstance record);

    AcmgTTaskInstance selectByPrimaryKey(String instanceId);

    /**
     * 更新环节实例信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月19日
     *
     * @param record
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int updateInstance(AcmgTTaskInstance record);


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

    /**
     * 根据查询VO获取实例列表
     * 
     * @作者： 王文博
     * @创建日期：2017年9月19日
     *
     * @param queryVO
     * @return List<AcmgTTaskInstanceCustom>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    List<AcmgTTaskInstanceCustom> listInstanceByVO(AcmgTTaskInstanceQueryVO queryVO);
}