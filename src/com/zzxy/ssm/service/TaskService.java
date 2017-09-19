package com.zzxy.ssm.service;

import java.util.List;

import com.zzxy.ssm.po.AcmgTTask;
import com.zzxy.ssm.po.AcmgTTaskCustom;
import com.zzxy.ssm.po.AcmgTTaskInstance;
import com.zzxy.ssm.po.AcmgTTaskInstanceCustom;
import com.zzxy.ssm.po.AcmgTTaskQueryVO;
import com.zzxy.ssm.po.AcmgTTaskTache;
import com.zzxy.ssm.po.AcmgTTaskTacheCustom;

/**
 * 批量任务调度Service
 * 
 * @工程： 批量调度平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月13日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public interface TaskService {
  
  /**
   * 保存批量任务调度信息
   * 
   * @作者： 王文博
   * @创建日期：2017年9月13日
   *
   * @param acmgTTask void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void saveTask(AcmgTTask acmgTTask) throws Exception;
  
  /**
   *获取任务调度列表
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
   * 根据ID获取任务信息
   * 
   * @作者： 王文博
   * @创建日期：2017年9月15日
   *
   * @param taskId
   * @return AcmgTTask
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AcmgTTask getTaskById(String taskId) throws Exception;

  /**
   * 根据任务标识获取任务信息，用于判断是否存在相同的任务标识
   * 
   * @作者： 王文博
   * @创建日期：2017年9月15日
   *
   * @param taskFlag
   * @return AcmgTTask
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AcmgTTask getTaskByFlag(String taskFlag) throws Exception;

  /**
   * 根据任务编号，查询环节列表
   * 
   * @作者： 王文博
   * @创建日期：2017年9月18日
   *
   * @param taskId
   * @return List<AcmgTTaskTacheCustom>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AcmgTTaskTacheCustom> listTacheCustomByTaskId(String taskId) throws Exception;
  
  /**
   * 根据任务编号，查询环节总数
   * 
   * @作者： 王文博
   * @创建日期：2017年9月19日
   *
   * @param taskId
   * @return
   * @throws Exception int
   *
   * @修改记录（修改时间、作者、原因）：
   */
  int totalTacheByTaskId(String taskId) throws Exception;
  
  /**
   * 根据任务编号和执行状态，查询环节数
   * 
   * @作者： 王文博
   * @创建日期：2017年9月19日
   *
   * @param taskId
   * @return
   * @throws Exception int
   *
   * @修改记录（修改时间、作者、原因）：
   */
  int countTacheByTaskIdAndStutas(String taskId,int tacheStutas) throws Exception;

  /**
   * 根据tacheId获取环节信息
   * 
   * @作者： 王文博
   * @创建日期：2017年9月18日
   *
   * @param tacheId
   * @return AcmgTTaskTacheCustom
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AcmgTTaskTacheCustom getTacheByTacheId(String tacheId);

  /**
   * 保存环节信息
   * 
   * @作者： 王文博
   * @throws Exception 
   * @创建日期：2017年9月18日
   *
   * @param taskTache void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void saveTache(AcmgTTaskTache taskTache) throws Exception;

  /**
   * 根据ID删除环节
   * 
   * @作者： 王文博
   * @创建日期：2017年9月18日
   *
   * @param tacheId void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void deleteTacheByTacheId(String tacheId) throws Exception;

  /**
   * 根据实例ID获取实例信息
   * 
   * @作者： 王文博
   * @创建日期：2017年9月18日
   *
   * @param instanceId
   * @return AcmgTTaskInstance
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AcmgTTaskInstanceCustom getInstanceByInstanceId(String instanceId);

  /**
   * 保存实例信息
   * 
   * @作者： 王文博
   * @创建日期：2017年9月19日
   *
   * @param instance void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void saveInstance(AcmgTTaskInstance instance);

  /**
   * 根据环节ID获取实例列表
   * 
   * @作者： 王文博
   * @创建日期：2017年9月19日
   *
   * @param tacheId
   * @return List<AcmgTTaskInstanceCustom>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AcmgTTaskInstanceCustom> listInstanceByTacheId(String tacheId);

}
