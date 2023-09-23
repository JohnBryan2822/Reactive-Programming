package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec04LimitRate {

	public static void main(String[] args) {
		
		Flux.range(1, 1000)
			.log()
			.limitRate(100) // default: 75%
			.subscribe(Util.subscriber());
		
	}
	
}
