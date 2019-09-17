package com.yym.base;


public class BaseResult extends BaseBean{

	private static final long serialVersionUID = 2957812249485022977L;
	
	private long code;
	
	private String reason;
	
	private long dateTime;
	
	private Object result;
	

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

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	public BaseResult() {
		this.code = ResultEnum.SUCCESS.getCode();
		this.reason = ResultEnum.SUCCESS.getReason();
		this.dateTime = System.currentTimeMillis();
	}
	
	public BaseResult(ResultEnum resultEnum) {
		if(resultEnum != null) {
			this.code = resultEnum.getCode();
			this.reason = resultEnum.getReason();
		}else {
			this.code = ResultEnum.ERROR.getCode();
			this.reason = ResultEnum.ERROR.getReason();
		}
		this.dateTime = System.currentTimeMillis();
	}
	
	public BaseResult(Object result) {
		this.result = result;
		this.code = ResultEnum.SUCCESS.getCode();
		this.reason = ResultEnum.SUCCESS.getReason();
		this.dateTime = System.currentTimeMillis();
	}
	public BaseResult(Object result,long code, String reason) {
		this.result = result;
		this.code = code;
		this.reason = reason;
		this.dateTime = System.currentTimeMillis();
	}
}
