package org.javacoders.helper;

import org.javacoders.courseUtil.Util;

public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		this.name = Util.faker().name().firstName();
		this.age = Util.faker().random().nextInt(1, 30);
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
