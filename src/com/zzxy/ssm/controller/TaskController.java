package com.zzxy.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzxy.ssm.po.AcmgTTask;
import com.zzxy.ssm.po.AcmgTTaskCustom;
import com.zzxy.ssm.po.AcmgTTaskQueryVO;
import com.zzxy.ssm.po.AcmgTTaskTache;
import com.zzxy.ssm.po.AcmgTTaskTacheCustom;
import com.zzxy.ssm.service.TaskService;
/**
 * 批量任务调度
 * 
 * @工程： 批量调度平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月13日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
@RequestMapping("/task")
public class TaskController {
  
  @Autowired
  private TaskService taskService;

  /**
   * 批量任务列表页面
   * 
   * @作者： 王文博
   * @创建日期：2017年9月13日
   *
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("listTask")
  public ModelAndView listTask(AcmgTTaskCustom taskCustom) throws Exception {
    AcmgTTaskQueryVO taskQueryVO = new AcmgTTaskQueryVO(null, taskCustom);
    List<AcmgTTaskCustom> tasks = taskService.listTaskCustomByVO(taskQueryVO);
    ModelAndView modelAndView = new ModelAndView("/task/ListTask");
    modelAndView.addObject("taskCustom", taskCustom);
    modelAndView.addObject("tasks", tasks);
    return modelAndView;
  }
  
  /**
   * 展示编辑批量任务页面
   * 
   * @作者： 王文博
   * @创建日期：2017年9月13日
   *
   * @param taskId
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("showEditTask")
  public ModelAndView showEditTask(@RequestParam(value = "taskId", required = false) String taskId)throws Exception{
    ModelAndView modelAndView = new ModelAndView("/task/EditTask");
    AcmgTTask task = new AcmgTTask();
    if(!StringUtils.isBlank(taskId)) {
      task = taskService.getTaskById(taskId);
    }
    modelAndView.addObject("task", task);
    return modelAndView;
  }
  
  @RequestMapping("submitEditTask")
  @ResponseBody
  public Map<String, Object> submitEditTask(HttpServletRequest request)throws Exception{
    Map<String, Object> map = new HashMap<String, Object>();
    String msg = "";
    boolean flag = false;
    
    String taskId = request.getParameter("taskId");
    String taskType = request.getParameter("taskType");
    String taskFlag = request.getParameter("taskFlag");
    String taskName = request.getParameter("taskName");
    String taskDescription = request.getParameter("taskDescription");
    
    AcmgTTask acmgTTask = new AcmgTTask();
    acmgTTask.setTaskId(taskId);
    acmgTTask.setTaskType(taskType);
    acmgTTask.setTaskFlag(taskFlag);
    acmgTTask.setTaskName(taskName);
    acmgTTask.setTaskDescription(taskDescription);
    
    try {
      taskService.saveTask(acmgTTask);
      flag = true;
      msg = "保存成功！";
    }catch (Exception e) {
      msg = e.getMessage();
    }
    
    
    map.put("msg", msg);
    map.put("flag", flag);
    return map;
  }
  
  /**
   * 校验标识是否已经存在
   * 
   * @作者： 王文博
   * @创建日期：2017年9月15日
   *
   * @return
   * @throws Exception Map<String,Object>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("checkTaskFlag")
  @ResponseBody
  public Map<String, Object> checkTaskFlag(HttpServletRequest request) throws Exception{
    Map<String, Object> map = new HashMap<String, Object>();
    String msg = "";
    boolean flag = false;
    
    String taskFlag = request.getParameter("taskFlag");
    
    AcmgTTask task =  taskService.getTaskByFlag(taskFlag);
    
    if(task != null && StringUtils.isNotBlank(task.getTaskId())) {
      flag = true;
      msg = "已存在相同的任务标识！";
    }
    
    map.put("msg", msg);
    map.put("flag", flag);
    return map;
  }
  
  /**
   * 任务环节列表
   * 
   * @作者： 王文博
   * @创建日期：2017年9月18日
   *
   * @param taskId
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("listTache")
  public ModelAndView listTache(@RequestParam(value = "taskId") String taskId) throws Exception{
    ModelAndView modelAndView = new ModelAndView();
    //根据任务编号，查询环节列表
    List<AcmgTTaskTacheCustom>  tacheCustoms = taskService.listTacheCustomByTaskId(taskId);
    
    modelAndView.addObject("taskId", taskId);
    modelAndView.addObject("tacheCustoms", tacheCustoms);
    modelAndView.setViewName("/task/tache/ListTache");
    return modelAndView;
  }
  
  /**
   * 展示编辑环节页面
   * 
   * @作者： 王文博
   * @创建日期：2017年9月18日
   *
   * @param taskId
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("showEditTache")
  public ModelAndView showEditTache(@RequestParam(value = "taskId") String taskId, @RequestParam(value = "tacheId", required = false) String tacheId)
      throws Exception {
    ModelAndView modelAndView = new ModelAndView();
    AcmgTTaskTacheCustom tacheCustom = new AcmgTTaskTacheCustom();
    
    if(StringUtils.isNotBlank(tacheId)) {
      tacheCustom = taskService.getTacheByTacheId(tacheId);
    }
    modelAndView.addObject("taskId", taskId);
    modelAndView.addObject("tacheCustom", tacheCustom);
    modelAndView.setViewName("/task/tache/EditTache");
    return modelAndView;
  }
  
  @RequestMapping("submitEditTache")
  @ResponseBody
  public Map<String, Object> submitEditTache(HttpServletRequest request)throws Exception{
    Map<String, Object> map = new HashMap<String, Object>();
    String msg = "";
    boolean flag = false;
    
    String taskId = request.getParameter("taskId");
    String tacheId = request.getParameter("tacheId");
    String tacheType = request.getParameter("tacheType");
    String tacheFlag = request.getParameter("tacheFlag");
    String tacheName = request.getParameter("tacheName");
    
    AcmgTTaskTache taskTache = new AcmgTTaskTache();
    taskTache.setTaskId(taskId);
    taskTache.setTacheId(tacheId);
    taskTache.setTacheType(tacheType);
    taskTache.setTacheFlag(tacheFlag);
    taskTache.setTacheName(tacheName);
    
    try{
      taskService.saveTache(taskTache);
      msg = "保存成功！";
      flag = true;
    }catch (Exception e) {
      e.printStackTrace();
      msg = e.getMessage();
    }
    
    map.put("msg", msg);
    map.put("flag", flag);
    
    return map;
  }
  
}
