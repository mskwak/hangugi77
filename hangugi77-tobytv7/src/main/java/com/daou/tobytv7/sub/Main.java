package com.daou.tobytv7.sub;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Main {
	public static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		Publisher publisher = new MyPublisher();
		Subscriber subscriber = new MySubscriber();
		Subscriber subscriberOperator = new SubscriberOperator(subscriber);
		publisher.subscribe(subscriberOperator);
		logger.info("main exit...");
	}
}