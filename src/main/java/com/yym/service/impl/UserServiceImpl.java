package com.yym.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.yym.base.BaseResult;
import com.yym.base.ResultEnum;
import com.yym.bean.User;
import com.yym.dao.user.UserDao;
import com.yym.service.UserService;
import com.yym.utils.StringUtils;
import org.springframework.stereotype.Service;


/**
 * 用户服务接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public BaseResult register(String userPhone, int type) {
		if(StringUtils.isNullString(userPhone) || type == 0) {
			return null;
		}
		//1.判断当前用户是否被注册-老师，学生账号不可以重复
		
		int count = userDao.checkUser(userPhone);
		//如果数量大于0 说明存在该账号 提示手机号已注册
		if(count > 0) {
			return new BaseResult(ResultEnum.ACCOUNT_EXISTS);
		}
		//进行注册操作，插入用户信息
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userPhone", userPhone);
		param.put("type", type);
		userDao.saveUser(param);
		return new BaseResult();
	}

	@Override
	public User login(String userPhone, String password) {
		if(StringUtils.isNullString(userPhone) || StringUtils.isNullString(password)) {
			return null;
		}
		//判断账号密码是否正确
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userPhone", userPhone);
		param.put("password", password);
		User user = userDao.checkLogin(param);
		return user;
	}

}
