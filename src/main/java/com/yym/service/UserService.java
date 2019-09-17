package com.yym.service;

import com.yym.base.BaseResult;
import com.yym.bean.User;

/**
 * 
 * 用户服务接口
 */
public interface UserService {

	/**
	 * 注册
	 * @param userPhone 用户电话
	 * @param type 类型
	 * @return
	 */
	public BaseResult register(String userPhone, int type);

	/**
	 * 登陆
	 * @param userPhone 账号
	 * @param password 密码
	 * @return
	 */
	public User login(String userPhone, String password);
}
