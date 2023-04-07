package com.spring.entity;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Customer {
	private int customerId;
	private String customerName;
	private List<CustomerAddress>  customerAddress = new ArrayList<CustomerAddress>();
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<CustomerAddress>getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public Customer() {
		super();
	}
	public Customer(int customerId, String customerName, List<CustomerAddress> customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerAddress, customerId, customerName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerAddress, other.customerAddress) && customerId == other.customerId
				&& Objects.equals(customerName, other.customerName);
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + "]";
	}
	
}
