package com.vendorloginservice.domain;

import java.util.List;


public class VendorDetailsDTO {

	private String vendor_id;
	private String v_firstName;
	private String v_lastName;
	private String v_mobile;
	private String v_email;
	private VendorAddressDTO vendorAddress;
	public String getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getV_firstName() {
		return v_firstName;
	}
	public void setV_firstName(String v_firstName) {
		this.v_firstName = v_firstName;
	}
	public String getV_lastName() {
		return v_lastName;
	}
	public void setV_lastName(String v_lastName) {
		this.v_lastName = v_lastName;
	}
	public String getV_mobile() {
		return v_mobile;
	}
	public void setV_mobile(String v_mobile) {
		this.v_mobile = v_mobile;
	}
	public String getV_email() {
		return v_email;
	}
	public void setV_email(String v_email) {
		this.v_email = v_email;
	}
	public VendorAddressDTO getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(VendorAddressDTO vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	
	
	
}
