package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
	public static void main(String[] args) {
		
		Flux<Integer> flux = Flux.just(1, 2, 3, 4);
		Flux<Object> flux1 = Flux.just(1, 2, 3, "a", 4, Util.faker().name().fullName());
		
		flux.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete());
		
		System.out.println();
		flux1.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete());
		
	}
}
