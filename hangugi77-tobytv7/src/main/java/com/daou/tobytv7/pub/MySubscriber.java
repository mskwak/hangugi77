package com.daou.tobytv7.pub;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySubscriber implements Subscriber<String> {
	private Logger logger = LoggerFactory.getLogger(MySubscriber.class);

	@Override
	public void onSubscribe(Subscription s) {
		logger.info("MySubscriber.onSubscribe()");
		s.request(Long.MAX_VALUE);
	}

	@Override
	public void onNext(String string) {
		logger.info("MySubscriber.onNext()" + ":" + string);
	}

	@Override
	public void onError(Throwable t) {
		logger.info("MySubscriber.onError()");
	}

	@Override
	public void onComplete() {
		logger.info("MySubscriber.onComplete()");
	}
}
