package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
	
	public static void main(String[] args) {
		
		// generate method will run infinite times
		// if you want to stop it, here are several ways
		Flux.generate(synchronousSink -> {
			
			System.out.println("Emmitting");
			synchronousSink.next(Util.faker().country().name()); // Only 1
			synchronousSink.complete(); // if you want to complete infinite loop
			synchronousSink.error(new RuntimeException("Something went wrong")); // if you want to rise an exception
			
		})
		.take(3) // if you want to generate N number of times
		.subscribe(Util.subscriber());
		
	}

}
