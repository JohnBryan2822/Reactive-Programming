package org.javacoders;

import java.time.Duration;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec02OverlapAndDrop {
	
public static void main(String[] args) {
		
		evenStream()
			
			.buffer(3, 2)
			.subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);
		
	}
	
	private static Flux<String> evenStream(){
		return Flux.interval(Duration.ofMillis(300))
				.map(i -> "even " + i);
	}

}
