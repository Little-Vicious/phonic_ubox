package com.zzxy.ssm.common.utils;

import java.util.Date;

public class DateUtils {
	
	
	/**
	 * 获取两个时间之间的持续时间，返回long值
	 * 
	 * @作者： 王文博
	 * @创建日期：2017年9月15日
	 *
	 * @param endTime
	 * @param startTime
	 * @return long
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	private long getDuration(Date endTime,Date startTime){
		long between = getTimeBetween(endTime, startTime);
		long day = between/(24*60*60*1000);
		long hour = (between/(60*60*1000)-day*24);
		long min = ((between/(60*1000))-day*24*60-hour*60);
		long s = (between/1000-day*24*60*60-hour*60*60-min*60);
		long ms = (between-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		
		long duration= (day*24*60*60)+(hour*60*60)+(min*600)+s;
		return duration;
	}
	
	/**
	 * 获取两个日期差，精确到毫秒
	 * @param endTime
	 * @param startTime
	 * @return
	 */
	public static long getTimeBetweenMs(Date endTime,Date startTime){
		long between = endTime.getTime() - startTime.getTime();
		return between;
	}
	
	/**
	 * 获取两个日期差，精确到秒
	 * @param endTime
	 * @param startTime
	 * @return
	 */
	public static long getTimeBetween(Date endTime,Date startTime){
		long between = endTime.getTime() - startTime.getTime();
		return between/1000;
	}
	
	/**
	 * 计算两个日期差，返回字符串
	 * @param between 两个日期差值
	 * @return
	 */
	public static String getTimeDifference (long between){
		long day = between/(24*60*60*1000);
		long hour = (between/(60*60*1000)-day*24);
		long min = ((between/(60*1000))-day*24*60-hour*60);
		long s = (between/1000-day*24*60*60-hour*60*60-min*60);
		long ms = (between-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		String timeDifference = day+"天"+hour+"小时"+min+"分"+s+"秒"+ms+"毫秒";
		return timeDifference;
	}
	
	/**
	 * 计算两个日期差，返回字符串
	 * 参数为两个日期
	 * @param endTime
	 * @param startTime
	 * @return
	 */
	public static String getDurationStr (Date endTime,Date startTime){
		return getTimeDifference(getTimeBetween(endTime, startTime));
	}
	
	public static void main(String[] args){
		Date endTime = new Date(2017, 8, 8, 20, 25, 45);
		Date startTime = new Date(2017, 8, 4, 16, 20, 34);
//		System.out.println("===="+getDuration(endTime,startTime));
		System.out.println("===="+getTimeBetween(endTime,startTime)/1000);
	}
}
