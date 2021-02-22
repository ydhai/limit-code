package com.ragku.limit;

import java.util.concurrent.*;

/**
 * @author tony
 * @date 2020/4/20
 **/
public class QueueTest {
    private static BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(10);
    private static ThreadFactory threadFactory = Thread::new;
    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 5, 0, TimeUnit.MILLISECONDS,
            blockingQueue, threadFactory, (r, executor) -> {
        System.out.println("---------------");
        r.run();
    });

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello");
            });
        }
    }
}
