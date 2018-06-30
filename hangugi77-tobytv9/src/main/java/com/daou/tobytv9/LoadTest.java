package com.daou.tobytv9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class LoadTest {
    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest?idx={idx}";

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for(int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                int idx = counter.addAndGet(1);
//                log.info("Thread {}", idx);

                StopWatch inner = new StopWatch();
                inner.start();

                String result = restTemplate.getForObject(url, String.class, idx);
                log.info(Thread.currentThread().getName() + ": " + result);

                inner.stop();
//                log.info("Elapsed: {} {}", idx, inner.getTotalTimeSeconds());
            });
        }

        stopWatch.stop();

        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
    }
}
