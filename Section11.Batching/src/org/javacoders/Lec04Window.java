package org.javacoders;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec04Window {
	
	private static AtomicInteger atomicInteger = new AtomicInteger(1);
	
	public static void main(String[] args) {
		
		eventStream()
			
			// we have also this way
//			.window(Duration.ofSeconds(2))
			
			.window(5)
			.flatMap(flux -> saveEvents(flux))
			.subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);
		
	}
	
	private static Flux<String> eventStream(){
		return Flux.interval(Duration.ofMillis(500))
				.map(i -> "event" + i);
	}
	
	private static Mono<Integer> saveEvents(Flux<String> flux){
		return flux
				.doOnNext(e -> System.out.println("Saving " + e))
				.doOnComplete(() -> {
					System.out.println("Saved this batch");
					System.out.println("-------------------");
				})
				.then(Mono.just(atomicInteger.getAndIncrement()));
	}

}
