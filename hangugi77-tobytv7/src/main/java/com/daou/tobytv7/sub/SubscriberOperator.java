package com.daou.tobytv7.sub;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubscriberOperator implements Subscriber<String> {
    private Subscriber subscriber;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public SubscriberOperator(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Subscription s) {
        subscriber.onSubscribe(s);
    }

    @Override
    public void onNext(String s) {
        executorService.execute(() -> {
            subscriber.onNext(s);
        });
    }

    @Override
    public void onError(Throwable t) {
        executorService.execute(() -> {
            subscriber.onError(t);
        });
    }

    @Override
    public void onComplete() {
        executorService.execute(() -> {
            subscriber.onComplete();
        });
    }
}
