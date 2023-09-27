package org.javacoders;

import org.javacoders.courseUtil.Util;
import org.javacoders.helper.BookService;
import org.javacoders.helper.UserService;

import reactor.util.context.Context;

public class Lec03ContextRateLimiterDemo {
	
	public static void main(String[] args) {
		
		BookService.getbook()
				.repeat(2)
				.contextWrite(UserService.userCategoryContext())
				.contextWrite(Context.of("user", "mike"))
				.subscribe(Util.subscriber());
		
		
		
	}

}
