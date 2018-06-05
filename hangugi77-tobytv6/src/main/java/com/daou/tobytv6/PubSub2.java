package com.daou.tobytv6;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class PubSub2 {
	public static void main(String[] args) {
		Publisher<Integer> pub = iterPub(Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList()));
		//Publisher<Integer> mapPub = mapPub(pub, (Function<Integer, Integer>) s -> s * 10);
		Publisher<Integer> mapPub = mapPub(pub, s -> s * 10);
		Publisher<Integer> mapPub2 = mapPub(mapPub, s -> -s);
		mapPub2.subscribe(logSub());
	}

	private static Publisher<Integer> mapPub(Publisher<Integer> pub, Function<Integer, Integer> f) {
		return new Publisher<Integer>() {
			@Override
			public void subscribe(Subscriber<? super Integer> sub) {
				pub.subscribe(new Subscriber<Integer>() {
					@Override
					public void onSubscribe(Subscription s) {
						sub.onSubscribe(s);
					}

					@Override
					public void onNext(Integer t) {
						sub.onNext(f.apply(t));
					}

					@Override
					public void onError(Throwable t) {
						sub.onError(t);
					}

					@Override
					public void onComplete() {
					}
				});
			}
		};
	}

	private static Publisher<Integer> iterPub(Iterable<Integer> iter) {
		return new Publisher<Integer>() {
			@Override
			public void subscribe(Subscriber<? super Integer> sub) {
				sub.onSubscribe(new Subscription() {
					@Override
					public void request(long n) {
						try {
							iter.forEach(s -> sub.onNext(s));
							sub.onComplete();
						} catch(Throwable t) {
							sub.onError(t);
						}
					}

					@Override
					public void cancel() {

					}
				});
			}
		};
	}

	private static Subscriber<Integer> logSub() {
		return new Subscriber<Integer>() {
			@Override
			public void onSubscribe(Subscription s) {
				s.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(Integer t) {
				System.out.println("onNext: " + t);
			}

			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}
		};
	}
}
