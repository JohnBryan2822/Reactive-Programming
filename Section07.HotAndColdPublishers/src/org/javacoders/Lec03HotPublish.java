package org.javacoders;

import java.time.Duration;
import java.util.stream.Stream;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec03HotPublish {
	public static void main(String[] args) {
		
		// share() = publish().refCount(1)
		Flux<String> movieStream = Flux.fromStream(() -> getMovie())
				.delayElements(Duration.ofSeconds(1))
				.publish()
				.refCount(1);
		
		movieStream.subscribe(Util.subscriber("sam"));
		
		Util.sleepSeconds(10);
		
		movieStream.subscribe(Util.subscriber("mike"));
		
		Util.sleepSeconds(60);
		
	}
	
	
	
	
	
	// Movie-theater
	private static Stream<String> getMovie(){
		System.out.println("Got the movie streaming req");
		return Stream.of("Scene 1", "Scene 2", "Scene 3", "Scene 4", "Scene 5", "Scene 6", "Scene 7");
	}
}
