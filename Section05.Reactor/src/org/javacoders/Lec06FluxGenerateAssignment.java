package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {
	
	public static void main(String[] args) {
		
		// canada
		// max = 10
		// subscriber cancels - exit
		
		Flux.generate(synchronousSink -> {
			
			String country = Util.faker().country().name();
			System.out.println("Emmitting : " + country);
			synchronousSink.next(country);
			if(country.toLowerCase().equals("canada")) {
				synchronousSink.complete();
			}
			
		}).subscribe(Util.subscriber());
		
	}

}
