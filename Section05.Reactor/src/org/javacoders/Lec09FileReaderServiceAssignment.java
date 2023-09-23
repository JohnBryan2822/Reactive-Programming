package org.javacoders;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.javacoders.assignment.FileReaderService;
import org.javacoders.courseUtil.Util;

public class Lec09FileReaderServiceAssignment {
	
	public static void main(String[] args) {
		
		FileReaderService readerService = new FileReaderService();
		
		Path path = Paths.get("src/org/javacoders/assignment/file01.txt");
		
		readerService.read(path)
			.take(20) // if you want to get N number of lines
			.subscribe(Util.subscriber());
		
	}

}
