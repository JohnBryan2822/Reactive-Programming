package org.javacoders;

import java.util.function.Function;

import org.javacoders.courseUtil.Util;
import org.javacoders.helper.Person;

import reactor.core.publisher.Flux;

public class Lec11SwitchOnFirst {
	
	public static void main(String[] args) {
		
		getPerson()
			.switchOnFirst((signal, personFlux) -> {
				System.out.println("Inside switch-on-first");
				return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
			})
			.subscribe(Util.subscriber());
		
		
	}
	
	public static Flux<Person> getPerson(){
		return Flux.range(1, 10)
				.map(i -> new Person());
	}
	
	public static Function<Flux<Person>, Flux<Person>> applyFilterMap(){
		return flux -> flux
						.filter(p -> p.getAge() > 10)
						.doOnNext(p -> p.setName(p.getName().toUpperCase()))
						.doOnDiscard(Person.class, p -> System.out.println("Not Allowing : " + p));
	}

}
