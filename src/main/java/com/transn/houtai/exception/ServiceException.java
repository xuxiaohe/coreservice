package com.transn.houtai.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3399692979111139909L;
	private int code;
	private String message;
	
	public ServiceException(int code, Throwable cause) {
		this.code=code;
    }
	
	public ServiceException(int code, String message, Throwable cause){
		this.code=code;
		this.message=message;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return super.toString();
	}
}
