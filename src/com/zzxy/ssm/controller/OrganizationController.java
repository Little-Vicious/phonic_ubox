package com.zzxy.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 机构配置
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月7日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
@RequestMapping("organization")
public class OrganizationController {
  
  @RequestMapping("orgTree")
  public ModelAndView orgTree() throws Exception{
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("organization/orgTree");
    return modelAndView;
  }
  
  @RequestMapping("getOrgNodes")
  public Map<String, Object> getOrgNodes(HttpServletRequest request) throws Exception{
    Map<String, Object> result = new HashMap<String, Object>();
    
    return result;
  }
  
  
}
