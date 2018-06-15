package com.daou.tobytv7;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Subtion implements Subscription {
	private Subscriber sub;

	public Subtion(Subscriber sub) {
		this.sub = sub;
	}

	@Override
	public void request(long n) {
		sub.onNext("1");
		sub.onNext("2");
		sub.onNext("3");
		sub.onNext("4");
		sub.onNext("5");
		sub.onComplete();
	}

	@Override
	public void cancel() {

	}
}
