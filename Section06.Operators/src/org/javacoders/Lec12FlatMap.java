package org.javacoders;

import org.javacoders.courseUtil.Util;
import org.javacoders.helper.OrderService;
import org.javacoders.helper.UserService;

public class Lec12FlatMap {
	
	public static void main(String[] args) {
		
		UserService.getUsers()
				.flatMap(user -> OrderService.getOrders(user.getUserId())) // flatMap(), if return type is mono / flux
				.subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);
		
	}

}
