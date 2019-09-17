package com.yym.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.yym.base.BaseResult;
import com.yym.base.ResultEnum;
import com.yym.bean.User;
import com.yym.service.UserService;
import com.yym.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制类 
 */
@Controller
@RequestMapping("/api/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param userPhone 注册电话
	 * @param type 注册类型 1学生 2老师
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object register(HttpServletRequest request, HttpServletResponse response, String userPhone, int type) {
		//如果传入用户电话为空 返回参数错误
		if(StringUtils.isNullString(userPhone)) {
			return new BaseResult(ResultEnum.PARAMTER_ERROR);
		}
		//对传入数据进行去除空格
		userPhone = StringUtils.trimAllStr(userPhone);
		//查看是否为有效输入手机号

		if(!StringUtils.isLegalPhone(userPhone)) {
			 return new BaseResult(ResultEnum.ILLEGAL_PHONE);
		}
		if(!StringUtils.isMobileNO(userPhone)) {
			 return new BaseResult(ResultEnum.ERROR_PHONE);
		}
		//注册操作
		 BaseResult result = userService.register(userPhone,type);
		 if(result == null) {
			 return new BaseResult(ResultEnum.REGISTER_ERROR);
		 }
		 return result;
	}
	
	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @param userPhone 账号
	 * @param password 密码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(HttpServletRequest request, HttpServletResponse response, String userPhone, String password) {
		//如果传入用户电话为空 返回参数错误
		if(StringUtils.isNullString(userPhone) || StringUtils.isNullString(password)) {
			return new BaseResult(ResultEnum.PARAMTER_ERROR);
		}
		
		User user = userService.login(userPhone,password);
		if(user == null) {
			return new BaseResult(ResultEnum.LOGIN_FAIL);
		}
		//将登陆信息存放到session中
		HttpSession session =request.getSession();
		session.setAttribute(userPhone, user);
		//设置session存活时间为2小时
		session.setMaxInactiveInterval(2 * 3600);
		return new BaseResult();
	}
}
