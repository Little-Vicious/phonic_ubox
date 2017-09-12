package com.zzxy.ssm.service;

import java.util.List;

import com.zzxy.ssm.po.AprbTBatchCallout;
import com.zzxy.ssm.po.AprbTBatchCalloutCustom;
import com.zzxy.ssm.po.AprbTBatchCalloutQueryVO;
import com.zzxy.ssm.po.AprbTCustomerNumber;
import com.zzxy.ssm.po.AprbTSingleCallout;

/**
 * 批量外呼Service
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月8日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public interface BatchCallOutService {

  /**
   * 通过批量外呼查询VO获取批量外呼列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月21日
   *
   * @param batchcalloutQueryVO
   * @return List<AprbTBatchCalloutCustom>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTBatchCalloutCustom> listBatchCallOut(AprbTBatchCalloutQueryVO batchcalloutQueryVO);
  
  
  /**
   * 保存活动量群组信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月11日
   *
   * @param batchname
   * @param activityids void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void saveBatchCallOutByBatchType(AprbTBatchCalloutCustom aprbTBatchCalloutCustom, String[] arrGroupNos) throws Exception;


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
   * 通过群组No获取单个外呼列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月24日
   *
   * @param batchNo
   * @return List<AprbTSingleCallout>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AprbTSingleCallout> listSingleCallOutByBatchNo(String batchNo);


  /**
   * 外呼完成时，更新当前用户的状态
   * 
   * @作者： 王文博
   * @创建日期：2017年8月25日
   *
   * @param singleCallout void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  void effeiveAction(AprbTSingleCallout singleCallout);

}
