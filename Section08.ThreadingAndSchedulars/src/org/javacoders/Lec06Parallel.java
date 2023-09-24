package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {
	
	public static void main(String[] args) {
		
		Flux.range(1, 10)
			.parallel(3)
			.runOn(Schedulers.parallel())
			.doOnNext(i -> printThreadName("next " + i))
			.sequential()
			.subscribe(v -> printThreadName("sub " + v));
		
		Util.sleepSeconds(5);
		
	}
	
	private static void printThreadName(String str) {
		System.out.println(str + "\t\t: Thread: " + Thread.currentThread().getName());
	}

}
