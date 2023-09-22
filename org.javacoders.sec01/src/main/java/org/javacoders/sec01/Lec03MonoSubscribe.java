package org.javacoders.sec01;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
	public static void main(String[] args) {
		
		// Publisher
		Mono<String> mono = Mono.just("Ball");
		
		Mono<Integer> mono1 = Mono.just("Ball")
				.map(String::length)
				.map(l -> l/0);
		
		// 1
		mono.subscribe();
		
		// 2
		mono.subscribe(
				item -> System.out.println(item),
				err -> System.out.println(err.getMessage()),
				() -> System.out.println("Completed!")
			);
		// there was no error
		
		mono1.subscribe(
				item -> System.out.println(item),
				err -> System.out.println(err.getMessage()),
				() -> System.out.println("Completed!")
			);
		// there is an error and we have error message also
		
		// this is the same as the above, but with simple Refactor
		mono1.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete()
			);
		
		
	}
}
