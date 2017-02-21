package com.zhj.threadpool;

import java.util.LinkedList;

/**
 * Created by zhanghongjun on 2017/2/19.
 * 工作线程
 */
public class Worker implements Runnable {
    //线程运行状态
    protected boolean running = false;

    //任务列表
    protected LinkedList<Task> taskList;

    protected Thread thread;

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    //启动工作线程
    public void start() {
        if (thread != null) {
            running = true;
            thread.start();
        }
    }

    public void shutdown() {
        running = false;
        thread.interrupt();
    }

    public void setTaskList(LinkedList<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public void run() {
        while (running) {
            synchronized (taskList) {
                while (taskList.isEmpty()) {
                    try {
                        taskList.wait();
                    } catch (InterruptedException e) {
                        thread.interrupt();
                        running = false;
                        return;
                    }
                }
            }

            Task task = null;
            synchronized (taskList) {
                    task = taskList.removeFirst();
            }

            if (task != null) {
                task.excute();
            }

        }
    }


}
