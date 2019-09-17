package com.yym.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符工具类 
 */
public class StringUtils {
	/**
	  * 判断传入字符串是否为空
	  * @param str
	  * @return
	  */
	 public static boolean isNullString(String str) {
		if(str == null || str.length() == 0){
			return true;
		}
		return false;
	}
	 
	 /**
	  * 检测手机号格式是否正确
	  * @param mobile
	  * @return
	  */
	public static boolean isLegalPhone(String userPhone) {
		if(isNullString(userPhone)) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");  
       Matcher isNum = pattern.matcher(userPhone);  
       if (!isNum.matches()) {  
           return false;  
       }  
       return true; 
	}
	 
	 /**
	  * 检测手机号格式是否为大陆手机号
	  * @param mobile
	  * @return
	  */
	public static boolean isMobileNO(String userPhone) {
		if(isNullString(userPhone)) {
			return false;
		}
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(userPhone);
		return m.matches();
	}
	/**
	 * 去除字符串中所有空格
	 * @param mobile
	 * @return
	 */
	public static  String trimAllStr(String str) {
		if(isNullString(str)) {
			return null;
		}
		str = str.replaceAll(" ", "");
		return str;
	}
}
