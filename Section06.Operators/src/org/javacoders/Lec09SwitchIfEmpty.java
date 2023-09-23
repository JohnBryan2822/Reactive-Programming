package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {

public static void main(String[] args) {
		
		getOrderNumbers()
			.filter(i -> i > 10)
			.switchIfEmpty(fallback()) // switching to another method or ..., if it is empty
			.subscribe(Util.subscriber());
		
	}
	
	private static Flux<Integer> getOrderNumbers(){
		return Flux.range(1, 10);
	}
	
	private static Flux<Integer> fallback(){
		return Flux.range(20, 5);
	}
	
}
