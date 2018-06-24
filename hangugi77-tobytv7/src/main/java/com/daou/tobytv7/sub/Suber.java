package com.daou.tobytv7.sub;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Suber implements Subscriber<String> {
	private Logger logger = LoggerFactory.getLogger(Suber.class);

	@Override
	public void onSubscribe(Subscription s) {
		logger.info("Suber.onSubscribe()");
		s.request(Long.MAX_VALUE);
	}

	@Override
	public void onNext(String string) {
		logger.info("Suber.onNext()" + ":" + string);
	}

	@Override
	public void onError(Throwable t) {
		logger.info("Suber.onError()");
	}

	@Override
	public void onComplete() {
		logger.info("Suber.onComplete()");
	}
}
