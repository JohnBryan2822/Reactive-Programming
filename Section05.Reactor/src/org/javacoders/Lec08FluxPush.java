package org.javacoders;

import org.javacoders.courseUtil.Util;
import org.javacoders.helper.NameProducer;

import reactor.core.publisher.Flux;

public class Lec08FluxPush {

	public static void main(String[] args) {
		
		NameProducer nameProducer = new NameProducer();
		
		// push is almost the same as create
		// but push is not thread safe !!!
		// if you run this code several times, you may see
		// some thread may be missing
		Flux.push(nameProducer)
			.subscribe(Util.subscriber());
		
		Runnable runnable = nameProducer::produce;
		
		for (int i = 0; i < 10; i++) {
			new Thread(runnable).start();
		}
		
		Util.sleepSeconds(2);	
		
	}
	
}
