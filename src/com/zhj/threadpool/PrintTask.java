package com.zhj.threadpool;

/**
 * Created by zhanghongjun on 2017/2/19.
 */
public class PrintTask implements Task{
    @Override
    public void excute() {
        System.out.println(Thread.currentThread().getName() + " 打印了");
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
