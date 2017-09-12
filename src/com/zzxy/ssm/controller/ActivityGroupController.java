package com.zzxy.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zzxy.ssm.common.utils.Constants;
import com.zzxy.ssm.po.AprbTActivityGroup;
import com.zzxy.ssm.po.AprbTActivityGroupCustom;
import com.zzxy.ssm.po.AprbTActivityGroupQueryVO;
import com.zzxy.ssm.po.AprbTBatchCalloutCustom;
import com.zzxy.ssm.service.ActivityGroupService;

/**
 * 活动量群组Controller
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月9日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
@RequestMapping("/activity")
public class ActivityGroupController {
  
  @Autowired
  private ActivityGroupService activityGroupService;

  /**
   * 活动量群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月9日
   *
   * @return ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("listActivityGroup")
  public ModelAndView listActivityGroup(AprbTActivityGroupQueryVO aprbTActivityGroupQueryVO)throws Exception {
    List<AprbTActivityGroup> activitygroups = activityGroupService.listCustActivityGroups(new AprbTActivityGroupQueryVO());
    
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("activitygroups", activitygroups);
    modelAndView.addObject("batchType", Constants.ASMG_T_CODE_INFO_BATCHTYPE_ACTIVITY);
    modelAndView.addObject("activitygroupCustom", aprbTActivityGroupQueryVO.getActivityGroupCustom());
    modelAndView.setViewName("group/activity/listActivityGroup");
    return modelAndView;
  }
  
  /**
   * 查询活动量群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月9日
   *
   * @return ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("queryListActivityGroup")
  public ModelAndView queryListActivityGroup(String contactStep,String activityType,AprbTActivityGroupCustom aprbTActivityGroupCustom)throws Exception {
    aprbTActivityGroupCustom.setContactStep(contactStep);
    aprbTActivityGroupCustom.setActivityType(activityType);
    AprbTActivityGroupQueryVO activitygroupQueryVO = new AprbTActivityGroupQueryVO(aprbTActivityGroupCustom);
    List<AprbTActivityGroup> activitygroups = activityGroupService.listCustActivityGroups(activitygroupQueryVO );
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("activitygroups", activitygroups);
    modelAndView.addObject("activitygroupCustom", aprbTActivityGroupCustom);
    modelAndView.setViewName("group/activity/listActivityGroup");
    return modelAndView;
  }
  
  /**
   * 修改活动量群组里面的客户信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月10日
   *
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("editActivityCust")
  public ModelAndView editCust() throws Exception {
    AprbTActivityGroup activitygroup = new AprbTActivityGroup();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("activitygroup", activitygroup);
    modelAndView.setViewName("group/activity/editCust");
    return modelAndView;
  }
  
  
  /**
   * 修改活动量群组里面的客户信息提交功能
   * 
   * @作者： 王文博
   * @创建日期：2017年8月10日
   *
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("editCustSubmit")
  public String editCustSubmit(AprbTActivityGroup activitygroup,HttpServletRequest request) throws Exception {
    String custNo = request.getParameter("custNo");
    String activityType = request.getParameter("activitytype");
    String contactStep = request.getParameter("contactStep");
    String sourceChannels = request.getParameter("sourceChannels");
    activitygroup.setCustNo(custNo);
    activitygroup.setActivityType(activityType);
    activitygroup.setContactStep(contactStep);
    activitygroup.setSourceChannels(sourceChannels);
    activityGroupService.saveActivityGroup(activitygroup);
    return "forward:listActivityGroup.do";
  }
  
  
  /**
   * 保存群组提交
   * 
   * @作者： 王文博
   * @创建日期：2017年8月14日
   *
   * @param request
   * @return ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("saveActivityGroupSubmit")
  public String saveActivityGroupSubmit(HttpServletRequest request) {
    String idsStr = request.getParameter("activityids");
    String projectname = request.getParameter("projectname");
    String batchid = request.getParameter("batchid");
    String batchType = request.getParameter("batchType");
    String[] activityids = idsStr.split(",");
    AprbTBatchCalloutCustom batchcalloutCustom = new AprbTBatchCalloutCustom();
    batchcalloutCustom.setBatchNo(batchid);
    batchcalloutCustom.setProjectName(projectname);
    batchcalloutCustom.setBatchType(batchType);
    //activityGroupService.saveBatchCallOutByBatchType(batchcalloutCustom,activityids);
    return "redirect:listActivityGroup.do";
  }
  
}
