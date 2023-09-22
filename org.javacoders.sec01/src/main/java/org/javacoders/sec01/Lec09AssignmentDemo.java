package org.javacoders.sec01;

import org.javacoders.courseUtil.Util;
import org.javacoders.sec01.assignment.FileService;

public class Lec09AssignmentDemo {
	public static void main(String[] args) {
		
		// Reading from a file
		FileService.read("file03.txt")
			.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
		
		// Deleting a file
//		FileService.delete("file03.txt")
//			.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
		
		
		// Writing to a file or Creating and writing
//		FileService.write("file03.txt", "This is a file 03")
//			.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
		
	}
}
