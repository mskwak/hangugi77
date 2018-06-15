package com.daou.tobytv7;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SchedulersEx {
	public static Logger logger = LoggerFactory.getLogger(SchedulersEx.class);

	public static void main(String[] args) {
//		Publisher<Integer> pub = new Publisher<Integer>() {
//			@Override
//			public void subscribe(Subscriber<? super Integer> sub) {
//				sub.onSubscribe(new Subscription() {
//					@Override
//					public void request(long n) {
//						sub.onNext(1);
//						sub.onNext(2);
//						sub.onNext(3);
//						sub.onNext(4);
//						sub.onNext(5);
//					}
//
//					@Override
//					public void cancel() {
//
//					}
//				});
//			}
//		};

		Publisher<Integer> pub = sub -> {

			sub.onSubscribe(new Subscription() {

				// 아래 request 메소드 부분을 별도의 스레드에서 실행시키는 것이 목적이다.
				@Override
				public void request(long n) {
						sub.onNext(1);
						sub.onNext(2);
						sub.onNext(3);
						sub.onNext(4);
						sub.onNext(5);
						sub.onComplete();
				}

				@Override
				public void cancel() {
					sub.onError(new Exception());
				}
			});
		};

		Publisher<Integer> subOnPub = sub -> {
			ExecutorService executorService = Executors.newSingleThreadExecutor();
			executorService.execute(() -> pub.subscribe(sub));
		};

		subOnPub.subscribe(new Subscriber<Integer>() {
			@Override
			public void onSubscribe(Subscription s) {
				logger.info("onSubscribe");
				s.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(Integer integer) {
				logger.info("onNext: {}", integer);
			}

			@Override
			public void onError(Throwable t) {
				logger.info("onError: {}", t);
			}

			@Override
			public void onComplete() {
				logger.info("onComplete");
			}
		});

		System.out.println("main thread exit");
	}
}
