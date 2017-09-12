package com.zzxy.ssm.mapper;

import java.util.List;

import com.zzxy.ssm.po.AsmgTCodeInfo;
import com.zzxy.ssm.po.AsmgTCodeInfoQueryVO;
import com.zzxy.ssm.po.AsmgTCodeType;
import com.zzxy.ssm.po.AsmgTCodeTypeQueryVO;
/**
 * 码值Mapper接口
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月18日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public interface AsmgTCodeTypeMapper {
  
  /**
   * 查询码值类型列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param asmgTCodeTypeQueryVO
   * @return List<AsmgTCodeType>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AsmgTCodeType> listAsmgTCodeType(AsmgTCodeTypeQueryVO asmgTCodeTypeQueryVO);
  
  /**
   * 根据主键查询码值类型信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param tableKey
   * @return AsmgTCodeType
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AsmgTCodeType getCodeTypeByPrimaryKey(String typeCode);
  
  /**
   * 增加码值类型信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param codeType
   * @return int
   *
   * @修改记录（修改时间、作者、原因）：
   */
  int insertCodeType(AsmgTCodeType asmgTCodeType);
  
  /**
   * 修改码值类型列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param codeType
   * @return int
   *
   * @修改记录（修改时间、作者、原因）：
   */
  int updateCodeType(AsmgTCodeType asmgTCodeType);
  
  /**
   * 删除码值类型
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param tableKey
   * @return int
   *
   * @修改记录（修改时间、作者、原因）：
   */
  int deleteCodeType(String typeCode);
  
  /**
   * 根据码值类型获取码值列表
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param codeType
   * @return List<AsmgTCodeInfo>
   *
   * @修改记录（修改时间、作者、原因）：
   */
  List<AsmgTCodeInfo> listCodeInfoByTypeCode(AsmgTCodeInfoQueryVO asmgTCodeInfoQueryVO);
  
  /**
   * 根据主键获取码值信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param tableKey
   * @return AsmgTCodeInfo
   *
   * @修改记录（修改时间、作者、原因）：
   */
  AsmgTCodeInfo getCodeInfoByPrimaryKey(String codeValue);
  
  /**
   * 新增码值信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param codeInfo
   * @return int
   *
   * @修改记录（修改时间、作者、原因）：
   */
  int insertCodeInfo(AsmgTCodeInfo asmgTCodeInfo);
  
  /**
   * 更新码值信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param codeInfo
   * @return int
   *
   * @修改记录（修改时间、作者、原因）：
   */
  int updateCodeInfo(AsmgTCodeInfo asmgTCodeInfo);
  
  /**
   * 删除码值信息
   * 
   * @作者： 王文博
   * @创建日期：2017年8月18日
   *
   * @param tableKey
   * @return int
   *
   * @修改记录（修改时间、作者、原因）：
   */
  int deleteCodeInfo(String codeValue);
}