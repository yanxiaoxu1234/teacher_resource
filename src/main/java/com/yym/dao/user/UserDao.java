package com.yym.dao.user;

import java.util.Map;

import com.yym.bean.User;
import org.springframework.stereotype.Repository;


/**
 * 用户Dao层接口  
 */
@Repository
public interface UserDao {

	/**
	 * 检查用户是否已被注册
	 * @param userPhone 用户电话
	 * @return
	 */
	int checkUser(String userPhone);

	/**
	 * 保存用户信息
	 * @param param
	 */
	void saveUser(Map<String, Object> param);

	/**
	 * 检查登陆信息是否正确
	 * @param param
	 * @return
	 */
	User checkLogin(Map<String, Object> param);

}
