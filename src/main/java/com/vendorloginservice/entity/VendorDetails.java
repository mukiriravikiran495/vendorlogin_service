package com.vendorloginservice.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "VENDOR_DETAILS")
public class VendorDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long vendor_id;
	private String v_firstName;
	private String v_lastName;
	private String v_mobile;
	private String v_email;
	
	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<VendorAddress> vendorAddress;
	
	public long getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(long vendor_id) {
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
	public VendorDetails(long vendor_id, String v_firstName, String v_lastName, String v_mobile, String v_email) {
		super();
		this.vendor_id = vendor_id;
		this.v_firstName = v_firstName;
		this.v_lastName = v_lastName;
		this.v_mobile = v_mobile;
		this.v_email = v_email;
	}
	@Override
	public String toString() {
		return "VendorDetails [vendor_id=" + vendor_id + ", v_firstName=" + v_firstName + ", v_lastName=" + v_lastName
				+ ", v_mobile=" + v_mobile + ", v_email=" + v_email + "]";
	}
	public VendorDetails() {
		
	}
	public List<VendorAddress> getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(List<VendorAddress> vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	
}
