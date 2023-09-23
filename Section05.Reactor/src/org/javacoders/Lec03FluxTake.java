package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec03FluxTake {

	public static void main(String[] args) {
		
		// There are several operators like map or filter
		// another one is take()
		Flux.range(1, 10)
			.log()
			.take(3) // cancels
			.log()
			.subscribe(Util.subscriber(null));
		
	}
	
}
