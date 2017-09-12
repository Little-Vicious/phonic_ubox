package com.zzxy.ssm.service;

import java.util.List;

import com.zzxy.ssm.po.AsmgTCodeInfo;
import com.zzxy.ssm.po.AsmgTCodeType;
import com.zzxy.ssm.po.AsmgTCodeTypeCustom;

/**
 * 码值Service
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月9日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public interface CodeInfoService {
	
	/**
	 * 获取所有码值类型
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @return List<Codetype>
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public List<AsmgTCodeType> listCodetypeAll();

	/**
	 * 根据码值类型获取码值类型信息
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param code_type
	 * @return Codetype
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public AsmgTCodeType getCodeTypeByPrimaryKey(String typeCode);

	/**
	 * 保存码值类型
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param codetype void
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void saveCodeType(AsmgTCodeType asmgTCodeType);

	/**
	 * 删除码值类型信息
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param code_type void
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void deleteCodeType(String typeCode);

	/**
	 * 根据码值类型获取码值列表
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param code_type
	 * @return List<Codeinfo>
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public List<AsmgTCodeInfo> listCodeInfoByCodetype(String typeCode);

	/**
	 * 根据码值ID获取码值信息
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param codeinfo_id
	 * @return Codeinfo
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public AsmgTCodeInfo getCodeInfoByPrimaryKey(String codeValue);

	/**
	 * 保存码值信息
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param codeinfo void
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void saveCodeInfo(AsmgTCodeInfo asmgTCodeInfo);

	/**
	 * 删除码值信息
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param codeinfo_id void
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public void deleteCodeInfo(String codeValue);

	/**
	 * 获取码值Map，初始化下拉框用
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月10日
	 *
	 * @return List<CodeInfoCustom>
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public List<AsmgTCodeTypeCustom> listCodeTypeCustom();
}
