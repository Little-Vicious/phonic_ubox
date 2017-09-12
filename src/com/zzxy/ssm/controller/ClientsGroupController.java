package com.zzxy.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zzxy.ssm.common.utils.Constants;
import com.zzxy.ssm.po.AprbTActivityGroup;
import com.zzxy.ssm.po.AprbTActivityGroupQueryVO;
import com.zzxy.ssm.po.AprbTClientsGroup;
import com.zzxy.ssm.po.AprbTClientsGroupCustom;
import com.zzxy.ssm.po.AprbTClientsGroupQueryVO;

/**
 * 客户群组Controller
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月1日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
@RequestMapping("/clients")
public class ClientsGroupController {
  
  @RequestMapping("listClientsGroup")
  public ModelAndView listClientsGroup(AprbTClientsGroupQueryVO clientsGroupQueryVO)throws Exception {
//    List<AprbTActivityGroup> activitygroups = activityGroupService.listCustActivityGroups(new AprbTActivityGroupQueryVO());
    List<AprbTClientsGroup> clientsGroups = new ArrayList<AprbTClientsGroup>();
    
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("clientsGroups", clientsGroups);
    modelAndView.addObject("batchType", Constants.ASMG_T_CODE_INFO_BATCHTYPE_CLIENTS);
    modelAndView.addObject("clientsGroupCustom", clientsGroupQueryVO.getAprbTClientsGroupCustom());
    modelAndView.setViewName("group/clients/listClientsGroup");
    return modelAndView;
  }
  
}
