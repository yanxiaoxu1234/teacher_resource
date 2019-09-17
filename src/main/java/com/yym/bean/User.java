package com.yym.bean;


import com.yym.base.BaseBean;

/**
 * 用户bean类
 */
public class User extends BaseBean {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -3733721394539418627L;

	/**
	 * 主键Id
	 */
	private long userId;
	
	/**
	 * 账号
	 */
	private String account;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 用户类型
	 */
	private int userType;
	
}
