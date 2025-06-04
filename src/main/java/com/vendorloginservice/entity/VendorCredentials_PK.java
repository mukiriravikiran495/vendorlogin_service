package com.vendorloginservice.entity;

import java.io.Serializable;

public class VendorCredentials_PK implements Serializable{
	
	private static final long serialVersionUID = 2074033012373985128L;
	private long vendor_id;
	private String mobile;
	public long getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(long vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public VendorCredentials_PK(long vendor_id, String mobile) {
		super();
		this.vendor_id = vendor_id;
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "VendorCredentials_PK [vendor_id=" + vendor_id + ", mobile=" + mobile + "]";
	}
	public VendorCredentials_PK() {
		
	}
	
	
}
