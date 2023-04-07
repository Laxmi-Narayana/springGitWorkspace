package com.spring.entity;

import java.util.Objects;

public class CustomerAddress {
	private int addressId;
	private String addressName;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressId, addressName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAddress other = (CustomerAddress) obj;
		return addressId == other.addressId && Objects.equals(addressName, other.addressName);
	}
	public CustomerAddress(int addressId, String addressName) {
		super();
		this.addressId = addressId;
		this.addressName = addressName;
	}
	public CustomerAddress() {
		super();
	}
	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", addressName=" + addressName + "]";
	}
	
}
