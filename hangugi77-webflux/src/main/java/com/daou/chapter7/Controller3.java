package com.daou.chapter7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@RestController
public class Controller3 {
    @GetMapping("/fork1")
    public List<String> forkTest1() {
        List<String> list = new CopyOnWriteArrayList<>();
        LongStream.rangeClosed(1, 50000).parallel().forEach(i -> {
            list.add(Thread.currentThread().getName() + ":" + i);
        });
        return list;
    }

    @GetMapping("/fork2")
    public List<String> forkTest2() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<String> list = new CopyOnWriteArrayList<>();

        LongStream.rangeClosed(1, 50000).forEach(i ->
                CompletableFuture.runAsync(new Runnable() {
                    @Override
                    public void run() {
                        list.add(Thread.currentThread().getName() + ":" + i);
                    }
                }, executorService)
        );
        return list;
    }

    @GetMapping("/fork3")
    public void forkTest3() {
        LongStream.rangeClosed(1, 50000).parallel().forEach(i -> {
            while(true) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
