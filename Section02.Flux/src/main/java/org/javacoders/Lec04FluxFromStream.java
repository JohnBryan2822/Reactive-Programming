package org.javacoders;

import java.util.List;
import java.util.stream.Stream;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec04FluxFromStream {
	
	public static void main(String[] args) {
		
		List<Integer> list = List.of(1, 2, 3, 4, 5);
		Stream<Integer> stream = list.stream();
		
		// we can iterate stream only one time
//		stream.forEach(System.out::println); // Closed
//		stream.forEach(System.out::println); // Exception: stream has already been operated upon or closed
		
		// same if we use Flux
//		Flux<Integer> integerFlux = Flux.fromStream(stream);
		
		// it will work if we write like this
		Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream());
		
		integerFlux.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete());
		
		// Even this time we cannot use that
		integerFlux.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete());
		
	}
	
}
