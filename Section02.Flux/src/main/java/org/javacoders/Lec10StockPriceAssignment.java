package org.javacoders;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

import org.javacoders.assignment.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Lec10StockPriceAssignment {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(1);
		
		StockPricePublisher.getPrice()
				.subscribeWith(new Subscriber<Integer>() {
					
					private Subscription subscription;

					@Override
					public void onSubscribe(Subscription subscription) {
						this.subscription = subscription;
						subscription.request(Long.MAX_VALUE);
					}

					public void onNext(Integer price) {
						System.out.println(LocalDateTime.now() + " : Price : " + price);
						if(price > 110 || price < 90) {
							this.subscription.cancel();
							latch.countDown();
						}
					}

					@Override
					public void onError(Throwable t) {
						latch.countDown();
					}

					@Override
					public void onComplete() {
						latch.countDown();
					}
				});
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
