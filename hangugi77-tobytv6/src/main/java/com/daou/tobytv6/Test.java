package com.daou.tobytv6;

import java.util.Arrays;
import java.util.Iterator;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Test {

	public static void main(String[] args) {
		// Mono.just("Hello world").log().log().map(s ->
		// s.toUpperCase()).log().subscribe(System.out::println);
		// pub.subscribe(sub.onSubscribe(null));

		Iterable<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Publisher<Integer> pub = new Publisher<Integer>() {

			//			Subscription subscription = new Subscription() {
			//
			//				@Override
			//				public void request(long n) {
			//					System.out.println(n);
			//				}
			//
			//				@Override
			//				public void cancel() {
			//					// TODO Auto-generated method stub
			//				}
			//			};

			@Override
			public void subscribe(Subscriber sub) {
				Iterator<Integer> it = list.iterator();

				sub.onSubscribe(new Subscription() {
					@Override
					public void request(long n) {
						System.out.println(n);
						while(true) {
							if(it.hasNext()) {
								sub.onNext(it.next());
							} else {
								sub.onComplete();
								break;
							}
						}
					}

					@Override
					public void cancel() {
						// TODO Auto-generated method stub
					}
				});
			}
		};

		Subscriber<Integer> sub = new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {
				System.out.println("onSubscribe");
				s.request(3);
			}

			@Override
			public void onNext(Integer t) {
				System.out.println("onNext " + t);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("onError");
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}
		};

		pub.subscribe(sub);

		//
		// Iterable<Integer> list = Arrays.asList(1,2,3,4,5);
		//
		// Iterable<Integer> list2 = new Iterable() {
		// @Override
		// public Iterator<Integer> iterator() {
		// return new Iterator() {
		// int i = 0;
		// int max = 10;
		//
		// @Override
		// public boolean hasNext() {
		// return i < max;
		// }
		//
		// @Override
		// public Object next() {
		// return ++i;
		// }
		// };
		// }
		// };
		//
		// for(Integer i: list2) {
		// System.out.println(i);
		// }
	}

	// public static Consumer<Mono<String>> c = (s) -> System.out.println(s);

}
