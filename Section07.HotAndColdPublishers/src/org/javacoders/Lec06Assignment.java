package org.javacoders;

import org.javacoders.assignment.InventoryService;
import org.javacoders.assignment.OrderService;
import org.javacoders.assignment.RevenueService;
import org.javacoders.courseUtil.Util;

public class Lec06Assignment {
	
	public static void main(String[] args) {
		
		OrderService orderService = new OrderService();
		RevenueService revenueService = new RevenueService();
		InventoryService inventoryService = new InventoryService();
		
		orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
		orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());
		
		inventoryService.inventoryStream()
				.subscribe(Util.subscriber("inventory"));
		
		revenueService.revenueStream()
				.subscribe(Util.subscriber("revenue"));
		
		Util.sleepSeconds(60);
		
		
	}

}
