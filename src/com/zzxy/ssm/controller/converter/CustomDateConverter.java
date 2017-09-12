package com.zzxy.ssm.controller.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换工具
 * 
 * @工程： SpringMVC学习
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017-1-4
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class CustomDateConverter implements Converter<String, Date>{

	public Date convert(String source) {
		//将字符串类型转换为日期类型，格式（"yyyy-MM-dd hh:mm:ss"）
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			//转换成功直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			//转换失败抛出异常
			e.printStackTrace();
		}
		//转换失败返回空
		return null;
	}
	
	public String convertToStr(Date date, String type) {
		String str = null;  
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        if (type.equals("SHORT")) {  
            // 07-1-18  
            format = DateFormat.getDateInstance(DateFormat.SHORT);  
            str = format.format(date);  
        } else if (type.equals("MEDIUM")) {  
            // 2007-1-18  
            format = DateFormat.getDateInstance(DateFormat.MEDIUM);  
            str = format.format(date);  
        } else if (type.equals("FULL")) {  
            // 2007年1月18日 星期四  
            format = DateFormat.getDateInstance(DateFormat.FULL);  
            str = format.format(date);  
        }  
        return str;
	}


}
