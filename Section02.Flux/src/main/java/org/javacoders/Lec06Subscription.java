package org.javacoders;

import java.util.concurrent.atomic.AtomicReference;

import org.javacoders.courseUtil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;

public class Lec06Subscription {

	public static void main(String[] args) {
		
		AtomicReference<Subscription> atomicReference = new AtomicReference<Subscription>();
		
		Flux.range(1, 20)
			.log()
			.subscribeWith(new Subscriber<Integer>() {
	
				@Override
				public void onSubscribe(Subscription s) {
					System.out.println("Received Sub : "  + s);
					atomicReference.set(s);
				}
	
				@Override
				public void onNext(Integer i) {
					System.out.println("onNext : " + i);
				}
	
				@Override
				public void onError(Throwable t) {
					System.out.println("onError : " + t.getMessage());
				}
	
				@Override
				public void onComplete() {
					System.out.println("onComplete");
				}				
			});
		
		
		Util.sleepSeconds(3);
		atomicReference.get().request(3);
		Util.sleepSeconds(5);
		atomicReference.get().request(3);
		Util.sleepSeconds(5);
		System.out.println("going to cancel");
		atomicReference.get().cancel();
		Util.sleepSeconds(3);
		atomicReference.get().request(4);
		
		Util.sleepSeconds(3);
		
	}
	
}















