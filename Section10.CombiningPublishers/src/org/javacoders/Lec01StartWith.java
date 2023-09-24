package org.javacoders;

import org.javacoders.courseUtil.Util;
import org.javacoders.helper.NameGenerator;

public class Lec01StartWith {
	
	public static void main(String[] args) {
		
		NameGenerator generator = new NameGenerator();
		
		generator.generatNames()
			.take(2)
			.subscribe(Util.subscriber("Sam"));
		
		generator.generatNames()
			.take(2)
			.subscribe(Util.subscriber("Mike"));
		
		generator.generatNames()
			.take(3)
			.subscribe(Util.subscriber("Ted"));
		
		generator.generatNames()
			.filter(n -> n.startsWith("A"))
			.take(4)
			.subscribe(Util.subscriber("John"));
		
	}

}
