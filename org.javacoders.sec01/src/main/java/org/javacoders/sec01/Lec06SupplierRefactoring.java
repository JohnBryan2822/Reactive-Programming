package org.javacoders.sec01;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {
	
	public static void main(String[] args) {
		
		// Here we are building the pipe line,
		// we are not executing the pipe line
		// when we build pipe line it will not take time,
		// means, methods like Thread.sleep() will not be executed
		getName();
		getName();
		
		System.out.println();
		
		// if somebody subscribe to it, then it will be executed
		// Also if we write subscribeOn as below it will be executed
		// in another thread
		getName()
			.subscribeOn(Schedulers.boundedElastic())
			.subscribe(Util.onNext());
		
			// here also we have another method - block()
			// INSTEAD OF subscribe(Util.onNext())
			// which can block the main Thread
//			.block();

		getName();
		
		// here we have to block the main thread,
		// till the another thread is executed.
		Util.sleepSeconds(4);
	}
	
	private static Mono<String> getName(){
		System.out.println("Entered to getName() Method");
		
		return Mono.fromSupplier(() -> {
			System.out.println("Generating name...");
			Util.sleepSeconds(3);
			return Util.faker().name().fullName();
		}).map(String::toUpperCase);
	}

}
