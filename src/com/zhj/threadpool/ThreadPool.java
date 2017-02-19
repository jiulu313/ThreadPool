package com.zhj.threadpool;

/**
 * Created by zhanghongjun on 2017/2/19.
 */
public interface ThreadPool {
    void start();
    void shutdown();
    void initWorkers(int num);
    void execute(Task task);

}
