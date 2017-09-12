package com.zzxy.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzxy.ssm.po.AsmgTCodeInfo;
import com.zzxy.ssm.po.AsmgTCodeType;
import com.zzxy.ssm.po.AsmgTCodeTypeCustom;
import com.zzxy.ssm.service.CodeInfoService;

/**
 * 码值Controller
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年8月9日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
@RequestMapping("/codeinfo")
public class CodeInfoController {

	@Autowired
	private CodeInfoService codeInfoService;
	
	/**
	 * 码值类型列表
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @return ModelAndView
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@RequestMapping("listCodetypeAll")
	public ModelAndView listCodetypeAll() {
		ModelAndView modelAndView = new ModelAndView();
		List<AsmgTCodeType> listCodeType  = codeInfoService.listCodetypeAll();
		modelAndView.addObject("listCodeType", listCodeType);
		modelAndView.setViewName("codeinfo/codeinfoMain");
		return modelAndView;
	}
	
	/**
	 * 编辑码值类型
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param code_type
	 * @return
	 * @throws Exception ModelAndView
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@RequestMapping("editCodeType")
	public ModelAndView editCodeType(@RequestParam(value = "typeCode", required = false) String typeCode) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		AsmgTCodeType asmgTCodeType = new AsmgTCodeType();
		if(typeCode != null) {
		  asmgTCodeType = codeInfoService.getCodeTypeByPrimaryKey(typeCode);
		}
		modelAndView.addObject("codetype", asmgTCodeType);
		modelAndView.setViewName("codeinfo/editCodeType");
		return modelAndView;
	}
	
	/**
	 * 编辑码值类型提交
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param codetype
	 * @return
	 * @throws Exception String
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@RequestMapping("editCodeTypeSubmit")
	public String editCodeTypeSubmit(AsmgTCodeType asmgTCodeType) throws Exception {
		// 调用service方法添加码值类型
		try {
			codeInfoService.saveCodeType(asmgTCodeType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:listCodetypeAll.do";
	}
	
	/**
	 * 删除码值类型
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param code_type
	 * @return
	 * @throws Exception String
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@RequestMapping("deleteCodeType")
	public String deleteCodeType(@RequestParam(value = "typeCode") String typeCode) throws Exception {
		// 调用service方法删除码值类型
		try {
			codeInfoService.deleteCodeType(typeCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:listCodetypeAll.do";
	}
	
	/**
	 * 码值类型下的码值列表
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param code_type
	 * @return
	 * @throws Exception ModelAndView
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@RequestMapping("listCodeInfoByType")
	public ModelAndView listCodeInfoByType(@RequestParam(value = "typeCode") String typeCode) throws Exception{
	  AsmgTCodeType codetype = codeInfoService.getCodeTypeByPrimaryKey(typeCode);
		
		List<AsmgTCodeInfo> codeinfos = codeInfoService.listCodeInfoByCodetype(typeCode);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("codetype", codetype);
		modelAndView.addObject("codeinfos", codeinfos);
		modelAndView.setViewName("codeinfo/listCodeInfoByType");
		return modelAndView;
	}
	
	/**
	 * 编辑码值类型下的码值
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @return
	 * @throws Exception ModelAndView
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@RequestMapping("editCodeInfoByType")
	public ModelAndView editCodeInfoByType(@RequestParam(value = "typeCode") String typeCode,
			@RequestParam(value = "codeValue", required = false) String codeValue) throws Exception {
		
	  AsmgTCodeType codetype = codeInfoService.getCodeTypeByPrimaryKey(typeCode);
	  AsmgTCodeInfo codeinfo = new AsmgTCodeInfo();
		if(codeValue != null) {
			codeinfo = codeInfoService.getCodeInfoByPrimaryKey(codeValue);
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("codetype", codetype);
		modelAndView.addObject("codeinfo", codeinfo);
		modelAndView.setViewName("codeinfo/editCodeInfoByType");
		return modelAndView;
	}
	
	/**
	 * 编辑码值类型下的码值列表提交
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @return String
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@RequestMapping("editCodeInfoByTypeSubmit")
	public String editCodeInfoByTypeSubmit(String typeCode,AsmgTCodeInfo asmgTCodeInfo) {
		if(asmgTCodeInfo.getTypeCode() == null) {
		  asmgTCodeInfo.setTypeCode(typeCode);
		}
		codeInfoService.saveCodeInfo(asmgTCodeInfo);
		return "redirect:listCodeInfoByType.do?typeCode="+typeCode;
	}
	
	/**
	 * 删除码值信息
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param codeinfo_id
	 * @return String
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
  @RequestMapping("deleteCodeInfoById")
  public String deleteCodeInfoById(@RequestParam(value = "typeCode") String typeCode, @RequestParam(value = "codeValue") String codeValue) {
    // 调用service方法删除码值类型
    try {
      codeInfoService.deleteCodeInfo(codeValue);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "forward:listCodeInfoByType.do?codetype=" + typeCode;
  }
	
	/**
	 * 通过ajax获取码值Map，初始化下拉框用
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年8月9日
	 *
	 * @param request
	 * @return
	 * @throws Exception Map<String,Object>
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@RequestMapping("getCodeInfoMap")
	@ResponseBody
	public Map<String, Object> getCodeInfoMap(HttpServletRequest request) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//通过codeInfoService获取码值信息包装类
		 List<AsmgTCodeTypeCustom> listCodeTypeCustom = codeInfoService.listCodeTypeCustom();
		//组织返回Map值
		resultMap.put("seccss", true);
		resultMap.put("data", listCodeTypeCustom);
		return resultMap;
	}
	
	
}
