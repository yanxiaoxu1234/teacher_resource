package com.yym.bean;

/**
 * 用户类型枚举类
 *
 */
public enum UserType {
	Student(1,"学生"),
	Teacher(2,"老师");
	
	private int type;
	
	private String name;

	private UserType(int type,String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
