package com.example.demo.service;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class TraditionalThreadsService {

  public static void demo1() {
    var counter = new AtomicInteger();
    while (true) {
      new Thread(
              () -> {
                int count = counter.incrementAndGet();
                System.out.println("Thread count: " + count);
                LockSupport.park();
              })
          .start();
    }
  }

  public static void demo2() {
    float startTime = System.nanoTime();
    try (var executor = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())) {
      IntStream.range(0, 100_000)
          .forEach(
              i ->
                  executor.submit(
                      () -> {
                        try {
                          Thread.sleep(2000);
                        } catch (InterruptedException e) {
                          throw new RuntimeException(e);
                        }
                        System.out.println(i);
                        return i;
                      }));
    }
    float endTime = System.nanoTime();
    float elapsedTime = (endTime - startTime) / 1000000000;
    System.out.println("Elapsed time: " + elapsedTime + " seconds");
  }
}
