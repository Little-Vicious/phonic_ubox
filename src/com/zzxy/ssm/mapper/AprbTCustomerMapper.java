package com.zzxy.ssm.mapper;

import java.util.List;

import com.zzxy.ssm.po.AprbTCustomer;
import com.zzxy.ssm.po.AprbTCustomerNumber;
/**
 * 客户信息Mapper接口
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月10日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public interface AprbTCustomerMapper {

  /**
   * 客户信息列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月10日
   *
   * @return List<Customer>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTCustomer> listCustomer();

  /**
   * 获取客户的主要联系电话
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @param custNo
   * @return String
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AprbTCustomerNumber getMainCustNumber(String custNo);

  /**
   * 获取客户的非主要电话列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @param custNo
   * @return List<String>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTCustomerNumber> listCustNumbers(String custNo);
}