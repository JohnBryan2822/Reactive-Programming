package org.javacoders;

import java.util.List;

import org.javacoders.courseUtil.Util;
import org.javacoders.helper.NameGenerator;

public class Lec07FluxVsList {

	public static void main(String[] args) {
		
		
		// here I have to wait to see the full answer
		List<String> names = NameGenerator.getNames(5);
		System.out.println(names);
		
		NameGenerator.getNamesByFlux(5).subscribe(Util.onNext());
		
		
	}
	
	
}
