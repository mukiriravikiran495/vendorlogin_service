package com.vendorloginservice.domain;

import java.io.Serializable;

public class SendOTPRequest implements Serializable{
	
	private static final long serialVersionUID = -7018178304185904643L;
	private long vendor_id;
	private String vendor_name;
	private String mobile;
	private String email;
	private String otp;
//	private StatusHandler statusHandler;
	public long getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(long vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "SendOTPRequest [vendor_id=" + vendor_id + ", vendor_name=" + vendor_name + ", mobile=" + mobile
				+ ", email=" + email + ", otp=" + otp + "]";
	}
	public SendOTPRequest(long vendor_id, String vendor_name, String mobile, String email, String otp) {
		super();
		this.vendor_id = vendor_id;
		this.vendor_name = vendor_name;
		this.mobile = mobile;
		this.email = email;
		this.otp = otp;
	}
	public SendOTPRequest() {
		
	}
}
