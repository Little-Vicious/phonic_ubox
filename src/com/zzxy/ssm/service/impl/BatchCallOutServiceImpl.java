package com.zzxy.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzxy.ssm.common.utils.Constants;
import com.zzxy.ssm.mapper.AprbTActivityGroupMapper;
import com.zzxy.ssm.mapper.AprbTBatchCalloutMapper;
import com.zzxy.ssm.mapper.AprbTClientsGroupMapper;
import com.zzxy.ssm.mapper.AprbTNoticeGroupMapper;
import com.zzxy.ssm.mapper.AprbTOppoGroupMapper;
import com.zzxy.ssm.po.AprbTActivityGroup;
import com.zzxy.ssm.po.AprbTBatchCallout;
import com.zzxy.ssm.po.AprbTBatchCalloutCustom;
import com.zzxy.ssm.po.AprbTBatchCalloutQueryVO;
import com.zzxy.ssm.po.AprbTClientsGroup;
import com.zzxy.ssm.po.AprbTNoticeGroup;
import com.zzxy.ssm.po.AprbTOppoGroup;
import com.zzxy.ssm.po.AprbTSingleCallout;
import com.zzxy.ssm.po.AprbTSingleCalloutCustom;
import com.zzxy.ssm.po.AprbTSingleCalloutQueryVO;
import com.zzxy.ssm.service.BatchCallOutService;
/**
 * 批量外呼Service实现类
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月8日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class BatchCallOutServiceImpl implements BatchCallOutService {

  @Autowired
  private AprbTBatchCalloutMapper aprbTBatchCalloutMapper;
  
  @Autowired
  private AprbTOppoGroupMapper aprbTOppoGroupMapper;
  
  @Autowired
  private AprbTActivityGroupMapper activityGroupMapper;
  
  @Autowired
  private AprbTNoticeGroupMapper noticeGroupMapper;
  
  @Autowired
  private AprbTClientsGroupMapper clientsGroupMapper;
  
  /**
   * 通过批量外呼查询VO获取批量外呼列表
   */
  @Override
  public List<AprbTBatchCalloutCustom> listBatchCallOut(AprbTBatchCalloutQueryVO aprbTBatchCalloutQueryVO) {
    return aprbTBatchCalloutMapper.listBatchCallOutCustom(aprbTBatchCalloutQueryVO);
  }
  
  /**
   * 保存活动量群组信息
   */
  @Override
  public void saveBatchCallOutByBatchType(AprbTBatchCalloutCustom aprbTBatchCalloutCustom, String[] arrGroupNos) throws Exception{
    //保存批量外呼信息
    aprbTBatchCalloutCustom.setInsertDatetime(new Date());
    if(StringUtils.isBlank(aprbTBatchCalloutCustom.getBatchNo())) {
      aprbTBatchCalloutMapper.insertBatchCallOut(aprbTBatchCalloutCustom);
    }
    //保存批量外呼中的单个外呼
    for(String groupNo :arrGroupNos) {
      AprbTSingleCalloutCustom aprbTSingleCalloutCustom = new AprbTSingleCalloutCustom();
      aprbTSingleCalloutCustom.setBatchNo(aprbTBatchCalloutCustom.getBatchNo());
      setSingleCallout(aprbTBatchCalloutCustom.getBatchType(), aprbTSingleCalloutCustom, groupNo);
      if(!callIsExists(aprbTSingleCalloutCustom)) {//如果该用户没有存在当前批量外呼群组中
        aprbTBatchCalloutMapper.insertSingleCallout(aprbTSingleCalloutCustom);
      }
    }
  }
  
  /**
   * 根据不同群组类型设置单个外呼信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月22日
   *
   * @param batchType
   * @param aprbTSingleCalloutCustom
   * @param groupNo
   * @throws Exception void
   *
   * @修改记录（修改时间、作者、原因）：
   */
  private void setSingleCallout(String batchType,AprbTSingleCalloutCustom aprbTSingleCalloutCustom,String groupNo) throws Exception {
    if(Constants.ASMG_T_CODE_INFO_BATCHTYPE_OPPO.equals(batchType)) {
      AprbTOppoGroup  oppoGroup = aprbTOppoGroupMapper.getOppoGroupByPrimaryKey(groupNo);
      aprbTSingleCalloutCustom.setCustNo(oppoGroup.getCustNo());
      aprbTSingleCalloutCustom.setCustNumber(oppoGroup.getCustNumber());
      aprbTSingleCalloutCustom.setCustName(oppoGroup.getCustName());
    }else if(Constants.ASMG_T_CODE_INFO_BATCHTYPE_ACTIVITY.equals(batchType)) {
      AprbTActivityGroup activityGroup = activityGroupMapper.getActivityGroupByPrimaryKey(groupNo);
      aprbTSingleCalloutCustom.setCustNo(activityGroup.getCustNo());
      aprbTSingleCalloutCustom.setCustNumber("18539962773");
      aprbTSingleCalloutCustom.setCustName(activityGroup.getCustName());
    }else if (Constants.ASMG_T_CODE_INFO_BATCHTYPE_NOTICE.equals(batchType)) {
      AprbTNoticeGroup noticeGroup = noticeGroupMapper.getNoticeGroupByPrimaryKey(groupNo);
      aprbTSingleCalloutCustom.setCustNo(noticeGroup.getCustNo());
      aprbTSingleCalloutCustom.setCustNumber(noticeGroup.getCustNumber());
      aprbTSingleCalloutCustom.setCustName(noticeGroup.getCustName());
    }else if (Constants.ASMG_T_CODE_INFO_BATCHTYPE_CLIENTS.equals(batchType)) {
      AprbTClientsGroup clientsGroup = clientsGroupMapper.getClientsGroupByPrimaryKey(groupNo);
      aprbTSingleCalloutCustom.setCustNo(clientsGroup.getCustNo());
      aprbTSingleCalloutCustom.setCustNumber("18539962773");
      aprbTSingleCalloutCustom.setCustName(clientsGroup.getCustName());
    }
  }
  
  /**
   * 判断该用户是否已经存在当前批量外呼群组
   * 
   * @作者： 王文博
   * @创建日期：2017年8月14日
   *
   * @param callOutCustom
   * @return boolean
   *
   * @修改记录（修改时间、作者、原因）：
   */
  private boolean callIsExists(AprbTSingleCalloutCustom aprbTSingleCalloutCustom) {
    boolean flag = false;
    AprbTSingleCalloutQueryVO aprbTSingleCalloutQueryVO = new AprbTSingleCalloutQueryVO(aprbTSingleCalloutCustom);
    AprbTSingleCallout custom =  aprbTBatchCalloutMapper.getCallOutByBatchnodAndCustno(aprbTSingleCalloutQueryVO);
    if(custom != null && custom.getCallNo() != null) {
      flag = true;
    }
    return flag;
  }

  /**
   * 通过主键获取群组外呼信息
   */
  @Override
  public AprbTBatchCallout getBatchCalloutByPrimaryKey(String batchNo) {
    return aprbTBatchCalloutMapper.getBatchCalloutByPrimaryKey(batchNo);
  }

  /**
   * 通过群组No获取单个外呼列表
   */
  @Override
  public List<AprbTSingleCallout> listSingleCallOutByBatchNo(String batchNo) {
    AprbTSingleCalloutCustom singleCalloutCustom  = new AprbTSingleCalloutCustom();
    singleCalloutCustom.setBatchNo(batchNo);
    AprbTSingleCalloutQueryVO calloutQueryVO = new AprbTSingleCalloutQueryVO(singleCalloutCustom);
    return aprbTBatchCalloutMapper.listSingleCallOutByBatchNo(calloutQueryVO);
  }

  /**
   * 根据主键获取群组外呼包装类
   */
  @Override
  public AprbTBatchCalloutCustom getBatchCalloutCustomByPrimaryKey(String batchNo) {
    return aprbTBatchCalloutMapper.getBatchCalloutCustomByPrimaryKey(batchNo);
  }

  /**
   * 外呼完成时，更新当前用户的状态
   */
  @Override
  public void effeiveAction(AprbTSingleCallout singleCallout) {
    aprbTBatchCalloutMapper.updateSingleCallout(singleCallout);
  }

}
