package com.daou.tobytv7.sub;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MyPublisher implements Publisher<String> {
	@Override
	public void subscribe(Subscriber<? super String> subscriber) {
			Subscription subtion = new MySubscription(subscriber);
			subscriber.onSubscribe(subtion);
	}
}