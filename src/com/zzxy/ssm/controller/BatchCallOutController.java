package com.zzxy.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzxy.ssm.common.utils.Constants;
import com.zzxy.ssm.po.AprbTBatchCallout;
import com.zzxy.ssm.po.AprbTBatchCalloutCustom;
import com.zzxy.ssm.po.AprbTBatchCalloutQueryVO;
import com.zzxy.ssm.po.AprbTCustomerNumber;
import com.zzxy.ssm.po.AprbTSingleCallout;
import com.zzxy.ssm.service.BatchCallOutService;
import com.zzxy.ssm.service.CustomerService;

/**
 * 批量外呼Controller
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月8日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
@RequestMapping("/batchCallOut")
public class BatchCallOutController {
  
  //批量外呼Service
  @Autowired
  private BatchCallOutService batchCallOutService ;
  
  @Autowired
  private CustomerService customerService;
  
  /**
   * 批量外呼列表页面
   * 
   * @作者： 王文博
   * @创建日期：2017年8月8日
   *
   * @return ModelAndView
   * @throws Exception 
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("callList")
  public ModelAndView callList() throws Exception{
    List<AprbTBatchCalloutCustom> batchcalloutCustoms = batchCallOutService.listBatchCallOut(null);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("batchcalloutCustoms", batchcalloutCustoms);
    modelAndView.setViewName("phone/batchCallOut/batchCallOutMain");
    
    return modelAndView;
  }
  
  
  /**
   * 根据群组类型获取群组外呼群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月11日
   *
   * @return Map<String,Object>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("getBatchCallOutByBatchType")
  @ResponseBody
  public Map<String, Object> getBatchCallOutByBatchType(HttpServletRequest request) throws Exception {
    Map<String, Object> resultMap = new HashMap<String, Object>();
    String batchType = request.getParameter("batchType");
    AprbTBatchCalloutCustom aprbTBatchCalloutCustom = new AprbTBatchCalloutCustom();
    aprbTBatchCalloutCustom.setBatchType(batchType);
    AprbTBatchCalloutQueryVO batchcalloutQueryVO = new AprbTBatchCalloutQueryVO(aprbTBatchCalloutCustom);
    
    //通过codeInfoService获取码值信息包装类
    List<AprbTBatchCalloutCustom> batchcalloutCustoms = batchCallOutService.listBatchCallOut(batchcalloutQueryVO);
    //组织返回Map值
    resultMap.put("seccss", true);
    resultMap.put("batch", batchcalloutCustoms);
    return resultMap;
  }
  
  /**
   * 群组外呼中包含的单个外呼列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月24日
   *
   * @param batchcallout_id
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("showBatchCallOut")
  public ModelAndView showBatchCallOut(@RequestParam(value = "batchNo") String batchNo) throws Exception{
    ModelAndView modelandview = new ModelAndView();
    AprbTBatchCallout batchcalloutCustom = batchCallOutService.getBatchCalloutByPrimaryKey(batchNo);
    modelandview.addObject("batchcalloutCustom", batchcalloutCustom);
    List<AprbTSingleCallout> callOutCustoms =  batchCallOutService.listSingleCallOutByBatchNo(batchNo);
    modelandview.addObject("callOutCustom", callOutCustoms.get(0));
    modelandview.setViewName("phone/batchCallOut/batchCallOut");
    return modelandview;
  }
  
  /**
   * 获取当前批量外呼群组中的第一个外呼用户信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月14日
   *
   * @return
   * @throws Exception Map<String,Object>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("getCallOutInfo")
  @ResponseBody
  public Map<String, Object> getCallOutInfo(HttpServletRequest request) throws Exception {
    Map<String, Object> resultMap = new HashMap<String, Object>();
    
    //查询群组信息
    String batchNo = request.getParameter("batchNo");
    AprbTBatchCalloutCustom batchcalloutCustom = batchCallOutService.getBatchCalloutCustomByPrimaryKey(batchNo);
    resultMap.put("batchcalloutCustom", batchcalloutCustom);
    
    
    //查询单个外呼信息
    AprbTSingleCallout callOutCustom = new AprbTSingleCallout();
    
    
    //组织客户电话号码
    List<AprbTCustomerNumber> customernumbers = new ArrayList<AprbTCustomerNumber>();
    List<AprbTSingleCallout> callOutCustoms = batchCallOutService.listSingleCallOutByBatchNo(batchNo);
    if (callOutCustoms != null && callOutCustoms.size() > 0) {
      callOutCustom = callOutCustoms.get(0);
      customernumbers = customerService.listCustNumbers(callOutCustom.getCustNo());
    }
    
    resultMap.put("callOutCustom", callOutCustom);
    resultMap.put("customernumbers", customernumbers);
    return resultMap;
  }
  
  /**
   * 外呼完成时，更新状态
   * 
   * @作者： 王文博
   * @创建日期：2017年8月17日
   *
   * @param request
   * @return
   * @throws Exception Map<String,Object>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("effeiveAction")
  @ResponseBody
  public Map<String, Object> effeiveAction(HttpServletRequest request) throws Exception{
    Map<String, Object> resultMap = new HashMap<String, Object>();
    String callNo = request.getParameter("callout_id");
    AprbTSingleCallout singleCallout = new AprbTSingleCallout();
    singleCallout.setCallNo(callNo);
    singleCallout.setCalloutStatus(Constants.CALLOUT_STATUS_EFFECTIVE);
    batchCallOutService.effeiveAction(singleCallout);
    resultMap.put("success", true);
    return resultMap;
  }
}
