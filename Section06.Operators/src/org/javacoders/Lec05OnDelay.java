package org.javacoders;

import java.time.Duration;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec05OnDelay {
	
	public static void main(String[] args) {
		
		System.setProperty("reactor.bufferSize.x", "9"); // actual size was 32
		
		Flux.range(1, 100) // default queue size 32
			.log()
			.delayElements(Duration.ofSeconds(1))
			.subscribe(Util.subscriber());
		
		Util.sleepSeconds(11);
	}

}
