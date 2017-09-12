package com.zzxy.ssm.common.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	//单个外呼状态 [CALLOUT.STATUS 0-未完成1-已完成无效2-已完成有效]
	public static final int CALLOUT_STATUS_UNFINISH = 0;
	public static final int CALLOUT_STATUS_UNEFFECTIVE = 1;
	public static final int CALLOUT_STATUS_EFFECTIVE = 2;
	
	public static Map<Integer, String> mapCallout_Status = new HashMap<Integer, String>();
	static{
		mapCallout_Status.put(CALLOUT_STATUS_UNFINISH, "未完成");
		mapCallout_Status.put(CALLOUT_STATUS_UNEFFECTIVE, "已完成无效");
		mapCallout_Status.put(CALLOUT_STATUS_EFFECTIVE, "已完成有效");
	}
	
	public static String getCallout_Status_Label(Integer status){
		return mapCallout_Status.get(status);
	}
	
	//默认码值
	public static final String ASMG_T_CODE_INFO_ISDEL_YES = "20000001";
	public static final String ASMG_T_CODE_INFO_ISDEL_NO = "20000002";
	
	//活动量类型
  public static final String ASMG_T_CODE_INFO_BATCHTYPE_OPPO = "00020001";
  public static final String ASMG_T_CODE_INFO_BATCHTYPE_NOTICE = "00020002";
  public static final String ASMG_T_CODE_INFO_BATCHTYPE_CLIENTS = "00020003";
  public static final String ASMG_T_CODE_INFO_BATCHTYPE_ACTIVITY = "00020004";
  
  //是否主要电话
  public static final int APRB_T_CUSTOMER_NUMBER_MAIN_YES = 1;
  public static final int APRB_T_CUSTOMER_NUMBER_MAIN_NO = 0;
}
