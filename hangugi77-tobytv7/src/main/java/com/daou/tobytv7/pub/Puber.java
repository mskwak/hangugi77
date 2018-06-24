package com.daou.tobytv7.pub;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Puber implements Publisher<String> {
	@Override
	public void subscribe(Subscriber<? super String> subscriber) {
			Subscription subtion = new Subtion(subscriber);
			subscriber.onSubscribe(subtion);
	}
}