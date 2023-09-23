package org.javacoders.helper;

import org.javacoders.courseUtil.Util;

public class User {
	private String name;
	private int userId;
	
	public User(int userId) {
		this.userId = userId;
		this.name = Util.faker().name().fullName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", userId=" + userId + "]";
	}
	
}
