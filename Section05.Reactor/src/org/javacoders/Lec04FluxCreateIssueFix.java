package org.javacoders;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class Lec04FluxCreateIssueFix {

	public static void main(String[] args) {
		
		// only one instance of fluxsink
		Flux.create(fluxSink -> {
			String country;
			do {
				
				country = Util.faker().country().name();
				System.out.println("Emmitting : " + country);
				fluxSink.next(country);
				
			} while(!country.toLowerCase().equals("canada") && !fluxSink.isCancelled());
			
			fluxSink.complete();
		}).take(10).subscribe(Util.subscriber());
		
	}
	
}
