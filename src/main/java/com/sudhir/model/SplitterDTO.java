package com.sudhir.model;

public class SplitterDTO {
	private String userName;
	private String city;
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

	@Override
	public String toString() {
		return "[userName:" + userName + " ,city:" + city + " ," + fullName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SplitterDTO)) {
			return false;
		}
		SplitterDTO splitterDTO = (SplitterDTO) obj;
		return (userName == splitterDTO.userName || userName != null && userName.equals(splitterDTO.getUserName()))
				&& (city == splitterDTO.city || city != null && city.equals(splitterDTO.city))
				&& (fullName == splitterDTO.fullName || fullName != null && fullName.equals(splitterDTO.fullName));
	}
}
