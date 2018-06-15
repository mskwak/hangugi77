package com.daou.tobytv7;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Pub implements Publisher<String> {
	@Override
	public void subscribe(Subscriber<? super String> subscriber) {
		Subscription subscription = new Subtion(subscriber);
		subscriber.onSubscribe(subscription);
	}
}
