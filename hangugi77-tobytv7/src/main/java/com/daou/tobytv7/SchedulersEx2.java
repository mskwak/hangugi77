package com.daou.tobytv7;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class SchedulersEx2 {
	public static Logger logger = LoggerFactory.getLogger(SchedulersEx2.class);

	public static void main(String[] args) {
		Publisher publisher = new Pub();
		Subscriber subscriber = new Sub();
		publisher.subscribe(subscriber);
	}
}