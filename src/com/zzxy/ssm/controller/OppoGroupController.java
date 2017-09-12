package com.zzxy.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zzxy.ssm.common.utils.Constants;
import com.zzxy.ssm.po.AprbTOppoGroup;
import com.zzxy.ssm.po.AprbTOppoGroupCustom;
import com.zzxy.ssm.po.AprbTOppoGroupQueryVO;
import com.zzxy.ssm.service.OppoGroupService;

/**
 * 商机外呼群组Controller
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月22日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
@RequestMapping("/oppo")
public class OppoGroupController {
  
  @Autowired
  private OppoGroupService oppoGroupService;

  /**
   * 商机群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @return ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("listOppoGroup")
  public ModelAndView listOppoGroup() {
    List<AprbTOppoGroup> oppoGroups = oppoGroupService.listOppoGroups(null);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("oppoGroups", oppoGroups);
    modelAndView.addObject("batchType", Constants.ASMG_T_CODE_INFO_BATCHTYPE_OPPO);
    modelAndView.addObject("oppoGroupCustom", new AprbTOppoGroupCustom());
    modelAndView.setViewName("group/oppo/listOppoGroup");
    return modelAndView;
  }
  
  
  /**
   * 修改商机群组里面的客户信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月10日
   *
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("editOppoCust")
  public ModelAndView editCust() throws Exception {
    AprbTOppoGroup oppoGroup = new AprbTOppoGroup();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("oppoGroup", oppoGroup);
    modelAndView.setViewName("group/oppo/editCust");
    return modelAndView;
  }
  
  /**
   * 修改商机群组里面的客户信息提交
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @return
   * @throws Exception String
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("editCustSubmit")
  public String editCustSubmit(AprbTOppoGroup oppoGroup,HttpServletRequest request) throws Exception {
    String custNo = request.getParameter("custNo");
    String oppoType = request.getParameter("oppoType");
    String followStatus = request.getParameter("followStatus");
    oppoGroup.setCustNo(custNo.split(",")[0]);
    oppoGroup.setOppoType(oppoType);
    oppoGroup.setFollowStatus(followStatus);
    oppoGroupService.saveOppoGroup(oppoGroup);
    return "forward:listOppoGroup.do";
  }
  
  /**
   * 按查询商机群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @param oppoType
   * @param followStatus
   * @param oppoGroupCustom
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("queryListOppoGroup")
  public ModelAndView queryListOppoGroup(String oppoType,String followStatus,AprbTOppoGroupCustom oppoGroupCustom) throws Exception{
    oppoGroupCustom.setOppoType(oppoType);
    oppoGroupCustom.setFollowStatus(followStatus);
    List<AprbTOppoGroup> oppoGroups = oppoGroupService.listOppoGroups(new AprbTOppoGroupQueryVO(oppoGroupCustom));
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("oppoGroups", oppoGroups);
    modelAndView.addObject("oppoGroupCustom", oppoGroupCustom);
    modelAndView.setViewName("group/oppo/listOppoGroup");
    return modelAndView;
  }
  
  
  
}
