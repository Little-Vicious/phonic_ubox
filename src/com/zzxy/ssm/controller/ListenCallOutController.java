package com.zzxy.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 呼入监听Controller
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月25日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
@RequestMapping("listen")
public class ListenCallOutController {
  
  @RequestMapping("listenCallOut")
  public ModelAndView listenCallOut() throws Exception{
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("phone/listenCallOut/listen");
    return modelAndView;
  }

}
