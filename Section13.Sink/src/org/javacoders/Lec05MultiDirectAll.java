package org.javacoders;

import java.time.Duration;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec05MultiDirectAll {
	
	public static void main(String[] args) {
		
		System.getProperty("reactor.bufferSize.small", "16");
		
		Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();
		
		Flux<Object> flux = sink.asFlux();

		flux.subscribe(Util.subscriber("Sam"));
		flux.delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("Mike"));
		
		for (int i = 0; i < 100; i++) {
			sink.tryEmitNext(i);
			
		}
		
		Util.sleepSeconds(10);
	}

}
