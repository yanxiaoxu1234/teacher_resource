package com.yym.base;

public enum ResultEnum {
	SUCCESS(1000,"请求成功"),
	PARAMTER_ERROR(1001,"请求参数错误"),
	ACCOUNT_IS_NULL(1002,"账号不能为空"),
	PASSWORD_IS_NULL(1003,"密码不能为空"),
	LOGIN_FAIL(1004,"登陆失败，账号或密码错误"),
	NOT_LOGIN(1005,"未登录"),
	ILLEGAL_PHONE(1006,"请输入有效手机号"),
	ERROR_PHONE(1007,"非大陆手机号不能注册"),
	REGISTER_ERROR(1008,"注册失败"),
	ACCOUNT_EXISTS(1009,"该手机已被注册"),
	ERROR(9999,"操作失败，请稍后重试");
	private long code;
	private String reason;
	
	private ResultEnum(long code,String reason) {
		this.code = code;
		this.reason = reason;
	}
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
