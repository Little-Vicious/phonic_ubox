package com.zzxy.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zzxy.ssm.mapper.AprbTCustomerMapper;
import com.zzxy.ssm.po.AprbTCustomer;
import com.zzxy.ssm.po.AprbTCustomerCustom;
import com.zzxy.ssm.po.AprbTCustomerNumber;
import com.zzxy.ssm.service.CustomerService;
/**
 * 客户信息Service
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月10日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private AprbTCustomerMapper aprbTCustomerMapper;
  
  /**
   * 客户列表
   */
  @Override
  public List<AprbTCustomerCustom> listCustomer() {
    List<AprbTCustomerCustom> customerCustoms = new ArrayList<AprbTCustomerCustom>();
    List<AprbTCustomer> listCustomer = aprbTCustomerMapper.listCustomer();
    for(AprbTCustomer customer:listCustomer) {
      AprbTCustomerCustom aprbTCustomerCustom = new AprbTCustomerCustom();
      aprbTCustomerCustom.setCustNo(customer.getCustNo());
      aprbTCustomerCustom.setCustName(customer.getCustName());
      aprbTCustomerCustom.setMainNumber(aprbTCustomerMapper.getMainCustNumber(customer.getCustNo()).getCustNumber());
      List<AprbTCustomerNumber> listCustNumbers = aprbTCustomerMapper.listCustNumbers(customer.getCustNo());
      List<String> listNumbers = new ArrayList<String>();
      for(AprbTCustomerNumber number :listCustNumbers) {
        listNumbers.add(number.getCustNumber());
      }
      aprbTCustomerCustom.setListNumbers(listNumbers);
      customerCustoms.add(aprbTCustomerCustom);
    }
    
    return customerCustoms;
  }

  /**
   * 获取客户的主要联系电话
   */
  @Override
  public AprbTCustomerNumber getMainCustNumber(String custNo) {
    return aprbTCustomerMapper.getMainCustNumber(custNo);
  }

  /**
   * 获取客户的非主要电话列表
   */
  @Override
  public List<AprbTCustomerNumber> listCustNumbers(String custNo) {
    return aprbTCustomerMapper.listCustNumbers(custNo);
  }

}
