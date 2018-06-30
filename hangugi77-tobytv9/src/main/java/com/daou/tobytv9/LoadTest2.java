package com.daou.tobytv9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class LoadTest2 {
    static AtomicInteger counter = new AtomicInteger(0);
    static int numberOfThread = 3;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThread);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest2?idx={idx}";

        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfThread);

        for(int i = 0; i < numberOfThread; i++) {
            executorService.submit(() -> {
                int idx = counter.addAndGet(1);
//                log.info("Thread {}", idx);

                cyclicBarrier.await();

                StopWatch inner = new StopWatch();
                inner.start();

                String result = restTemplate.getForObject(url, String.class, idx);
//                log.info(Thread.currentThread().getName() + ": " + result);

                inner.stop();
                log.info("Elapsed: {} {} / {}", idx, inner.getTotalTimeSeconds(), result);
                return null;
            });
        }

        cyclicBarrier.await();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        stopWatch.stop();

        log.info("Total: {}", stopWatch.getTotalTimeSeconds());
    }
}
