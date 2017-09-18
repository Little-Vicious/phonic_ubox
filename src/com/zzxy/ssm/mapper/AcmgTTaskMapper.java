package com.zzxy.ssm.mapper;

import java.util.List;

import com.zzxy.ssm.po.AcmgTTask;
import com.zzxy.ssm.po.AcmgTTaskCustom;
import com.zzxy.ssm.po.AcmgTTaskQueryVO;
import com.zzxy.ssm.po.AcmgTTaskTacheCustom;
import com.zzxy.ssm.po.AcmgTTaskTacheQueryVO;

public interface AcmgTTaskMapper {

    int deleteByPrimaryKey(String taskId) throws Exception;

    /**
     * 新增任务调度信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月13日
     *
     * @param record
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int insertTask(AcmgTTask task) throws Exception;

    /**
     * 更新任务调度信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月13日
     *
     * @param record
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int updateTask(AcmgTTask task) throws Exception;
    
    AcmgTTask selectByPrimaryKey(String taskId) throws Exception;

    /**
     * 获取任务调度列表
     * 
     * @作者： 王文博
     * @创建日期：2017年9月14日
     *
     * @param taskQueryVO
     * @return List<AcmgTTaskCustom>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    List<AcmgTTaskCustom> listTaskCustomByVO(AcmgTTaskQueryVO taskQueryVO) throws Exception;

    /**
     * 根据查询VO获取任务信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月15日
     *
     * @param taskQueryVO
     * @return AcmgTTask
     *
     * @修改记录（修改时间、作者、原因）：
     */
    AcmgTTask getTaskByVO(AcmgTTaskQueryVO taskQueryVO) throws Exception;
    
    /**
     * 根据主键获取任务信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月15日
     *
     * @param taskId
     * @return AcmgTTask
     *
     * @修改记录（修改时间、作者、原因）：
     */
    AcmgTTask getTaskByPrimaryKey(String taskId) throws Exception;

}