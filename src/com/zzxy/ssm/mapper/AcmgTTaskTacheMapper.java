package com.zzxy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzxy.ssm.po.AcmgTTaskTache;
import com.zzxy.ssm.po.AcmgTTaskTacheCustom;
import com.zzxy.ssm.po.AcmgTTaskTacheQueryVO;

public interface AcmgTTaskTacheMapper {

  /**
   * 根据ID删除环节信息
   * 
   * @作者： 王文博
   * @创建日期：2017年9月18日
   *
   * @param tacheId
   * @return int
   *
   * @修改记录（修改时间、作者、原因）：
   */
    int deleteTache(String tacheId);

    /**
     * 新增环节信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月18日
     *
     * @param taskTache
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int insertTaskTache(AcmgTTaskTache taskTache);

    AcmgTTaskTache selectByPrimaryKey(String tacheId);

    /**
     * 更新环节信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月18日
     *
     * @param taskTache
     * @return int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int updateTaskTache(AcmgTTaskTache taskTache);

    /**
     * 根据查询VO获取环节列表
     * 
     * @作者： 王文博
     * @创建日期：2017年9月18日
     *
     * @param queryVO
     * @return List<AcmgTTaskTacheCustom>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    List<AcmgTTaskTacheCustom> listTacheCustomByVO(AcmgTTaskTacheQueryVO queryVO) throws Exception;

    /**
     * 根据查询VO获取环节信息
     * 
     * @作者： 王文博
     * @创建日期：2017年9月18日
     *
     * @param taskTacheCustom
     * @return AcmgTTaskTacheCustom
     *
     * @修改记录（修改时间、作者、原因）：
     */
    AcmgTTaskTacheCustom getTacheByVO(AcmgTTaskTacheQueryVO queryVO);
    
    /**
     * 根据任务ID获取环节的当前顺序号最大值
     * 
     * @作者： 王文博
     * @创建日期：2017年9月18日
     *
     * @param taskId
     * @throws Exception int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    int getMaxIndexByTaskId(@Param("taskId")String taskId) throws Exception;

}