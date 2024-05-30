package com.heima.ThreadPool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        long preTime = new Date().getTime();
        ExecutorService executor = Executors.newFixedThreadPool(1); // 创建一个固定大小的线程池
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker); // 调用execute方法启动线程
        }
        executor.shutdown(); // 关闭线程池
        while (!executor.isTerminated()) {
        }
        System.out.println("所有任务已完成"+(new Date().getTime()-preTime));
    }
}

class WorkerThread implements Runnable {
    private String command;

    public WorkerThread(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始处理任务: " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " 完成处理任务: " + command);
    }

    private void processCommand() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
