package com.sudhir.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author sudhir
 *
 */
@Entity
@Table(name = "splitter")
public class SplitterEntity {

	@Id
	@Column(name = "userName", unique = true, nullable = false)
	private String userName;
	@Column(name = "city")
	private String city;
	@Column(name = "fullName")
	private String fullName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
