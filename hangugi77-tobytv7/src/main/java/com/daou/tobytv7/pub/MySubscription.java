package com.daou.tobytv7.pub;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySubscription implements Subscription {
	private static Logger logger = LoggerFactory.getLogger(MySubscription.class);
	private Subscriber sub;

	public MySubscription(Subscriber sub) {
		logger.info("MySubscription.constructor");
		this.sub = sub;
	}

	@Override
	public void request(long n) {
		logger.info("MySubscription.request()");
		sub.onNext("1");
		sub.onNext("2");
		sub.onNext("3");
		sub.onNext("4");
		sub.onNext("5");
		sub.onComplete();
	}

	@Override
	public void cancel() {
		logger.info("MySubscription.cancel()");
	}
}
