package com.zzxy.ssm.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzxy.ssm.mapper.AcmgTTaskMapper;
import com.zzxy.ssm.mapper.AcmgTTaskTacheMapper;
import com.zzxy.ssm.po.AcmgTTask;
import com.zzxy.ssm.po.AcmgTTaskCustom;
import com.zzxy.ssm.po.AcmgTTaskQueryVO;
import com.zzxy.ssm.po.AcmgTTaskTache;
import com.zzxy.ssm.po.AcmgTTaskTacheCustom;
import com.zzxy.ssm.po.AcmgTTaskTacheQueryVO;
import com.zzxy.ssm.service.TaskService;
/**
 * 批量任务调度Service实现类
 * 
 * @工程： 批量调度平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月13日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class TaskServiceImpl implements TaskService {

  @Autowired
  private AcmgTTaskMapper taskMapper;
  
  @Autowired
  private AcmgTTaskTacheMapper tacheMapper;
  
  /**
   * 保存批量任务调度信息
   */
  @Override
  public void saveTask(AcmgTTask acmgTTask) throws Exception{
    if(StringUtils.isBlank(acmgTTask.getTaskId())) {
      taskMapper.insertTask(acmgTTask);
    }else {
      taskMapper.updateTask(acmgTTask);
    }
    
  }
  
  /**
   * 获取任务调度列表
   */
  @Override
  public List<AcmgTTaskCustom> listTaskCustomByVO(AcmgTTaskQueryVO taskQueryVO) throws Exception {
    return taskMapper.listTaskCustomByVO(taskQueryVO);
  }

  /**
   * 根据ID获取任务信息
   */
  @Override
  public AcmgTTask getTaskById(String taskId) throws Exception{
    return taskMapper.getTaskByPrimaryKey(taskId);
  }

  /**
   * 根据任务标识获取任务信息，用于判断是否存在相同的任务标识
   */
  @Override
  public AcmgTTask getTaskByFlag(String taskFlag) throws Exception{
    AcmgTTaskCustom acmgTTaskCustom = new AcmgTTaskCustom();
    acmgTTaskCustom.setTaskFlag(taskFlag);
    AcmgTTaskQueryVO taskQueryVO = new AcmgTTaskQueryVO(null, acmgTTaskCustom );
    return taskMapper.getTaskByVO(taskQueryVO );
  }

  /**
   * 根据任务编号，查询环节列表
   */
  @Override
  public List<AcmgTTaskTacheCustom> listTacheCustomByTaskId(String taskId) throws Exception {
    AcmgTTaskTacheCustom taskTacheCustom = new AcmgTTaskTacheCustom();
    taskTacheCustom.setTaskId(taskId);
    AcmgTTaskTacheQueryVO queryVO = new AcmgTTaskTacheQueryVO(null, taskTacheCustom );
    return tacheMapper.listTacheCustomByVO(queryVO);
  }

  /**
   * 根据tacheId获取环节信息
   */
  @Override
  public AcmgTTaskTacheCustom getTacheByTacheId(String tacheId) {
    AcmgTTaskTacheCustom taskTacheCustom = new AcmgTTaskTacheCustom();
    taskTacheCustom.setTacheId(tacheId);
    AcmgTTaskTacheQueryVO queryVO = new AcmgTTaskTacheQueryVO(null, taskTacheCustom );
    return tacheMapper.getTacheByVO(taskTacheCustom);
  }

  /**
   * 保存环节信息
   * @throws Exception 
   */
  @Override
  public void saveTache(AcmgTTaskTache taskTache) throws Exception {
    if(StringUtils.isBlank(taskTache.getTacheId())) {
      int maxIndex = tacheMapper.getMaxIndexByTaskId(taskTache.getTaskId());
      taskTache.setTacheIndex(maxIndex+1);
      tacheMapper.insertTaskTache(taskTache);
    }else {
      tacheMapper.updateTaskTache(taskTache);
    }
  }

}
