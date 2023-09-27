package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02SinkUnicast {
	
	public static void main(String[] args) {
		
		// handle through which we would push items
		Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();
		
		// handle through subscribers will receive items
		Flux<Object> flux = sink.asFlux();
		
		flux.subscribe(Util.subscriber("Sam"));
		
		// by unicast() method only one subscriber can subscribe
		flux.subscribe(Util.subscriber("Mike"));
		
		sink.tryEmitNext("Hi");
		sink.tryEmitNext("Hello");
		sink.tryEmitNext("?");
		
		
		
	}
	

}
