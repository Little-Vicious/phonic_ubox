package com.zzxy.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzxy.ssm.common.utils.MD5Tools;
import com.zzxy.ssm.po.AprbTEmployee;
import com.zzxy.ssm.service.LoginService;
/**
 * 登陆Controller
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月11日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
public class LoginController {
  @Autowired
  private LoginService loginService;

  /**
   * 首页登录页面
   * 
   * @作者： 王文博
   * @创建日期：2017年9月11日
   *
   * @return ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("/index")
  public ModelAndView Index() {
    ModelAndView modelAndView = new ModelAndView("/index");
    return modelAndView;
  }
  
  /**
   * 登录方法
   * 
   * @作者： 王文博
   * @创建日期：2017年9月11日
   *
   * @param request
   * @return
   * @throws Exception Map<String,Object>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("/login")
  @ResponseBody
  public Map<String, Object> login(HttpServletRequest request) throws Exception{
    Map<String, Object> result = new HashMap<String, Object>();
    String msg = "";
    boolean flag = false;
    String account = request.getParameter("account");
    String password = request.getParameter("password");
    AprbTEmployee employee = loginService.getEmployeeByAccount(account);
    if(employee != null && employee.getId() != null) {
      String pwd = MD5Tools.MD5(password);
      if(employee.getPassword().equals(pwd)) {
        msg = "验证通过！";
        flag = true;
      }else {
        msg = "密码不正确！";
      }
    }else {
      msg = "用户名不存在！";
    }
    result.put("success", flag);
    result.put("message", msg);
    return result;
  }
  
  /**
   * 登录成功，跳转欢迎界面
   * 
   * @作者： 王文博
   * @创建日期：2017年9月13日
   *
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("success")
  public ModelAndView success() throws Exception{
    ModelAndView modelAndView = new ModelAndView("/welcome");
    return modelAndView;
  }
  
}
