package org.javacoders;

import java.time.Duration;
import java.util.stream.Stream;

import org.javacoders.courseUtil.Util;

import reactor.core.publisher.Flux;

public class Lec05HotPublishCache {
	public static void main(String[] args) {
		
		// cache = publish().replay()
		Flux<String> movieStream = Flux.fromStream(() -> getMovie())
				.delayElements(Duration.ofSeconds(1))
				.cache(3);
		
		Util.sleepSeconds(2);
		
		movieStream.subscribe(Util.subscriber("sam"));
		
		Util.sleepSeconds(10);
		
		System.out.println("Mike is about to joining");
		
		movieStream.subscribe(Util.subscriber("mike"));
		
		Util.sleepSeconds(60);
		
	}
	
	
	
	
	
	// Movie-theater
	private static Stream<String> getMovie(){
		System.out.println("Got the movie streaming req");
		return Stream.of("Scene 1", "Scene 2", "Scene 3", "Scene 4", "Scene 5", "Scene 6", "Scene 7");
	}
}
