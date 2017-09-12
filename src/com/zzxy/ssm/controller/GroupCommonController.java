package com.zzxy.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzxy.ssm.common.utils.Constants;
import com.zzxy.ssm.po.AprbTBatchCalloutCustom;
import com.zzxy.ssm.po.AprbTCustomerCustom;
import com.zzxy.ssm.po.AsmgTCodeInfo;
import com.zzxy.ssm.po.AsmgTCodeTypeCustom;
import com.zzxy.ssm.po.CodeInfo;
import com.zzxy.ssm.po.CodeType;
import com.zzxy.ssm.service.BatchCallOutService;
import com.zzxy.ssm.service.CodeInfoService;
import com.zzxy.ssm.service.CustomerService;

/**
 * 群组公用Controller
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
@RequestMapping("/groupCommon")
public class GroupCommonController {
  
  @Autowired
  private CodeInfoService codeInfoService;
  
  @Autowired
  private CustomerService customerService;
  
  @Autowired
  private BatchCallOutService batchCallOutService;
  
  
  /**
   * 通过ajax获取码值Map，初始化下拉框用
   * 
   * @作者： 王文博
   * @创建日期：2017年8月9日
   *
   * @param request
   * @return
   * @throws Exception Map<String,Object>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("getInitCode")
  @ResponseBody
  public Map<String, Object> getInitCode(HttpServletRequest request) throws Exception {
    Map<String, Object> resultMap = new HashMap<String, Object>();
    
    //通过codeInfoService获取码值信息包装类
    List<AsmgTCodeTypeCustom> listCodeType = codeInfoService.listCodeTypeCustom();
    
    List<CodeType> codeTypes = new ArrayList<CodeType>();
    
    for(AsmgTCodeTypeCustom asmgTCodeTypeCustom : listCodeType) {
      List<CodeInfo> listCodeInfo = new ArrayList<CodeInfo>();
      List<AsmgTCodeInfo> listAsmgTCodeInfo = asmgTCodeTypeCustom.getListAsmgTCodeInfo();
      for(AsmgTCodeInfo asmgTCodeInfo : listAsmgTCodeInfo) {
        CodeInfo codeInfo = new CodeInfo();
        codeInfo.setTypeCode(asmgTCodeInfo.getTypeCode());
        codeInfo.setCodeName(asmgTCodeInfo.getCodeName());
        codeInfo.setCodeValue(asmgTCodeInfo.getCodeValue());
        listCodeInfo.add(codeInfo);
      }
      CodeType codeType = new CodeType(asmgTCodeTypeCustom.getTypeCode(), asmgTCodeTypeCustom.getTypeName(), listCodeInfo);
      codeTypes.add(codeType);
    }
    
    //通过customerService获取客户信息列表
    List<AprbTCustomerCustom> customers = customerService.listCustomer();
    //组织返回Map值
    resultMap.put("seccss", true);
    resultMap.put("codeTypes", codeTypes);
    resultMap.put("customers", customers);
    return resultMap;
  }
  
  /**
   * 保存群组
   * 
   * @作者： 王文博
   * @创建日期：2017年8月11日
   *
   * @param request
   * @return ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("saveGroup")
  public ModelAndView saveActivityGroup(HttpServletRequest request) {
    String[] groupNos = request.getParameterValues("groupNos");
    String batchType = request.getParameter("batchType");
    String nosStr = "";
    for(String no :groupNos ) {
      nosStr+= no+",";
    }
    if(nosStr.length() > 0) {
      nosStr = nosStr.substring(0, nosStr.length()-1);
    }
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("groupNos", nosStr);
    modelAndView.addObject("batchType", batchType);
    modelAndView.setViewName("group/editGroup");
    return modelAndView;
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
  @RequestMapping("saveGroupSubmit")
  public String saveGroupSubmit(HttpServletRequest request) throws Exception{
    String groupNos = request.getParameter("groupNos");
    String projectName = request.getParameter("projectname");
    String batchType = request.getParameter("batchType");
    String batchNo = request.getParameter("batchid");
    String[] arrGroupNos = groupNos.split(",");
    AprbTBatchCalloutCustom aprbTBatchCalloutCustom = new AprbTBatchCalloutCustom();
    aprbTBatchCalloutCustom.setProjectName(projectName);
    aprbTBatchCalloutCustom.setBatchType(batchType);
    aprbTBatchCalloutCustom.setBatchNo(batchNo);
    batchCallOutService.saveBatchCallOutByBatchType(aprbTBatchCalloutCustom,arrGroupNos);
    return getRedirectUrl(batchType);
  }
  
  /**
   * 自定义群组
   * 
   * @作者： 王文博
   * @创建日期：2017年8月11日
   *
   * @param request
   * @return ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("customizeGroup")
  public ModelAndView customizeGroup(HttpServletRequest request) {
    String groupNos = request.getParameter("groupNos");
    String batchType = request.getParameter("batchType");
    String projectname = "";
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("groupNos", groupNos);
    modelAndView.addObject("projectname", projectname);
    modelAndView.addObject("batchType", batchType);
    modelAndView.setViewName("group/customizeGroup");
    return modelAndView;
  }
  
  /**
   * 自定义群组提交
   * 
   * @作者： 王文博
   * @创建日期：2017年8月11日
   *
   * @param request
   * @return ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("customizeSubmit")
  public String customizeSubmit(HttpServletRequest request) throws Exception{
    String groupNos = request.getParameter("groupNos");
    String projectName = request.getParameter("projectname");
    String batchType = request.getParameter("batchType");
    String[] arrGroupNos = groupNos.split(",");
    AprbTBatchCalloutCustom aprbTBatchCalloutCustom = new AprbTBatchCalloutCustom();
    aprbTBatchCalloutCustom.setProjectName(projectName);
    aprbTBatchCalloutCustom.setBatchType(batchType);
    batchCallOutService.saveBatchCallOutByBatchType(aprbTBatchCalloutCustom,arrGroupNos);
    return getRedirectUrl(batchType);
  }
  
  /**
   * 组织重定向页面url
   * 
   * @作者： 王文博
   * @创建日期：2017年8月24日
   *
   * @param batchType
   * @return String
   *
   * @修改记录（修改时间、作者、原因）：
   */
  private String getRedirectUrl(String batchType) {
    String url = "";
    if(Constants.ASMG_T_CODE_INFO_BATCHTYPE_ACTIVITY.equals(batchType)) {
      url = "redirect:/activity/listActivityGroup.do";
    }else if(Constants.ASMG_T_CODE_INFO_BATCHTYPE_OPPO.equals(batchType)) {
      url = "redirect:/oppo/listOppoGroup.do";
    }else if(Constants.ASMG_T_CODE_INFO_BATCHTYPE_NOTICE.equals(batchType)) {
      url = "redirect:/notice/listNoticeGroup.do";
    }else if(Constants.ASMG_T_CODE_INFO_BATCHTYPE_CLIENTS.equals(batchType)) {
      url = "redirect:/clients/listClientsGroup.do";
    }
    return url;
  }
  
}
