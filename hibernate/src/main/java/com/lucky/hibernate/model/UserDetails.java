package com.lucky.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails 
	{
	@Id  @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name")
	private String userName;
	/*
	@OneToMany
	@JoinTable(name="user_mobile",joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name = "mobile_id")
	)
	*/
	@OneToMany(mappedBy = "userDetails")
	private Collection<Mobile> mobile = new ArrayList<Mobile>();
	
	public Collection<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(Collection<Mobile> mobile) {
		this.mobile = mobile;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
