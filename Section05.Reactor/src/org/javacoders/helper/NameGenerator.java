package org.javacoders.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class NameGenerator {
	
	/**
	 * here we are returning List of items
	 * @param count
	 * @return
	 */
	public static List<String> getNames(int count){
		List<String> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			list.add(getName());
		}
		return list;
	}
	
	
	
	/**
	 * Here we are returning Flux of items
	 * @return
	 */
	public static Flux<String> getNamesByFlux(int count){
		return Flux.range(0, count).map(i -> getName());
		
	}
	
	
	
	
	
	private static String getName() {
		Util.sleepSeconds(1);
		return Util.faker().name().fullName();
	}
	
}
