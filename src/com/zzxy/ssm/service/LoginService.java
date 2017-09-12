package com.zzxy.ssm.service;

import com.zzxy.ssm.po.AprbTEmployee;

/**
 * 登录Service
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月11日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public interface LoginService {

  /**
   * 根据账号获取员工信息
   * 
   * @作者： 王文博
   * @创建日期：2017年9月11日
   *
   * @param account
   * @return AprbTEmployee
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AprbTEmployee getEmployeeByAccount(String account);

}
