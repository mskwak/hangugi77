package com.daou.tobytv7;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Sub implements Subscriber<String> {
	@Override
	public void onSubscribe(Subscription s) {
		s.request(Long.MAX_VALUE);
	}

	@Override
	public void onNext(String string) {
		System.out.println(Thread.currentThread().getName() + ": " + string);
	}

	@Override
	public void onError(Throwable t) {

	}

	@Override
	public void onComplete() {

	}
}
