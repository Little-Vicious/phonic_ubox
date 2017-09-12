package com.zzxy.ssm.mapper;

import java.util.List;

import com.zzxy.ssm.po.AprbTBatchCallout;
import com.zzxy.ssm.po.AprbTBatchCalloutCustom;
import com.zzxy.ssm.po.AprbTBatchCalloutQueryVO;
import com.zzxy.ssm.po.AprbTCustomerNumber;
import com.zzxy.ssm.po.AprbTCustomerNumberQueryVO;
import com.zzxy.ssm.po.AprbTSingleCallout;
import com.zzxy.ssm.po.AprbTSingleCalloutCustom;
import com.zzxy.ssm.po.AprbTSingleCalloutQueryVO;

public interface AprbTBatchCalloutMapper {

  /**
   * 新增群组外呼信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月24日
   *
   * @param aprbTBatchCalloutCustom
   * @return int
   *
   * @修改记录（修改时间、作者、原因）：
   */
  int insertBatchCallOut(AprbTBatchCalloutCustom aprbTBatchCalloutCustom);

  int deleteByPrimaryKey(String batchNo);

  /**
   * 通过主键获取群组外呼信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月24日
   *
   * @param batchNo
   * @return AprbTBatchCallout
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AprbTBatchCallout getBatchCalloutByPrimaryKey(String batchNo);

  int updateByPrimaryKeySelective(AprbTBatchCallout record);

  /**
   * 根据群组No和客户No获取单个外呼信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月24日
   *
   * @param aprbTSingleCalloutQueryVO
   * @return AprbTSingleCallout
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AprbTSingleCallout getCallOutByBatchnodAndCustno(AprbTSingleCalloutQueryVO aprbTSingleCalloutQueryVO);

  /**
   * 新增单个外呼信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月24日
   *
   * @param aprbTSingleCalloutCustom void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void insertSingleCallout(AprbTSingleCalloutCustom aprbTSingleCalloutCustom);

  /**
   * 获取群组外呼列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月24日
   *
   * @param aprbTBatchCalloutQueryVO
   * @return List<AprbTBatchCalloutCustom>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTBatchCalloutCustom> listBatchCallOutCustom(AprbTBatchCalloutQueryVO aprbTBatchCalloutQueryVO);

  /**
   * 通过查询包装类获取单个外呼列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月24日
   *
   * @param calloutQueryVO
   * @return List<AprbTSingleCallout>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTSingleCallout> listSingleCallOutByBatchNo(AprbTSingleCalloutQueryVO calloutQueryVO);

  /**
   * 根据主键获取群组外呼包装类
   * 
   * @作者： 王文博
   * @创建日期：2017年8月25日
   *
   * @param batchNo
   * @return AprbTBatchCalloutCustom
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AprbTBatchCalloutCustom getBatchCalloutCustomByPrimaryKey(String batchNo);

  /**
   * 更新单个外呼信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月25日
   *
   * @param singleCallout void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void updateSingleCallout(AprbTSingleCallout singleCallout);

  

}