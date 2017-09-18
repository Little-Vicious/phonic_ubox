package com.zzxy.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zzxy.ssm.mapper.AprbTEmployeeMapper;
import com.zzxy.ssm.po.AprbTEmployee;
import com.zzxy.ssm.po.AprbTEmployeeCustom;
import com.zzxy.ssm.po.AprbTEmployeeQueryVO;
import com.zzxy.ssm.service.LoginService;
/**
 * 登录Service实现类
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月11日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class LoginServiceImpl implements LoginService {

  @Autowired
  private AprbTEmployeeMapper employeeMapper;
  /**
   * 根据账号获取员工信息
   */
  @Override
  public AprbTEmployee getEmployeeByAccount(String account) {
    AprbTEmployeeCustom aprbTEmployeeCustom = new AprbTEmployeeCustom();
    aprbTEmployeeCustom.setAccount(account);
    AprbTEmployeeQueryVO employeeQueryVO = new AprbTEmployeeQueryVO(aprbTEmployeeCustom );
    return employeeMapper.getEmployeeByVO(employeeQueryVO);
  }
  
}
