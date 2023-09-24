package org.javacoders.helper;

import java.time.Duration;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class AmericanAirlines {
	
	public static Flux<String> getFlights(){
		return Flux.range(1, Util.faker().random().nextInt(1, 10))
					.delayElements(Duration.ofSeconds(1))
					.map(i -> "AA " + Util.faker().random().nextInt(100, 999))
					.filter(i -> Util.faker().random().nextBoolean());
	}

}
