package org.javacoders;

import java.time.Duration;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec01Buffer {

	public static void main(String[] args) {
		
		evenStream()
			// by number of elements
//			.buffer(5)
			
			// by timeout
//			.buffer(Duration.ofSeconds(2))
		
			// by both of them
			// which one will be first, 5 elements or 2 seconds
			.bufferTimeout(5, Duration.ofSeconds(2))
			
			.subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);
		
	}
	
	private static Flux<String> evenStream(){
		return Flux.interval(Duration.ofMillis(300))
				// agar 5 dan kam element jo'natilsa, faqat ular bufferga kiritiladi va compete
//				.take(3)
				.map(i -> "even " + i);
	}
	
	
}