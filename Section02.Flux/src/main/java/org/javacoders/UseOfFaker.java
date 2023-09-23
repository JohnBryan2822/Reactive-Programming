package org.javacoders;

import org.javacoders.courseUtil.Util;

public class UseOfFaker {
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			
			System.out.println(Util.faker().name().fullName());
			
		}
		
	}

}
