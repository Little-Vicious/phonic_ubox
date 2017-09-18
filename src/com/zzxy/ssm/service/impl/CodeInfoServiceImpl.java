package com.zzxy.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzxy.ssm.mapper.AsmgTCodeTypeMapper;
import com.zzxy.ssm.po.AsmgTCodeInfo;
import com.zzxy.ssm.po.AsmgTCodeInfoCustom;
import com.zzxy.ssm.po.AsmgTCodeInfoQueryVO;
import com.zzxy.ssm.po.AsmgTCodeType;
import com.zzxy.ssm.po.AsmgTCodeTypeCustom;
import com.zzxy.ssm.service.CodeInfoService;
/**
 * 码值Service实现类
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月9日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class CodeInfoServiceImpl implements CodeInfoService {

	@Autowired
	private AsmgTCodeTypeMapper asmgTCodeTypeMapper;

	/**
	 * 获取所有码值类型
	 */
	@Override
	public List<AsmgTCodeType> listCodetypeAll() {
		return asmgTCodeTypeMapper.listAsmgTCodeType(null);
	}

	/**
	 * 根据码值类型获取码值类型信息
	 */
	@Override
	public AsmgTCodeType getCodeTypeByPrimaryKey(String tableKey) {
		return asmgTCodeTypeMapper.getCodeTypeByPrimaryKey(tableKey);
	}

	/**
	 * 保存码值类型
	 */
	@Override
	public void saveCodeType(AsmgTCodeType asmgTCodeType) {
	  asmgTCodeTypeMapper.insertCodeType(asmgTCodeType);
		/*if(StringUtils.isBlank(asmgTCodeType.getTypeCode())) {
		  asmgTCodeTypeMapper.insertCodeType(asmgTCodeType);
		}else {
		  asmgTCodeTypeMapper.updateCodeType(asmgTCodeType);
		}*/
	}

	/**
	 * 删除码值类型信息
	 */
	@Override
	public void deleteCodeType(String tableKey) {
	  asmgTCodeTypeMapper.deleteCodeType(tableKey);
	}

	/**
	 * 根据码值类型获取码值列表
	 */
	@Override
	public List<AsmgTCodeInfo> listCodeInfoByCodetype(String typeCode) {
	  AsmgTCodeInfoQueryVO asmgTCodeInfoQueryVO = new AsmgTCodeInfoQueryVO();
	  AsmgTCodeInfoCustom asmgTCodeInfoCustom = new AsmgTCodeInfoCustom();
	  asmgTCodeInfoCustom.setTypeCode(typeCode);
    asmgTCodeInfoQueryVO.setAsmgTCodeInfoCustom(asmgTCodeInfoCustom );
		return asmgTCodeTypeMapper.listCodeInfoByTypeCode(asmgTCodeInfoQueryVO);
	}

	/**
	 * 根据码值ID获取码值信息
	 */
	@Override
	public AsmgTCodeInfo getCodeInfoByPrimaryKey(String tableKey) {
		return asmgTCodeTypeMapper.getCodeInfoByPrimaryKey(tableKey);
	}

	/**
	 * 保存码值信息
	 */
	@Override
	public void saveCodeInfo(AsmgTCodeInfo asmgTCodeInfo) {
		if(StringUtils.isBlank(asmgTCodeInfo.getIsDel())) {
		  asmgTCodeTypeMapper.insertCodeInfo(asmgTCodeInfo);
		}else {
		  asmgTCodeTypeMapper.updateCodeInfo(asmgTCodeInfo);
		}
	}

	/**
	 * 删除码值信息
	 */
	@Override
	public void deleteCodeInfo(String tableKey) {
	  asmgTCodeTypeMapper.deleteCodeInfo(tableKey);
	}

	/**
	 * 获取码值Map，初始化下拉框用
	 */
	@Override
  public List<AsmgTCodeTypeCustom> listCodeTypeCustom() {
    // 码值包装类型列表接收数据
    List<AsmgTCodeTypeCustom> listCodeTypeCustoms = new ArrayList<AsmgTCodeTypeCustom>();
    // 通过codeInfoService查到所有的码值类型信息
    List<AsmgTCodeType> listCodeTypes = this.listCodetypeAll();
    // 对所有的码值类型信息进行遍历
    for (AsmgTCodeType asmgTCodeType : listCodeTypes) {
      // 将码值包装类放到码值包装类列表中
      listCodeTypeCustoms.add(this.getCodeTypeCustomByType(asmgTCodeType.getTypeCode()));
    }
    return listCodeTypeCustoms;
  }

	/**
	 * 获取指定类型的码值Map，初始化下拉框用
	 */
  @Override
  public AsmgTCodeTypeCustom getCodeTypeCustomByType(String typeCode) {
    AsmgTCodeType asmgTCodeType = this.getCodeTypeByPrimaryKey(typeCode);
    
    AsmgTCodeTypeCustom asmgTCodeTypeCustom = new AsmgTCodeTypeCustom();
    BeanUtils.copyProperties(asmgTCodeType, asmgTCodeTypeCustom);
    
    // 通过codeInfoService按当前遍历到的码值类型信息中的码值类型查到所有码值信息列表
    // 将码值信息列表放入码值包装类
    List<AsmgTCodeInfo> lsitAsmgTCodeInfo = this.listCodeInfoByCodetype(asmgTCodeType.getTypeCode());
    asmgTCodeTypeCustom.setListAsmgTCodeInfo(lsitAsmgTCodeInfo);
    return asmgTCodeTypeCustom;
  }
	
	
	
}
