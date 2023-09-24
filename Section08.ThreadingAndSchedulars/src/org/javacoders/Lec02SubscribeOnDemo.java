package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemo {
	
	public static void main(String[] args) {
		
		Flux<Object> flux = Flux.create(fluxSink -> {
			printThreadName("create");
			fluxSink.next(1);
		})
		.subscribeOn(Schedulers.newParallel("vins"))
		.doOnNext(i -> printThreadName("next " + i));
		
		Runnable runnable = () -> flux
									.doFirst(() -> printThreadName("first2"))
									.subscribeOn(Schedulers.boundedElastic())
									.doFirst(() -> printThreadName("first1"))
									.subscribe(v -> printThreadName("sub " + v));
		
		for (int j = 0; j < 2; j++) {
			new Thread(runnable).start();
		}
		
		Util.sleepSeconds(5);
		
	}
	
	private static void printThreadName(String str) {
		System.out.println(str + "\t\t: Thread: " + Thread.currentThread().getName());
	}

}
